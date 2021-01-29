package com.sportapp.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion extends SQLiteOpenHelper {


    public Conexion(@Nullable Context context, String name, int version) {
        super(context,name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.TABLA_USUARIOS);
        db.execSQL(Constantes.TABLA_REGISTRO);
        db.execSQL(Constantes.TABLA_PESOS);
        db.execSQL(Constantes.TABLA_USUARIO_PESOS);
        db.execSQL(Constantes.TABLA_FRECUENCIAS);
        db.execSQL(Constantes.TABLA_USUARIO_FRECUENCIAS);
        db.execSQL(Constantes.TABLA_COOPER);
        db.execSQL(Constantes.TABLA_COOPER_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constantes.DROP_USUARIOS_PESOS);
        db.execSQL(Constantes.DROP_USUARIOS_FRECUENCIAS);
        db.execSQL(Constantes.DROP_REGISTRO);
        db.execSQL(Constantes.DROP_PESOS);
        db.execSQL(Constantes.DROP_FRECUENCIAS);
        db.execSQL(Constantes.DROP_USUARIOS);
        db.execSQL(Constantes.DROP_USUARIOS_COOPER);
        db.execSQL(Constantes.DROP_COOPER);
        onCreate(db);
    }

    public Boolean insertar (String nombre, String primerApellido, String segundoApellido, int cedula, int altura, int telefono,
                             String sexo, String fechaNacimiento, String nombreUsuario, String contrasena, String respuesta1, String respuesta2, String respuesta3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("primer_apellido", primerApellido);
        contentValues.put("segundo_apellido", segundoApellido);
        contentValues.put("numero_cedula", cedula);
        contentValues.put("altura", altura);
        contentValues.put("telefono", telefono);
        contentValues.put("sexo", sexo);
        contentValues.put("fecha_nacimiento", fechaNacimiento);

        contentValues2.put("numero_cedula",cedula);
        contentValues2.put("nombre_usuario", nombreUsuario);
        contentValues2.put("contrasena", contrasena);
        contentValues2.put("res_pre_1", respuesta1);
        contentValues2.put("res_pre_2", respuesta2);
        contentValues2.put("res_pre_3", respuesta3);

        long result = db.insert("usuarios", null, contentValues);
        long result2 = db.insert("registro", null, contentValues2);
        if (result == -1 || result2 == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean insertarFrecuencia(int cedula, int frecuencia, String fecha, String descripcion){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();

        contentValues.put("descripcion", descripcion);
        contentValues.put("fecha", fecha);
        contentValues.put("frecuencia", frecuencia);

        contentValues2.put("numero_cedula",cedula);

        long result = db.insert("frecuencias", null, contentValues);
        long result2 = db.insert("usuario_frecuencias", null, contentValues2);
        if (result == -1 || result2 == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean iniciarSesion(String usuario, String contrasena){
        SQLiteDatabase db = this.getWritableDatabase();

        String consulta = "select nombre_usuario from registro where contrasena = "  +contrasena;
        try{
            Cursor fila  =  db.rawQuery(consulta,null);
            if(fila.moveToFirst()){
                if(fila.getString(0) != usuario){
                    System.out.println(usuario + contrasena);
                    return false;

                }else{
                    return true;
                }
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }

    }

    public boolean insertarPesos(int cedula, int pesos, String date, String descrip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();

        contentValues.put("descripcion", descrip);
        contentValues.put("fecha", date);
        contentValues.put("peso", pesos);

        contentValues2.put("numero_cedula",cedula);

        long result = db.insert("pesos", null, contentValues);
        long result2 = db.insert("usuario_pesos", null, contentValues2);
        if (result == -1 || result2 == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertarCooper(int cedula, int distancia, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        String resultado = null;
        if(distancia>2000){
            resultado = "Buena";
        }else if(distancia>5000){
            resultado = "Excelente";
        }else{
            resultado = "Mala";
        }

        contentValues.put("fecha_test", date);
        contentValues.put("distancia", date);
        contentValues.put("resultado", resultado);

        contentValues2.put("numero_cedula",cedula);

        long result = db.insert("cooper", null, contentValues);
        long result2 = db.insert("usuario_cooper", null, contentValues2);
        if (result == -1 || result2 == -1) {
            return false;
        } else {
            return true;
        }
    }
}
