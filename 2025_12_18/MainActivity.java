package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
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

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final TextView bledy = (TextView) findViewById(R.id.textView6);
                final EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
                final EditText haslo1 = (EditText) findViewById(R.id.editTextTextPassword);
                final EditText haslo2 = (EditText) findViewById(R.id.editTextTextPassword2);
                String haslo1text = haslo1.getText().toString();
                String haslo2text = haslo2.getText().toString();


                String emailString = email.getText().toString();
                if (!emailString.contains("@")){
                    bledy.setText("Nieprawidłowy adres e-mail");
                } else if (!haslo1text.equals(haslo2text)) {
                    bledy.setText("Hasła się różnią");
                }
                else{
                    bledy.setText("Witaj " + emailString);
                }

            }
        });

    }
}