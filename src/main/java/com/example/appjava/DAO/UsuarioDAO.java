package com.example.appjava.DAO;

import com.example.appjava.entidad.Usuario;

public interface UsuarioDAO {
    //Metodos de la bd
    void Agregar(Usuario usuario);
    void actualizar(String correo, String clave);
}
