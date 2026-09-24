    package zsk.edu.myapplication;

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
    private TextView rozmiarText;
    private TextView witanieText;
    private SeekBar seekBar;
    private Button button;

    private String[] napisy = {
            "Dzień dobry",
            "Good morning",
            "Buenos dias"
    };

    private Integer indeksNapis = 0;

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
        rozmiarText = findViewById(R.id.rozmiarText);
        witanieText = findViewById(R.id.witanieText);
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);

        seekBar.setProgress(20);

        rozmiarText.setText("Rozmiar: "+ seekBar.getProgress());

        button.setOnClickListener(v->{
            indeksNapis++;
            if (indeksNapis>=napisy.length){
                indeksNapis = 0;
            }
            witanieText.setText(napisy[indeksNapis]);
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<1){
                    progress = 1;
                    seekBar.setProgress(1);
                }
                witanieText.setTextSize(progress);
                rozmiarText.setText("Rozmiar: "+ seekBar.getProgress());
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