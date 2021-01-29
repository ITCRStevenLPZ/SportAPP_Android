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
        final Button frecuencias = findViewById(R.id.menu_frecuencias);
        final Button pesos = findViewById(R.id.menu_pesos);
        final Button tests = findViewById(R.id.menu_tests);

    }

}