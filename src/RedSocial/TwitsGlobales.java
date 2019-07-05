package RedSocial;

public class TwitsGlobales {

    private String Usuario;
    private String Mensaje;
    private long fecha;

    public TwitsGlobales(String Usuario, String Mensaje, long fecha) {
        this.Usuario = Usuario;
        this.Mensaje = Mensaje;
        this.fecha = fecha;
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
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

  

}
