package com.example.a2026_02_02;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        
        TextView textViewEmail = view.findViewById(R.id.textViewEmail);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewLastName = view.findViewById(R.id.textViewLastName);
        
        if (getArguments() != null) {
            String email = getArguments().getString("email");
            String name = getArguments().getString("name");
            String lastName = getArguments().getString("lastName");
            
            textViewEmail.setText("Email: " + email);
            textViewName.setText("Imie: " + name);
            textViewLastName.setText("Nazwisko: " + lastName);
        }
        
        return view;
    }
}