package com.example.appjava.DAO;
import com.example.appjava.Connection.BDconnection;
import com.example.appjava.entidad.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UsuarioDAOimplement implements UsuarioDAO {

    private static Connection bDconnection;

    private static UsuarioDAOimplement instance;

    public static UsuarioDAOimplement getintance(){
        if (instance == null){

            instance = new UsuarioDAOimplement();
        }
        return instance;
    }

    //Constructior del DAOimplement
    private UsuarioDAOimplement(){
        this.bDconnection = BDconnection.getConnection();
    }


    //Guardar datos en la bd
    @Override
    public void Agregar(Usuario usuario) {
        String sql = "INSERT INTO usuario (correo,nombre,clave) VALUES (?,?,?)";
        try (PreparedStatement pstm = bDconnection.prepareStatement(sql)){
            pstm.setString(1,usuario.getCorreo());
            pstm.setString(2,usuario.getNombre());
            pstm.setString(3,usuario.getClave());
            pstm.executeUpdate();
            System.out.println("cliente creado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(String correo, String clave) {
        String sql = "UPDATE usuario SET clave = ? WHERE correo = ?";
        try (PreparedStatement pstm = bDconnection.prepareStatement(sql)){
            pstm.setString(1,clave);
            pstm.setString(2,correo);
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
