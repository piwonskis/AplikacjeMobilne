package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        ListView listView = findViewById(R.id.lista);
        ArrayList<String> zadania = new ArrayList<>();
        zadania.add("Zakupy: chleb, masło, ser");
        zadania.add("Do zrobienia: obiad, umyć podłogi");
        zadania.add("Weekend: kino, spacer z psem");

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, zadania);
        listView.setAdapter(arr);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextText);
        button.setOnClickListener(v->{
            zadania.add(editText.getText().toString());
            listView.setAdapter(arr);

        });
    }
}