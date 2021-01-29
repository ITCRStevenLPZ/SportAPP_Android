package com.sportapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sportapp.R;
import com.sportapp.database.Conexion;
import com.sportapp.database.Constantes;

public class FlexionesActivity extends AppCompatActivity {
    Conexion conn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexiones);
        conn = new Conexion(this, Constantes.DATABASE_NAME, 1);
        final EditText reps = findViewById(R.id.flexiones_reps);
        final EditText fecha = findViewById(R.id.flexiones_fecha);
        final Button ingresar = findViewById(R.id.flexiones_ingresar);
        final Button consultar = findViewById(R.id.flexiones_consultar);
        final Button logout = findViewById(R.id.logout);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();

                if (extras != null) {
                    int cedula = extras.getInt("cedula");
                    String date = fecha.getText().toString();
                    int repe = Integer.parseInt(reps.getText().toString());

                    boolean ver = conn.insertarFlexiones(cedula,repe,date);
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
                Intent i = new Intent(FlexionesActivity.this, Logout.class);
                startActivity(i);
            }
        });
    }
}
