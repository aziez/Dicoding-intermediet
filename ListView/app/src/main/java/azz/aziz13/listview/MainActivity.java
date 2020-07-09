package azz.aziz13.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String dataNama[] = {getString(R.string.cyn), "Ki Hajar dewantara","Moh Yamin","Patimura", "Ra Kartini","Soekarno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, dataNama);
        listView.setAdapter(adapter);
    }
}