/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bean.receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Receptor_Singleton;

/**
 *
 * @author TITO
 */
public class Servlet_mensajes extends HttpServlet {
    ArrayList<receta> lista;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String opcion = request.getParameter("accion");
       switch(opcion){
           case "iniciarServicio":
               iniciarServicio(request,response);
           break;
           case "imprimirRecetas":
               imprimirRecetas(request,response);
           break;
       }
    }
    void imprimirRecetas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Receptor_Singleton obj = Receptor_Singleton.getReceptor_Singleton();
        lista = obj.getMensajes();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            while(!lista.isEmpty()){                
                out.println("<div class='article-item' class='article-template'>"
                                +"<div class='c4'>"
                                    +"<div class='c1'>"
                                        +"<img src='assets/images/texto.jpg' alt='Artículo' />"
                                    +"</div>"
                                    +"<div class='c2'>"
                                        +"<h2>"+lista.get(0).getDni() +"</h2>"
                                        +"<span class='date'>"
                                        +"Hace 5 minutos"
                                        +"</span>"
                                    +"</div>"
                                    +"<div class='c3'>"
                                        +"<img src='assets/images/arrow_down_green.png' alt='Artículo' />"
                                    +"</div>"
                                +"</div>"
                                +"<div class='contenido_receta'>"
                                    +"<h2><strong>"+ lista.get(0).getNombre()+" "+ lista.get(0).getApellido()+"</strong></h2>"
                                    +"<p><strong>Dni: </strong>"+ lista.get(0).getDni()+"</p>"
                                    +"<p><strong>Médico: </strong>"+ lista.get(0).getMed()+" |-> <strong>Fecha:</strong> "+ lista.get(0).getFecha()+"</p>"
                                    +"<p><strong>Medicamento: </strong>"+ lista.get(0).getMedicamento()+" |-> <strong>Cantidad:</strong> "+ lista.get(0).getCantidad()+"</p>"
                                    +"<p><strong>Indicaciones: </strong>"+ lista.get(0).getIndicaciones()+"</p>"
                                +"</div>"
                                +"<div class='clearfix'></div>"
                            +"</div> ");
            
                lista.remove(0);
            }
        }
        
    }
    private void iniciarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Receptor_Singleton obj = Receptor_Singleton.getReceptor_Singleton();
        obj.inicializarServicio();
        imprimirRecetas(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
