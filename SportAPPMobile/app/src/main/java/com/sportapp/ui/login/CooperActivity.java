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


public class CooperActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cooper);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final EditText distance = findViewById(R.id.cooper_distancia);
        final EditText fecha = findViewById(R.id.cooper_fecha);
        final Button ingresar = findViewById(R.id.cooper_ingresar);
        final Button consultar = findViewById(R.id.cooper_consultar);
        final Button logout = findViewById(R.id.logout);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String date = fecha.getText().toString();
                    int distanc = Integer.parseInt(distance.getText().toString());

                    boolean ver = conn.insertarCooper(cedula,distanc,date);
                    if(ver == true){
                        Toast.makeText(getApplicationContext(), "Se ha ingresado un test de Cooper de manera correcta", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "No se ha podido ingresar el test de Cooper", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CooperActivity.this, Logout.class);
                startActivity(i);
            }
        });
    }

}