package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String maleLitery = "abcdefghijklmnopqrstuvwxyz";
    private final String wielkieLitery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String cyfry = "0123456789";
    private final String znakiSpecjalne = "!@#$%^&*()_+-=";

    private String haslo = "";

    private EditText editImie;
    private EditText editNazwisko;
    private EditText editIleZnakow;
    private Spinner spinnerStanowisko;
    private CheckBox checkLitery;
    private CheckBox checkCyfry;
    private CheckBox checkSpecjalne;
    private Button btnGeneruj;
    private Button btnZatwierdz;

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicjalizujKontrolki();
        ustawListaStanowisk();

        btnGeneruj.setOnClickListener(v -> generujHaslo());
        btnZatwierdz.setOnClickListener(v -> zatwierdzDane());
    }

    private void inicjalizujKontrolki() {
        editImie = findViewById(R.id.editImie);
        editNazwisko = findViewById(R.id.editNazwisko);
        editIleZnakow = findViewById(R.id.editIleZnakow);
        spinnerStanowisko = findViewById(R.id.spinnerStanowisko);
        checkLitery = findViewById(R.id.checkLitery);
        checkCyfry = findViewById(R.id.checkCyfry);
        checkSpecjalne = findViewById(R.id.checkSpecjalne);
        btnGeneruj = findViewById(R.id.btnGeneruj);
        btnZatwierdz = findViewById(R.id.btnZatwierdz);
    }

    private void ustawListaStanowisk() {
        String[] stanowiska = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, stanowiska);
        spinnerStanowisko.setAdapter(adapter);
    }

    private void generujHaslo() {
        int dlugosc;
        try {
            dlugosc = Integer.parseInt(editIleZnakow.getText().toString());
        } catch (NumberFormatException e) {
            dlugosc = 0;
        }
        if (dlugosc <= 0) {
            return;
        }

        StringBuilder noweHaslo = new StringBuilder();
        for (int i = 0; i < dlugosc; i++) {
            noweHaslo.append(losujZnak(maleLitery));
        }

        if (checkCyfry.isChecked()) {
            noweHaslo.setCharAt(0, losujZnak(cyfry));
        }
        if (checkSpecjalne.isChecked() && dlugosc > 1) {
            noweHaslo.setCharAt(1, losujZnak(znakiSpecjalne));
        }
        if (checkLitery.isChecked() && dlugosc > 2) {
            noweHaslo.setCharAt(2, losujZnak(wielkieLitery));
        }

        haslo = noweHaslo.toString();
        Toast.makeText(this, haslo, Toast.LENGTH_SHORT).show();
    }

    private char losujZnak(String zestaw) {
        return zestaw.charAt(random.nextInt(zestaw.length()));
    }

    private void zatwierdzDane() {
        String imie = editImie.getText().toString();
        String nazwisko = editNazwisko.getText().toString();
        String stanowisko = spinnerStanowisko.getSelectedItem().toString();

        String komunikat = "Dane pracownika: " + imie + " " + nazwisko + " "
                + stanowisko + " Hasło: " + haslo;
        Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
    }
}
