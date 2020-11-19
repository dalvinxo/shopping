package com.example.shopping;

public class GlobalUsuario {

    public static int idusuario;
    public static String username;
    public static String password;
    public static int typeUSER;

    //independiente
    public static int idCompany;

    public GlobalUsuario(int idusuario, String username, String password,int typeUSER) {
        this.idusuario=idusuario;
        this.username=username;
        this.password=password;
        this.typeUSER = typeUSER;
    }
}
