package com.example.fragmentwa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //TODO menambahkan fragment
        adapter.AddFragment(new FragmentListChat(), "");
        adapter.AddFragment(new FragmentProfile(),"");
        adapter.AddFragment(new FrgamentListUser(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_chat);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_supervisor);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


    }
}

