package edu.zsk.a13_04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

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
        Button button = findViewById(R.id.button);
        AtomicInteger licz = new AtomicInteger();
        button.setOnClickListener(v->{
            EditText editName = findViewById(R.id.editName);
            String name = editName.getText().toString();
            EditText editEmail = findViewById(R.id.editEmail);
            String email = editEmail.getText().toString();

            TextView txt1 = findViewById(R.id.txt1);
            TextView txt2 = findViewById(R.id.txt2);
            if(name.isEmpty()|| email.isEmpty()){
                Toast.makeText(this,"Najpierw uzupełnij swoje dane",Toast.LENGTH_SHORT).show();
            }
            else{
                licz.getAndIncrement();
                txt2.setText("Kliknąłeś pzycisk "+ licz +" razy");
                txt1.setText("Witaj "+name + "! Twoj adres e-mail to "+ email);
            }
        });
    }
}