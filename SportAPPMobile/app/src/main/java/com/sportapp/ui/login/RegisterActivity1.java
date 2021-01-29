package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.database.Conexion;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sportapp.R;


public class RegisterActivity1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText cedula = findViewById(R.id.cedula);
        final EditText nombre = findViewById(R.id.name);
        final EditText primerApellido = findViewById(R.id.lastname);
        final EditText segundoApellido = findViewById(R.id.lastname2);
        final EditText fechaNacimiento = findViewById(R.id.nacimiento);
        final Button siguiente = findViewById(R.id.reg_next);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity1.this, RegisterActivity2.class);
                i.putExtra("cedula",Integer.parseInt(cedula.getText().toString()));
                i.putExtra("nombre",nombre.getText().toString());
                i.putExtra("primerApellido",primerApellido.getText().toString());
                i.putExtra("segundoApellido",segundoApellido.getText().toString());
                i.putExtra("fechaNacimiento",fechaNacimiento.getText().toString());
                startActivity(i);
            }
        });
    }

}