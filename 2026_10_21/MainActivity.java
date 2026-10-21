package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicReference;

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

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView howOld = findViewById(R.id.ileLatText);
        ListView listView = findViewById(R.id.listView);
        Button btn = findViewById(R.id.btn);
        EditText nameSurname = findViewById(R.id.editTextImie);
        EditText purpose = findViewById(R.id.editTextCel);
        EditText time = findViewById(R.id.editTextText3);
        TextView textView = findViewById(R.id.textView3);


        String[] animals = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        listView.setAdapter(adapter);

        AtomicReference<String> SelectedAnimal = new AtomicReference<>("");

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAnimal = adapter.getItem(position);
            SelectedAnimal.set(selectedAnimal);
            switch (selectedAnimal){
                case "Pies":
                    seekBar.setMax(18);
                    break;
                case "Kot":
                    seekBar.setMax(20);
                    break;
                case "Świnka morska":
                    seekBar.setMax(9);
                    break;
            }

        });
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {
                        howOld.setText("Ile ma lat? " + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
        btn.setOnClickListener(v->{

            textView.setText(nameSurname.getText() + ", " + SelectedAnimal.get() + ", " + seekBar.getProgress() + ", "+ purpose.getText() + ", "+ time.getText());
        });
    }
}