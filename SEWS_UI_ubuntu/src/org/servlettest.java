package org;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlettest
 */
@WebServlet({ "/servlettest", "/sevletresultpath4" })
public class servlettest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlettest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw= null;
		try
		{
			FileWriter fw1 = new FileWriter("/home/pah/Desktop/DB_Dic.txt",true);
	    	  bw = new BufferedWriter(fw1);
	    	  
		
		
		PrintWriter writer=response.getWriter();
		String [] S=request.getParameterValues("azad");
		System.out.println(S.length);
		for (String s:S)
		{
		writer.println("changes made");
		System.out.println("qqqqqqqqqqqq"+s);
		bw.write(s);
		bw.write('\n');
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				bw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
