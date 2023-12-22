package co.com.gm.jdbc.datos;

import co.com.gm.jdbc.domain.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static co.com.gm.jdbc.datos.Conexion.*;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ? , password = ?";
    private static final String SQL_DELETE = "DELETE usuario WHERE id_usuario = ?";

    public List<Usuario> Seleccionar() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id_usuario = resultSet.getInt("id_usuario");
                String user = resultSet.getString("usuario");
                String password = resultSet.getString("password");

                usuario = new Usuario(id_usuario, user, password);

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {

            try {

                close(preparedStatement);
                close(resultSet);
                close(connection);

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }

        }

        return usuarios;

    }

    public int insertar(Usuario usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;

        try {

            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getPassword());

            registros = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        } finally {
            try {
                close(preparedStatement);
                close(connection);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registros;

    }

    public int actualizar(Usuario usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registro = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setInt(3, usuario.getIdUsuario());
            registro = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);

        }

        return registro;

    }

    public int borrar(Usuario usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int registro = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, usuario.getIdUsuario());
            registro = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return registro;

    }

}
