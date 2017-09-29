package com.example.bailey.mylistview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.bailey.mylistview1.R.id.listView;

public class MainActivity extends AppCompatActivity {
    ListView mylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistView = (ListView) findViewById(listView);

        String[] values = new String[]{"Android List View", "Adapter implementation", "Simple List View In Android", "Create List View Android",
                "Android Example", "List View Source Code", "List View Array Adapter", "Android Example List View"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        mylistView.setAdapter(adapter);

        // ListView Item Click Listener
        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
            // TODO Auto-generated method stub
            // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String itemValue = (String) mylistView.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(), "Position :" + itemPosition + " ListItem : " + itemValue,
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}