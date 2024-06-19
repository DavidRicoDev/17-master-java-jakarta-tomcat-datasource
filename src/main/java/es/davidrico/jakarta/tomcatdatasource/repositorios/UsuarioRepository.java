package es.davidrico.jakarta.tomcatdatasource.repositorios;

import es.davidrico.jakarta.tomcatdatasource.modelos.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername(String username) throws SQLException;
}
