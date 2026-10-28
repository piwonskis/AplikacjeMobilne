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

        Button btnSzyfruj = findViewById(R.id.ZaszyfrujBtn);
        Button btnZapisz = findViewById(R.id.buttonZapisz);

        btnSzyfruj.setOnClickListener(v->{
            EditText kluczText = findViewById(R.id.editNum);
            int klucz = 0;
            klucz = Integer.parseInt(kluczText.getText().toString().trim());
            EditText tekstEdit = findViewById(R.id.editText);
            TextView zaszyfrowany = findViewById(R.id.wynikiText);
            String tekst = tekstEdit.getText().toString().trim();
            char[] tekstTab = tekst.toCharArray();
            char[] finalnyTekst = new char[tekstTab.length];
            String tekstZaszyfr = "";
            String alfabet = "abcdefghijklmnopqrstuvwxyz";
            char[] alfabetTab = alfabet.toCharArray();
            for (int i=0; i<tekstTab.length; i++){
                for (int j=0; j<alfabetTab.length;j++){
                    if (tekstTab[i] == alfabetTab[j]){
                        finalnyTekst[i] = alfabetTab[(j+klucz)%alfabetTab.length];
                    }
                }
            }
            zaszyfrowany.setText(new String(finalnyTekst));
        });

        btnZapisz.setOnClickListener(v->{

        });
    }
}