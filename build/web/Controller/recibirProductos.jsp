<%-- 
    Document   : recibirProductos
    Created on : 25-05-2018, 11:34:40
    Author     : Soe
--%>
<%@page import="conexion.Conection"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ProductosDao"%>
<%@page import="model.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Productos product = new Productos();
    Conection conn = new Conection();
    ProductosDao proDao = new ProductosDao(conn.getConnection());

    product.setNombre(request.getParameter("nombre"));
    product.setPrecio(Integer.parseInt(request.getParameter("precio")));
    product.setStock(Integer.parseInt(request.getParameter("stock")));
    proDao.Insertar(product);
    int r=proDao.Insertar(product);

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%  if (r>0){%>
             Productos Ingresados = <% product.getNombre();%>
            <h1>Insertados</h1>      
            <%}else{%>
            <h1>Datos no ingresados</h1>
            <%}%>
        
        Producto Ingresado<%=product.getNombre()%>
    </body>
</html>
