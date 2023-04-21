
package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Core
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id,pos;
        HttpSession ses=request.getSession();
        
        if(ses.getAttribute("listaEst")==null){
            
            ArrayList<Estudiante> listaux = new ArrayList<Estudiante>();
            
            ses.setAttribute("listaEst", listaux);       
        }
        
        
        //esta es la lista que se utilizara
        ArrayList<Estudiante> lista= (ArrayList<Estudiante>)ses.getAttribute("listaEst");
        //viene sin ningun tipo de parametro
        String op = request.getParameter("op");
        //pregunta si op no esta vacio se guarda op, pero si esta vacion se guarda el view
        String opcion = (op != null)? op : "view";
        //creamos un objeto vacio tiene todo vacio
        Estudiante obj1= new Estudiante(0,"",0,0,0,0);
        
        
        
        switch(opcion){
            case "view":
                //le mando el control a index.jsp
                response.sendRedirect("index.jsp");
                break;
                
            case "nuevo":
                request.setAttribute("miNot", obj1);
                //con ello se transfiere a editar el control
                request.getRequestDispatcher("editar.jsp").forward(request, response);      
                break;
           
            case "editar":
                id=Integer.parseInt(request.getParameter("id"));
                pos=buscarid(request, id);
                obj1 = lista.get(pos);
                request.setAttribute("miNot", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                pos= buscarid(request, id);
                lista.remove(pos);
                response.sendRedirect("index.jsp");
                break;
        }
    
    
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        Estudiante obj1 = new Estudiante();
           HttpSession ses= request.getSession();
        //recuperacion al sesion en lista
        ArrayList<Estudiante> lista = (ArrayList)ses.getAttribute("listaEst");
        int idt;
        //convirtiendo en valor entero
        obj1.setId(Integer.parseInt( request.getParameter("id")));
        obj1.setNombre(request.getParameter("nombre"));
        obj1.setPrimer(Integer.parseInt(request.getParameter("primer")));
        obj1.setSegundo(Integer.parseInt(request.getParameter("segundo")));
        obj1.setFin(Integer.parseInt(request.getParameter("exfin")));
        int primer = Integer.parseInt(request.getParameter("primer"));
        int segundo = Integer.parseInt(request.getParameter("segundo"));
        int exfinal = Integer.parseInt(request.getParameter("exfin"));
 
        int nuevo= primer+segundo+exfinal;
        obj1.setNota(nuevo);
        
       //usando el ultimo id
       
       //objeto nuevo
        idt = obj1.getId();
        if(idt == 0){
             obj1.setId(ultimoId(request));
             lista.add(obj1);
        }
        else{
            lista.set(buscarid(request,idt), obj1);
        }
        
        response.sendRedirect("index.jsp");
    }
    
    private int ultimoId(HttpServletRequest request){
        HttpSession ses =request.getSession();
        ArrayList<Estudiante> listapro = (ArrayList)ses.getAttribute("listaEst");
        
        int ide = 0;
        for(Estudiante item: listapro){
            ide=item.getId();
            
        }
        return ide + 1;
    }
    
    private int buscarid(HttpServletRequest request, int id){
        
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList)ses.getAttribute("listaEst");
        int i = 0;
        //averiguando la posicion que se encuenta el elemento que se busca
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
            
        }
        return i;
    }
    
    

}
