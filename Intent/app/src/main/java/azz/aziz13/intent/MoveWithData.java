package azz.aziz13.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithData extends AppCompatActivity {
    public static final String EXTRA_UMUR = "extra_umur";
    public static final String EXTRA_NAMA = "extra_nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        TextView tvTerimaData = findViewById(R.id.tv_data_terima);

        String name = getIntent().getStringExtra(EXTRA_NAMA);
        int umur = getIntent().getIntExtra(EXTRA_UMUR,0);

        String text = "Nama : " + name + ", Dengan Umur : " + umur;
        tvTerimaData.setText(text);

    }
}