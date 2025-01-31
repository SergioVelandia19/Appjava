package com.example.appjava.Jbcrip;
import org.mindrot.jbcrypt.BCrypt;
public class jbcrip {
    public static String hashear(String clave){
    return BCrypt.hashpw(clave,BCrypt.gensalt(20));
    }

    public static boolean verificar(String hashear,String clave){
        return BCrypt.checkpw(clave,hashear);
    }


}
