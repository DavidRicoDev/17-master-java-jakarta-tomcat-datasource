package es.davidrico.jakarta.tomcatdatasource.servicios;

import es.davidrico.jakarta.tomcatdatasource.modelos.Categoria;
import es.davidrico.jakarta.tomcatdatasource.modelos.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
