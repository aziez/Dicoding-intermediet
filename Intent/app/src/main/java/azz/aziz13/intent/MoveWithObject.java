package azz.aziz13.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObject = findViewById(R.id.tv_object_terima);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String Text = "Nama \t: " + person.getNama() + " \n Email \t: " + person.getEmail() + "\n Umur \t: " + person.getUmur() + "\n Kota \t: " + person.getKota();
        tvObject.setText(Text);
    }
}