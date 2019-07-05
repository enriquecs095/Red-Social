package RedSocial;

import java.util.Calendar;

public class Twits{

    private String Usuario;
    private String Mensaje;
    private long Fecha;
  
    public Twits(String Usuario, String Mensaje, long Fecha) {
        this.Usuario = Usuario;
        this.Mensaje = Mensaje;
        this.Fecha = Fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public long getFecha() {
        return Fecha;
    }

    public void setFecha(long Fecha) {
        this.Fecha = Fecha;
    }
    
}
