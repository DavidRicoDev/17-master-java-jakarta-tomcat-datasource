package es.davidrico.jakarta.tomcatdatasource.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import es.davidrico.jakarta.tomcatdatasource.modelos.Producto;
import es.davidrico.jakarta.tomcatdatasource.servicios.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImpl(conn);
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
