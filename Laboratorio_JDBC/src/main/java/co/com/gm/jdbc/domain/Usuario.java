package co.com.gm.jdbc.domain;

public class Usuario {

    private int IdUsuario;
    private String Usuario;
    private String Password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public Usuario(String usuario, String password) {
        Usuario = usuario;
        Password = password;
    }

    public Usuario(int idUsuario, String usuario, String password) {
        IdUsuario = idUsuario;
        Usuario = usuario;
        Password = password;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "IdUsuario=" + IdUsuario +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
