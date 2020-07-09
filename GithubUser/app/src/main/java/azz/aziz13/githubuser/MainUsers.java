package azz.aziz13.githubuser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainUsers extends AppCompatActivity {
    private static final String EXTRA_USER = "Extra User" ;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_users);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final KenBurnsView kbv = (KenBurnsView) findViewById(R.id.bg_image);
        kbv.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {

                kbv.restart();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        fragment = new MapsFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


        TextView username = findViewById(R.id.tv_username);
        TextView perusahaan = findViewById(R.id.tv_perusahaan);
        TextView pengikut = findViewById(R.id.follower);
        TextView mengikuti = findViewById(R.id.following);

        User user = getIntent().getParcelableExtra(EXTRA_USER);
        username.setText("Nama \t" + String.valueOf(user.getUsername()));



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        fragment = new MapsFragment();
                        break;
                    case 1:
                        fragment = new RepoFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}