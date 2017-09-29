package com.example.bailey.listviewexample;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list;
        final String[] citynames = { "Bjing", "Chicago", "London", "Paris",
                "Shanghai"};
        final Integer[] imageid = { R.drawable.bejing, R.drawable.chicago, R.drawable.london,
                R.drawable.paris, R.drawable.shanghai};

        CustomListAdapter adapter = new CustomListAdapter(this, citynames,
                imageid);

        list = (ListView) findViewById (R.id.citylist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                String Slecteditem= citynames[+position];
                Toast.makeText(getApplicationContext(),
                        Slecteditem, Toast.LENGTH_LONG).show();
            }
        });
    }
}
