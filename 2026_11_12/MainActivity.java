package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SeekBar seekBarR = findViewById(R.id.seekBarR);
        SeekBar seekBarG = findViewById(R.id.seekBarG);
        SeekBar seekBarB = findViewById(R.id.seekBarB);
        TextView colorBox = findViewById(R.id.ColorBox);
        Button btn =  findViewById(R.id.button);
        TextView text2 = findViewById(R.id.textView3);
        TextView liczbaR = findViewById(R.id.liczbaR);
        TextView liczbaG = findViewById(R.id.liczbaG);
        TextView liczbaB = findViewById(R.id.liczbaB);

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                liczbaR.setText(String.valueOf(progress));
                int r = seekBarR.getProgress();
                int g = seekBarG.getProgress();
                int b = seekBarB.getProgress();

                colorBox.setBackgroundColor(Color.rgb(r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }

        );
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                liczbaG.setText(String.valueOf(progress));
                int r = seekBarR.getProgress();
                int g = seekBarG.getProgress();
                int b = seekBarB.getProgress();

                colorBox.setBackgroundColor(Color.rgb(r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                liczbaB.setText(String.valueOf(progress));
                int r = seekBarR.getProgress();
                int g = seekBarG.getProgress();
                int b = seekBarB.getProgress();

                colorBox.setBackgroundColor(Color.rgb(r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = seekBarR.getProgress();
                int g = seekBarG.getProgress();
                int b = seekBarB.getProgress();

                colorBox.setBackgroundColor(Color.rgb(r, g, b));
                text2.setBackgroundColor(Color.rgb(r,g,b));
                text2.setText(r + ", " + g + ", "+ b);
            }
        });

    }
}