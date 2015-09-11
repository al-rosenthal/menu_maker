/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.menu_maker.Dish;
import org.menu_maker.Menu;
import org.menu_maker.Section;

/**
 *
 * @author alfre_000
 */
@WebServlet(name = "DishController", urlPatterns = {"/DishController"})
public class DishController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DishController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DishController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        
        String formatedPrice =formatForCurrency(Double.parseDouble(price));
        Dish d = new Dish(name, formatedPrice);

        //This is the section I need to add this to
        String index = request.getParameter("section");

        //Collect the correct section to add new dish to
        Menu menu = (Menu) request.getSession().getAttribute("Menu");
        ArrayList<Section> list = menu.getSections();
        Section s = list.get(Integer.parseInt(index));

        ///^\$?[0-9]+(\.[0-9][0-9])?$/
        s.addDish(d);

        request.getSession().setAttribute("Menu", menu);
        request.getRequestDispatcher("/NewMenu.jsp").forward(request, response);
        processRequest(request, response);
    }

    private String formatForCurrency(double price) {
        String number;
        Locale locale = new Locale("en", "CA");
        NumberFormat numberFormat = NumberFormat.getInstance(locale.CANADA);

        number = numberFormat.format(price);
        return number;
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
