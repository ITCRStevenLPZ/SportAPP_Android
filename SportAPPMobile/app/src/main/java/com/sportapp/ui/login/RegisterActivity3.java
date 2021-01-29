package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.database.Conexion;
import com.sportapp.database.Constantes;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sportapp.R;


public class RegisterActivity3 extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register3);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final TextView color = findViewById(R.id.color);
        final EditText altura = findViewById(R.id.reg_altura);
        final EditText respuesta1 = findViewById(R.id.reg_color);
        final EditText respuesta2 = findViewById(R.id.reg_sport);
        final EditText respuesta3 = findViewById(R.id.reg_origin);
        final Button atras = findViewById(R.id.reg_back2);
        final Button registrar = findViewById(R.id.reg_register);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String nombre = extras.getString("nombre");
                    String primerApellido = extras.getString("primerApellido");
                    String segundoApellido = extras.getString("segundoApellido");
                    String fechaNacimiento = extras.getString("fechaNacimiento");
                    int telefono = extras.getInt("telefono");
                    String usuario = extras.getString("usuario");
                    String contrasena = extras.getString("contrasena");
                    String sexo = extras.getString("sexo");
                    int alto = Integer.parseInt(altura.getText().toString());
                    String res1 = respuesta1.getText().toString();
                    String res2 = respuesta2.getText().toString();
                    String res3 = respuesta3.getText().toString();

                    boolean ver = conn.insertar(nombre,primerApellido,segundoApellido,cedula,alto,telefono,sexo,fechaNacimiento,usuario,contrasena,res1,res2,res3);
                    if(ver == true){
                        Toast.makeText(getApplicationContext(), "Se ha registrado de manera exitosa", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(RegisterActivity3.this, MenuActivity.class);
                        i.putExtra("cedula",cedula);
                        i.putExtra("usuario",usuario.toString());
                        i.putExtra("contrasena",contrasena.toString());
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "No se ha podido registrar", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(RegisterActivity3.this, RegisterActivity1.class);
                        startActivity(i);
                    }

                }
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity3.this, RegisterActivity2.class);
                startActivity(i);
            }
        });
    }

}