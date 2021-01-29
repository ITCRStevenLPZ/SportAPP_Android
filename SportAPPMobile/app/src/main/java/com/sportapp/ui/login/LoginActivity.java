package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.database.Conexion;
import com.sportapp.database.Constantes;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sportapp.R;


public class LoginActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button registerButton = findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = passwordEditText.getText().toString();
                String user = usernameEditText.getText().toString();
                Boolean ver = conn.iniciarSesion(user,pass);
                Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                i.putExtra("cedula",1111);
                i.putExtra("usuario","admin");
                i.putExtra("contrasena","admin");
                startActivity(i);

                /*if(ver == true){
                    Toast.makeText(getApplicationContext(), "Bienvenido de vuelta, "+user, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "No se ha encontrado al usuario , "+user+" o se ha ingresado la contraseña mal!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(i);
                }*/


            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity1.class);
                startActivity(i);
            }
        });
    }

}