
package RedSocial;


public abstract class Follows {

protected String Usuario;
protected long fecha;

    public Follows(String Usuario, long fecha) {
        this.Usuario = Usuario;
        this.fecha = fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }



}
