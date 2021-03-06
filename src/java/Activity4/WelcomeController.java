/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Adam
 */
@WebServlet(name = "WelcomeController", urlPatterns = {"/WelcomeController"})
public class WelcomeController extends HttpServlet {
    
    private static final String DEST_PAGE = "/welcomeResponse.jsp";

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
            String name = request.getParameter("username");
            
            WelcomeService welcomeSrv = new WelcomeService();
            String responseMsg = welcomeSrv.sayWelcome(name);
            
            request.setAttribute("myMsg", responseMsg);
            
                    RequestDispatcher view
                = request.getRequestDispatcher(DEST_PAGE);
        view.forward(request, response);

        } catch (Exception e) {
            request.setAttribute("errorMsg", e.getMessage());
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
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String age = request.getParameter("age");
            String responseMsg = "You are " + age + " years old";
            request.setAttribute("myMsg", responseMsg);

            RequestDispatcher view
                    = request.getRequestDispatcher("/helloResponse.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMsg", e.getMessage());
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
