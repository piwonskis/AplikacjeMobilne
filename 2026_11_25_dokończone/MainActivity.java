package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbPocztowka;
    private RadioButton rbList;
    private RadioButton rbPaczka;
    private EditText etUlica;
    private EditText etKod;
    private EditText etMiasto;
    private ImageView imageView;
    private TextView tvCena;
    private Button btnCena;
    private Button btnZatwierdz;

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

        inicjalizujWidoki();

        btnCena.setOnClickListener(v -> sprawdzCene());
        btnZatwierdz.setOnClickListener(v -> zatwierdzDane());
    }

    private void inicjalizujWidoki() {
        rbPocztowka = findViewById(R.id.rbPocztowka);
        rbList = findViewById(R.id.rbList);
        rbPaczka = findViewById(R.id.rbPaczka);
        etUlica = findViewById(R.id.etUlica);
        etKod = findViewById(R.id.etKod);
        etMiasto = findViewById(R.id.etMiasto);
        imageView = findViewById(R.id.imageView);
        tvCena = findViewById(R.id.tvCena);
        btnCena = findViewById(R.id.btnCena);
        btnZatwierdz = findViewById(R.id.btnZatwierdz);
    }

    private void sprawdzCene() {
        if (rbPocztowka.isChecked()) {
            imageView.setImageResource(R.drawable.pocztowka);
            tvCena.setText("Cena: 1 zł");
        } else if (rbList.isChecked()) {
            imageView.setImageResource(R.drawable.list);
            tvCena.setText("Cena: 1,5 zł");
        } else if (rbPaczka.isChecked()) {
            imageView.setImageResource(R.drawable.paczka);
            tvCena.setText("Cena: 10 zł");
        }
    }

    private void zatwierdzDane() {
        String kod = etKod.getText().toString();

        if (kod.length() != 5) {
            pokazKomunikat("Nieprawidłowa liczba cyfr w kodzie pocztowym");
        } else if (!czySameCyfry(kod)) {
            pokazKomunikat("Kod pocztowy powinien się składać z samych cyfr");
        } else {
            pokazKomunikat("Dane przesyłki zostały wprowadzone");
        }
    }

    private boolean czySameCyfry(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            if (!Character.isDigit(tekst.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void pokazKomunikat(String komunikat) {
        Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
    }
}