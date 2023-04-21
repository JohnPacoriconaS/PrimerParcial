<%-- 
    Document   : index
    Created on : 11 abr. 2023, 22:32:25
    Author     : Core
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    //se tiene la coleccion de listaEst
    ArrayList<Estudiante> listaux = (ArrayList<Estudiante>)session.getAttribute("listaEst");


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        
    <center><h2>--------------------------------------------------------------</h2></center>
    <center><h4>PRIMER PARCIAL -  TEM742</h4></center>
    <center><h4>Nombre : John Henry Pacoricona Sangalli</h4></center>
    <center><h4>Carnet : 10937689</h4></center>
    <center><h2>--------------------------------------------------------------</h2></center>
    <center><h3></h3></center>
        <center><h1>Registro de calificaciones</h1></center>
        <center><a href="MainController?op=nuevo">Nuevo Registro</a></center>
        <h4></h4>
       <center> <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Primer [30]</th>
                <th>Segundo [30]</th> 
                <th>Final [40]</th> 
                <th>Nota Final</th>
                <th></th> 
                <th></th>                 
            </tr>
            <%
                //si tiene algun elemento se empieza a trabajar
                //si es nullo se sale no hace nada
                if(listaux !=null){
                    //para recorrer lista y se guarda en item
                for(Estudiante item: listaux){
            
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getPrimer()%></td>
                <td><%= item.getSegundo()%></td>
                <td><%= item.getFin()%></td>
                <td><%= item.getNota()%></td>
                <td><a href="MainController?op=editar&id=<%=item.getId()%>">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=<%=item.getId()%>">Eliminar</a></td>

            </tr>
            <%
                }
                }
            %>
        </table></center>
    </body>
</html>
