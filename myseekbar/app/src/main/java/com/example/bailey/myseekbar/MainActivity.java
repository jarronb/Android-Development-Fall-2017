package com.example.bailey.myseekbar;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar mySeekBar;
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mySeekBar = (SeekBar)findViewById(R.id.seekBar);
        myTextView = (TextView)findViewById(R.id.textView);

       mySeekBar.setMax(100);
        mySeekBar.setProgress(100);
        myTextView.setText(""+mySeekBar.getProgress());
        regEvents();

    }

   public void regEvents() {
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int currenval = mySeekBar.getProgress();
                myTextView.setText(mySeekBar.getProgress());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
