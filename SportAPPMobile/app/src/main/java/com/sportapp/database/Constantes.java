package com.sportapp.database;

public class Constantes {

    public static final String DATABASE_NAME = "sportapp.db";
    public static String TABLA_USUARIOS =
            "CREATE TABLE usuarios(" +
            "nombre TEXT NOT NULL," +
            "primer_apellido TEXT NOT NULL," +
            "segundo_apellido TEXT NOT NULL," +
            "numero_cedula  INTEGER PRIMARY KEY," +
            "altura TEXT NOT NULL," +
            "telefono integer," +
            "sexo text not null," +
            "fecha_nacimiento date" +
            ")";
    public static String TABLA_REGISTRO =
            "create table registro(" +
            "numero_cedula integer," +
            "nombre_usuario text primary key," +
            "contrasena text not null," +
            "res_pre_1 text," +
            "res_pre_2 text," +
            "res_pre_3 text," +
            "foreign key (numero_cedula) references usuarios(numero_cedula)" +
            ")";
    public static String TABLA_PESOS =
            "create table pesos(" +
                    "id_pesos INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "descripcion text," +
                    "fecha date not null," +
                    "peso integer not null" +
                    ")";
    public static String TABLA_USUARIO_PESOS =
            "create table usuario_pesos(" +
            "numero_cedula integer not null," +
            "id_pesos INTEGER PRIMARY KEY AUTOINCREMENT," +
            "foreign key (numero_cedula) references usuarios(numero_cedula)" +
            ")";
    public static String TABLA_FRECUENCIAS =
            "create table frecuencias(" +
            "id_frecuencias INTEGER PRIMARY KEY AUTOINCREMENT," +
            "descripcion text," +
            "fecha date not null," +
            "frecuencia integer not null" +
            ")";
    public static String TABLA_USUARIO_FRECUENCIAS =
            "create table usuario_frecuencias(" +
            "numero_cedula integer not null," +
            "id_frecuencias INTEGER PRIMARY KEY AUTOINCREMENT," +
            "foreign key (numero_cedula) references usuarios(numero_cedula)"+
            ")";
    public static String TABLA_COOPER =
            "create table cooper(" +
            "id_cooper INTEGER PRIMARY KEY AUTOINCREMENT," +
            "fecha_test date not null," +
            "distancia number not null," +
            "resultado text" +
            ")";
    public static String TABLA_COOPER_USUARIO =
            "create table usuario_cooper(" +
                    "numero_cedula integer not null," +
                    "id_cooper INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "foreign key (numero_cedula) references usuarios(numero_cedula)" +
                    ")";
    public static String TABLA_FLEXIONES =
            "create table flexiones(" +
                    "id_flexiones INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "fecha_test date not null," +
                    "repeticiones number not null," +
                    "resultado text" +
                    ")";
    public static String TABLA_FLEXIONES_USUARIO =
            "create table usuario_flexiones(" +
                    "numero_cedula integer not null," +
                    "id_flexiones INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "foreign key (numero_cedula) references usuarios(numero_cedula)" +
                    ")";



    public static String DROP_USUARIOS = "DROP TABLE IF EXISTS usuarios";
    public static String DROP_REGISTRO = "DROP TABLE IF EXISTS registro";
    public static String DROP_PESOS = "DROP TABLE IF EXISTS pesos";
    public static String DROP_FRECUENCIAS = "DROP TABLE IF EXISTS frecuencias";
    public static String DROP_COOPER = "DROP TABLE IF EXISTS cooper";
    public static String DROP_USUARIOS_COOPER = "DROP TABLE IF EXISTS usuario_cooper";
    public static String DROP_USUARIOS_PESOS = "DROP TABLE IF EXISTS usuario_pesos";
    public static String DROP_USUARIOS_FRECUENCIAS = "DROP TABLE IF EXISTS usuario_frecuencias";

}
