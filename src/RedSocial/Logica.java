package RedSocial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Logica {

    static String UserLog;
    static String UsuarioVisitar;
    RandomAccessFile Usuarios;
    RandomAccessFile Following;
    RandomAccessFile Follower;

    public Logica() {
        try {
            Usuarios = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\Users.twc", "rw");
            Following = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UserLog + "\\Following.twc", "rw");
            Follower = new RandomAccessFile("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Proyecto2Programacion2\\RegistroUsuarios\\" + UsuarioVisitar + "\\Follower.twc", "rw");
            CargarDatos();
        } catch (FileNotFoundException e) {
            Mensaje(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            Mensaje(ex.getMessage());
            ex.printStackTrace();
        }

    }

    private void CargarDatos() {

    }

    private void Mensaje(String message) {

    }

}
