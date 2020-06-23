package azz.aziz13.volume_3d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth,edtLength,edtHeight;
    private Button btnHasil;
    private TextView tvHasil;
    private static final String STATE_RESULT = "state_result";

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_hight);
        edtLength = findViewById(R.id.edt_long);
        btnHasil = findViewById(R.id.btn_calculate);
        tvHasil = findViewById(R.id.hasil);

        btnHasil.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(result);
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate){
            String inputPanjnag = edtLength.getText().toString().trim();
            String inputLebar = edtWidth.getText().toString().trim();
            String inputTinggi = edtHeight.getText().toString().trim();
            boolean isEmpty = false;

            if (TextUtils.isEmpty(inputPanjnag)){
                isEmpty = true;
                edtLength.setError("Field Ini harus diisi...!!");
            }
            if (TextUtils.isEmpty(inputLebar)){
                isEmpty = true;
                edtWidth.setError("Field Ini harus diisi...!!");
            }
            if (TextUtils.isEmpty(inputTinggi)){
                isEmpty = true;
                edtHeight.setError("Field Ini harus diisi...!!");
            }

            if (!isEmpty){
            double volume = Double.valueOf(inputPanjnag)*Double.valueOf(inputLebar)*Double.valueOf(inputTinggi);
            tvHasil.setText(String.valueOf(volume));
            }
        }
    }
}