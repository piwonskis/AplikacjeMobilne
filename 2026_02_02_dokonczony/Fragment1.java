package com.example.a2026_02_02;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private EditText editTextEmail, editTextName, editTextLastName;
    
    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        
        editTextEmail = view.findViewById(R.id.editTextTextEmailAddress);
        editTextName = view.findViewById(R.id.editTextText2);
        editTextLastName = view.findViewById(R.id.editTextText3);
        Button btnNext = view.findViewById(R.id.btnNext);
        
        btnNext.setText("Dalej");
        
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
        
        return view;
    }
    
    private void validateData() {
        String email = editTextEmail.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        
        if (email.isEmpty() || name.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(getContext(), "Wszystkie pola są wymagane!", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (!email.contains("@") || !email.contains(".")) {
            Toast.makeText(getContext(), "Podaj poprawny adres e-mail!", Toast.LENGTH_SHORT).show();
            return;
        }
        
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("name", name);
        bundle.putString("lastName", lastName);
        fragment2.setArguments(bundle);
        
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showFragment(fragment2);
        }
    }
}