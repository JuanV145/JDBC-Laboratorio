package co.com.gm.jdbc.test;

import co.com.gm.jdbc.datos.UsuarioDAO;
import co.com.gm.jdbc.domain.Usuario;

import java.util.List;

public class testUsuarioJDBC {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        List<Usuario> usuarios = usuarioDAO.Seleccionar();

        for (Usuario usuario : usuarios) {

            System.out.println("usuario = " + usuario);
        }

    }
}
