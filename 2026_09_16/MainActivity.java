package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean odkurzaczWlaczony = false;

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

        Button zatwierdzButton = findViewById(R.id.zatwierdz);
        EditText numerPraniaEditText = findViewById(R.id.editTextText);
        TextView numerPraniaTextView = findViewById(R.id.textView4);
        Button odkurzaczButton = findViewById(R.id.wlacz);
        TextView stanOdkurzaczaTextView = findViewById(R.id.textView6);

        zatwierdzButton.setOnClickListener(v -> {
            String tekst = numerPraniaEditText.getText().toString().trim();
            if (tekst.isEmpty()) {
                return;
            }
            try {
                int numerPrania = Integer.parseInt(tekst);
                if (numerPrania >= 1 && numerPrania <= 12) {
                    numerPraniaTextView.setText("Numer prania: " + numerPrania);
                }
            } catch (NumberFormatException e) {
            }
        });

        odkurzaczButton.setOnClickListener(v -> {
            odkurzaczWlaczony = !odkurzaczWlaczony;
            if (odkurzaczWlaczony) {
                odkurzaczButton.setText("Wyłącz");
                stanOdkurzaczaTextView.setText("Odkurzacz włączony");
            } else {
                odkurzaczButton.setText("Włącz");
                stanOdkurzaczaTextView.setText("Odkurzacz wyłączony");
            }
        });
    }
}