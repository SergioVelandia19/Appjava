package com.example.appjava.entidad;

public class Usuario {
    //Atributos
    private Long id_Usuario;
    private String Correo;
    private String Nombre;
    private String Clave;

    //Constructor
    public  Usuario(Long id_usuario,String nombre, String clave){
        this.id_Usuario = id_usuario;
        this.Nombre = nombre;
        this.Clave = clave;
    }
    public  Usuario(String correo,String nombre, String clave){
        this.Correo = correo;
        this.Nombre = nombre;
        this.Clave = clave;
    }

    //Metodos setter y getter
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public Long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
