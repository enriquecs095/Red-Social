package RedSocial;

import javax.swing.JOptionPane;

public class Usuarios extends RegistroUsuarios {

    private boolean Habilitado;

    public Usuarios(String NombreCompleto, String Usuario, String Contraseña, char Sexo, int Edad, String URL ,long FechaIngreso, String Estado, boolean habilitado) {
        super(NombreCompleto, Usuario, Contraseña, Sexo, Edad, URL ,FechaIngreso, Estado);
        this.Habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(boolean Habilitado) {
        this.Habilitado = Habilitado;
    }

}
