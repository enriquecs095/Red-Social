
package RedSocial;

public abstract class RegistroUsuarios{
protected String NombreCompleto;
protected String Usuario;
protected String Contraseña;
protected char Sexo;
protected int Edad;
protected String URL;
protected long FechaIngreso;
protected String Estado;

    public RegistroUsuarios(String NombreCompleto, String Usuario, String Contraseña, char Sexo, int Edad, String URL ,long FechaIngreso, String Estado) {
        this.NombreCompleto = NombreCompleto;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Sexo = Sexo;
        this.Edad = Edad;
        this.FechaIngreso = FechaIngreso;
        this.URL = URL;
        this.Estado = Estado;
 
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public final String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public long getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(long FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
