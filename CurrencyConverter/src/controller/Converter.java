package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/converter/servlet/Converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Converter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<form action='/CurrencyConverter/converter/servlet/Converter' method='post'>"
				+ "Amount: "
				+ "<input type='text' name='money'>"
				+ "<select name='from'>"
				+ "<option value='USD'>USD</option>"
				+ "<option value='JPY'>JPY</option>"
				+ "<option value='EUR'>EUR</option>"
				+ "<option value='PHP'>PHP</option>"
				+ "</select> <br />"
				+ "Convert To: "
				+ "<select name='to'>"
				+ "<option value='USD'>USD</option>"
				+ "<option value='JPY'>JPY</option>"
				+ "<option value='EUR'>EUR</option>"
				+ "<option value='PHP'>PHP</option>"
				+ "</select> <br />"
				+ "<input type='submit' value='calculate'>"
				+ "</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final double USD = 1;
		final double JPY = 105.85;
		final double EUR = 0.90;
		final double PHP = 52.28;
		double amt = Double.parseDouble(request.getParameter("money"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		response.setContentType("text/html");
		response.getWriter().append("<h1>" + String.valueOf(amt)); 
		
		if (from.equals("USD")) {
			amt = amt/USD;
			response.getWriter().append(" USD");
		} else if(from.equals("JPY")) {
			amt = amt/JPY;
			response.getWriter().append(" JPY");
		} else if (from.equals("EUR")) {
			amt = amt/EUR;
			response.getWriter().append(" EUR");
		} else {
			amt = amt/PHP;
			response.getWriter().append(" PHP");
		}
		
		if (to.equals("USD")) {
			amt = amt*USD;
			response.getWriter().append(" = "+ String.valueOf(amt) +" USD</h1>");
		} else if(to.equals("JPY")) {
			amt = amt*JPY;
			response.getWriter().append(" = "+ String.valueOf(amt) +" JPY</h1>");
		} else if (to.equals("EUR")) {
			amt = amt*EUR;
			response.getWriter().append(" = "+ String.valueOf(amt) +" EUR</h1>");
		} else {
			amt = amt*PHP;
			response.getWriter().append(" = "+ String.valueOf(amt) +" PHP</h1>");
		}
		
		
	}

}
