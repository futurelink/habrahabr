package ru.futurelink.jetty.customizer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
	    PrintWriter printWriter  = resp.getWriter();
	    printWriter.println("<h1><i>Sharing files via servlet</i></h1>");
	    printWriter.println( "<body/>" );		
	}
}
