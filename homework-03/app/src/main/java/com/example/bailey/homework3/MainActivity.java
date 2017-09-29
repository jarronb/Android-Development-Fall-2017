package com.example.bailey.homework3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import static com.example.bailey.homework3.R.id.sb;

public class MainActivity extends AppCompatActivity {
    TextView celdeg, fardeg, celtext, fartext, minfar, maxfar, tvfeel;
    ImageView Pic;
    SeekBar myseekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbarAction();
    }

    public void seekbarAction() {

        celdeg = (TextView) findViewById(R.id.tvCelDeg);
        fardeg = (TextView) findViewById(R.id.tvFarDeg);
        celtext = (TextView) findViewById(R.id.tvCel);
        fartext = (TextView) findViewById(R.id.tvFartext);
        minfar = (TextView) findViewById(R.id.tvMinFar);
        maxfar = (TextView) findViewById(R.id.tvMaxFar);
        tvfeel = (TextView)findViewById(R.id.textView9);
        myseekbar=(SeekBar)findViewById(sb);
        Pic = (ImageView)findViewById(R.id.imgPlace);
        myseekbar.setMax(200);
        myseekbar.setProgress(0);

        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                double xprogress = (double) progress/1.00;
               // C = (5/9)*(F-32)
               double valcelsius = ((xprogress-32.00) * (5/9.0));
               String txtcel = String.format("%.2f", valcelsius);
                String txtfar = String.format("%.2f", xprogress);
                celdeg.setText(txtcel);
                fardeg.setText(txtfar);

               if (xprogress <= 40.00) {
                    tvfeel.setText("TOO COLD !!!");
                    tvfeel.setBackgroundColor(Color.BLUE);
                   Pic.setImageResource(R.drawable.ic_cold);

                }
                if ((xprogress > 40.00) && (xprogress < 90.00)) {
                    tvfeel.setText("JUST RIGHT !");
                    tvfeel.setBackgroundColor(Color.GREEN);
                   Pic.setImageResource(R.drawable.ic_warm);
                }
                if (xprogress >= 90.00) {
                    tvfeel.setText("TOO HOT !!!");
                    tvfeel.setBackgroundColor(Color.RED);
                    Pic.setImageResource(R.drawable.ic_hot);
                }



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
