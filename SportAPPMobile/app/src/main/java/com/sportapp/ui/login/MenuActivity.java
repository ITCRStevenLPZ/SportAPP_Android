package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.database.Conexion;
import com.sportapp.database.Constantes;

import android.view.View;
import android.widget.Button;

import com.sportapp.R;


public class MenuActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final Button frecuencias = findViewById(R.id.menu_frecuencias);
        final Button pesos = findViewById(R.id.menu_pesos);
        final Button tests = findViewById(R.id.menu_tests);
        final Button logout = findViewById(R.id.logout);

        frecuencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");

                    Intent i = new Intent(MenuActivity.this, FrecuenciasActivity.class);
                    i.putExtra("cedula",cedula);
                    i.putExtra("usuario",usuario);
                    i.putExtra("contrasena",contrasena);
                    startActivity(i);
                }
            }
        });
        pesos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");

                    Intent i = new Intent(MenuActivity.this, PesosActivity.class);
                    i.putExtra("cedula",cedula);
                    i.putExtra("usuario",usuario.toString());
                    i.putExtra("contrasena",contrasena.toString());
                    startActivity(i);
                }
            }
        });
        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");

                    Intent i = new Intent(MenuActivity.this, TestsActivity.class);
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
                Intent i = new Intent(MenuActivity.this, Logout.class);
                startActivity(i);
            }
        });
    }

}