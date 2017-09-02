package fdsa.application_language;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {

    private ArrayAdapter mArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArrayAdapter = new ArrayAdapter(this, R.layout.listitem);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(mArrayAdapter);
    }

    public void translate(View v) {
        TextView tv = (TextView)findViewById(R.id.edittext);
        String input = tv.getText().toString();


        mArrayAdapter.clear();
        for(int i = 0; i < 10; i++)
            mArrayAdapter.add(input);

    }

}

