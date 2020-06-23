package azz.aziz13.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 100;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithData = findViewById(R.id.btn_move_withData);
        btnMoveWithData.setOnClickListener(this);

        Button btnMoveObjcet = findViewById(R.id.btn_move_object);
        btnMoveObjcet.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_nomor);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveResult = findViewById(R.id.btn_move_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_hasil);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_withData:
                Intent moveData = new Intent(MainActivity.this, MoveWithData.class);
                moveData.putExtra(MoveWithData.EXTRA_NAMA, "Muhamad Abdul Aziz");
                moveData.putExtra(MoveWithData.EXTRA_UMUR, 23);
                startActivity(moveData);
                break;
            case R.id.btn_move_object:
                Person person = new Person();
                person.setNama("Muhamad Abdul Aziz");
                person.setUmur(23);
                person.setEmail("Aziz13.id@gmail.com");
                person.setKota("Jakarta Barat");

                Intent moveObject = new Intent(MainActivity.this, MoveWithObject.class );
                moveObject.putExtra(MoveWithObject.EXTRA_PERSON, person);
                startActivity(moveObject);
                break;
            case R.id.btn_dial_nomor:
                String nomor = "4212";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomor));
                startActivity(dialPhoneIntent);

            case R.id.btn_move_result:
                Intent MoveResult = new Intent(MainActivity.this, MoveWithResultActivity.class);
                startActivityForResult(MoveResult, REQUEST_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveWithResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveWithResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}

