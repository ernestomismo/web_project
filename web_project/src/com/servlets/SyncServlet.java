package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SyncServlet
 */
@WebServlet(description = "Test synchronous servlet", urlPatterns = { "/syncservlet" })
public class SyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long startTime = System.nanoTime();
	    try {
	      Thread.sleep(10000);
	    } catch (InterruptedException e) {
	      throw new RuntimeException(e);
	    }
	    PrintWriter out = response.getWriter();
	    out.print("Work completed. Time elapsed: " + (System.nanoTime() - startTime));
	    out.flush();
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
