package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

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
        ListView listView = findViewById(R.id.listView);
        String[] gatunki = {"Pies", "Kot", "Świnka morska"};
        SeekBar seekbar = findViewById(R.id.seekBar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                gatunki
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent,view,position,id)->{
            String wybranyGatunek = gatunki[position];
            switch(wybranyGatunek) {
                case "Pies":
                    seekbar.setMax(18);
                    break;
                case "Kot":
                    seekbar.setMax(20);
                    break;
                case "Świnka morska":
                    seekbar.setMax(9);
                    break;
            }
        });
    }


}