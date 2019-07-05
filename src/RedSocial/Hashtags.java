
package RedSocial;

public class Hashtags {
    String usuario;
    String mensaje;
    long fecha;

    public Hashtags(String usuario, String mensaje, long fecha) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
