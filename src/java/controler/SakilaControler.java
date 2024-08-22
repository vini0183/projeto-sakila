/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Film;
import model.dao.FilmDao;

/**
 *
 * @author Senai
 */
@WebServlet(name = "SakilaControler", urlPatterns = {"/SakilaControler","/sakila","/cadastrar","/filmes", "/editar", "/deletar"})
public class SakilaControler extends HttpServlet {
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
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
        
        String paginaAtual = request.getServletPath();
        
        FilmDao filmdao = new FilmDao();
        if (paginaAtual.equals("/sakila")) {
            
            request.getRequestDispatcher("/WEB-INF/jsp/sakila.jsp").forward(request, response);
            
        } else if(paginaAtual.equals("/cadastrar")) {
            
            request.getRequestDispatcher("/WEB-INF/jsp/cadastrar.jsp").forward(request, response);
            
        } else if(paginaAtual.equals("/filmes")) {
            
            List<Film> ler = new ArrayList();
            FilmDao filmdao2 = new FilmDao();
            
            ler = filmdao2.ler();
            
            request.setAttribute("filmes", ler);
            
            request.getRequestDispatcher("/WEB-INF/jsp/filmes.jsp").forward(request, response);
            
        } else if(paginaAtual.equals("/editar")) {
            
            
            int id = Integer.parseInt(request.getParameter("filme"));
            Film filmeAtual = filmdao.selecionarFilme(id);
            request.setAttribute("filme", id);
            request.setAttribute("titulo", filmeAtual.getTitle());
            request.setAttribute("descricao", filmeAtual.getDescription());
            request.setAttribute("ano", filmeAtual.getRelease_year());
            
            request.getRequestDispatcher("/WEB-INF/jsp/editar.jsp").forward(request, response);
            
        } else if(paginaAtual.equals("/deletar")) {
            
            int id = Integer.parseInt(request.getParameter("filme"));
            
            FilmDao filmes = new FilmDao();
            filmes.deletar(id);
            
            response.sendRedirect("./filmes");

        }
         
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
        
        String paginaAtual = request.getServletPath();
        FilmDao filmes = new FilmDao();
            Film filme = new Film();
        
        if (paginaAtual.equals("/cadastrar")) {
            
            
            
            filme.setTitle(request.getParameter("titulo")); 
            filme.setDescription(request.getParameter("desc"));
            filme.setRelease_year(Integer.parseInt(request.getParameter("ano")));
            
            filmes.cadastrar(filme);
            
            response.sendRedirect("./sakila");
            
        } else if(paginaAtual.equals("/editar")) {
            
            filme.setFilm_id(Integer.parseInt(request.getParameter("filme")));
            filme.setTitle(request.getParameter("titulo"));
            filme.setDescription(request.getParameter("desc"));
            filme.setRelease_year(Integer.parseInt(request.getParameter("ano")));
            
            filmes.atualizar(filme);
            
            response.sendRedirect("./filmes");

        }
        
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
