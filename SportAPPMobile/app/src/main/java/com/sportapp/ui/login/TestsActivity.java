package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.database.Conexion;
import com.sportapp.database.Constantes;

import android.view.View;
import android.widget.Button;

import com.sportapp.R;


public class TestsActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmenu);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final Button logout = findViewById(R.id.logout);
        final Button cooper = findViewById(R.id.test_cooper);
        final Button flexiones = findViewById(R.id.test_flexiones);

        cooper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");

                    Intent i = new Intent(TestsActivity.this, CooperActivity.class);
                    i.putExtra("cedula",cedula);
                    i.putExtra("usuario",usuario.toString());
                    i.putExtra("contrasena",contrasena.toString());
                    startActivity(i);
                }
            }
        });
        flexiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");

                    Intent i = new Intent(TestsActivity.this, FlexionesActivity.class);
                    i.putExtra("cedula",cedula);
                    i.putExtra("usuario",usuario.toString());
                    i.putExtra("contrasena",contrasena.toString());
                    startActivity(i);
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TestsActivity.this, Logout.class);
                startActivity(i);
            }
        });
    }

}