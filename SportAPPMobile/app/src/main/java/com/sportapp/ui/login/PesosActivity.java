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


public class PesosActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peso);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final EditText pesos = findViewById(R.id.peso_peso);
        final EditText fecha = findViewById(R.id.peso_fecha);
        final EditText descripcion = findViewById(R.id.peso_descripcion);
        final Button ingresar = findViewById(R.id.peso_ingresar);
        final Button consultar = findViewById(R.id.peso_consultar);
        final Button logout = findViewById(R.id.logout);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    //String usuario = extras.getString("usuario");
                    //String contrasena = extras.getString("contrasena");
                    int pes = Integer.parseInt(pesos.getText().toString());
                    String date = fecha.getText().toString();
                    String descrip = descripcion.getText().toString();

                    boolean ver = conn.insertarPesos(cedula,pes,date,descrip);
                    if(ver == true){
                        Toast.makeText(getApplicationContext(), "Se ha ingresado una frecuencia de manera correcta", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "No se ha podido ingresar la frecuencia", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PesosActivity.this, Logout.class);
                startActivity(i);
            }
        });
    }

}