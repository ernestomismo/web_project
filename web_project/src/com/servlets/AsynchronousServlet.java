package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsynchronousServlet
 */
@WebServlet(asyncSupported = true, description = "Sevlet example", urlPatterns = { "/asyncServlet" })
public class AsynchronousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsynchronousServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final long startTime = System.nanoTime();
	    final AsyncContext asyncContext = request.startAsync(request, response);
	    
	    PrintWriter out = response.getWriter();
	    out.print("Aquí va la primera mierdecilla");
        out.flush();

	    new Thread() {
	    	
	      @Override
	      public void run() {
	        try {
	          ServletResponse response = asyncContext.getResponse();
	          response.setContentType("text/plain");
	          PrintWriter out = response.getWriter();
	          Thread.sleep(2000);
	          out.print("Segunda mierdecilla. Work completed. Time elapsed: " + (System.nanoTime() - startTime));
	          out.flush();
	          asyncContext.complete();
	        } catch (IOException | InterruptedException e) {
	          throw new RuntimeException(e);
	        }
	      }
	    }.start();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
