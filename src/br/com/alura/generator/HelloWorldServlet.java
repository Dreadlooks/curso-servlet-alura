package br.com.alura.generator;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter print = resp.getWriter();
		print.println("<body>");
		print.println("<h1>");
		print.println("Olá alunos!");
		print.println("</h1>");
		print.println("</body>");
		System.out.println("Cheguei");
		
	}
}
