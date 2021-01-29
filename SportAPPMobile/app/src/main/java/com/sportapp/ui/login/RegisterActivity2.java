package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sportapp.R;


public class RegisterActivity2 extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);


        final EditText telefono = findViewById(R.id.phone);
        final EditText usuario = findViewById(R.id.reg_username);
        final EditText contrasena = findViewById(R.id.reg_password);
        final EditText sexo = findViewById(R.id.reg_gender);
        final Button atras = findViewById(R.id.reg_back);
        final Button siguiente = findViewById(R.id.reg_next2);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String nombre = extras.getString("nombre");
                    String primerApellido = extras.getString("primerApellido");
                    String segundoApellido = extras.getString("segundoApellido");
                    String fechaNacimiento = extras.getString("fechaNacimiento");
                    Intent i = new Intent(RegisterActivity2.this, RegisterActivity3.class);
                    i.putExtra("cedula",cedula);
                    i.putExtra("nombre",nombre);
                    i.putExtra("primerApellido",primerApellido);
                    i.putExtra("segundoApellido",segundoApellido);
                    i.putExtra("fechaNacimiento",fechaNacimiento);
                    i.putExtra("telefono",Integer.parseInt(telefono.getText().toString()));
                    i.putExtra("usuario",usuario.getText().toString());
                    i.putExtra("contrasena",contrasena.getText().toString());
                    i.putExtra("sexo",sexo.getText().toString());
                    startActivity(i);
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity2.this, RegisterActivity1.class);
                startActivity(i);
            }
        });
    }

}