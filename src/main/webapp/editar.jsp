<%-- 
    Document   : editar
    Created on : 11 abr. 2023, 22:32:35
    Author     : Core
--%>

<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    //ahora tiene todo vacio item
    Estudiante item =(Estudiante)request.getAttribute("miNot");
    //ahora lo vamos a mostrar con con get
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><h2>--------------------------------------------------------------</h2></center>
    <center><h4>PRIMER PARCIAL -  TEM742</h4></center>
    <center><h4>Nombre : John Henry Pacoricona Sangalli</h4></center>
    <center><h4>Carnet : 10937689</h4></center>
    <center><h2>--------------------------------------------------------------</h2></center>
    <center><h3></h3></center>
    <center><h1><%= (item.getId()==0) ?"Nuevo Registro ":"Editar Registro "%>de Calificaciones</h1></center>
       <center> <form action="MainController" method="post">
            <input type="hidden" name="id" value="<%= item.getId()%>">
         
            <table>       
                <tr>
                    <td>Nombre del estudiante </td>
                    <td><input type="text" name="nombre" value="<%= item.getNombre()%>"></td>
                </tr>
                <tr>
                    <td>Primer parcial(sobre 30 pts )</td>
                    <td><input type="text" name="primer" value="<%= item.getPrimer()%>"></td>
                </tr>
                <tr>
                    <td>Segundo parcial(sobre 30 pts )</td>
                    <td><input type="text" name="segundo" value="<%= item.getSegundo()%>"></td>
                </tr>
                <tr>
                    <td>Examen Final(sobre 40 pts )</td>
                    <td><input type="text" name="exfin" value="<%= item.getFin()%>"></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" valuer="Enviar"></td>
                </tr>          
            </table>      
        </form></center>
    </body>
</html>
