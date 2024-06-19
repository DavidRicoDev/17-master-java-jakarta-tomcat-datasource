package es.davidrico.jakarta.tomcatdatasource.servicios;

import es.davidrico.jakarta.tomcatdatasource.modelos.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
