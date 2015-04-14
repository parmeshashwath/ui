package org.azad;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletresult
 */
@WebServlet(description = "to diaplay the results of parsing", urlPatterns = { "/sevletresultpath" })
public class servletresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String temp1;
		String temp2=" ";
		int flag =0;
		BufferedReader br=null;
		response.setContentType("text/html");
		String temp_path=request.getParameter("filename");
		PrintWriter writer=response.getWriter();
		writer.println(temp_path);
	//	System.out.println(temp_path);
			System.out.println(String.valueOf(flag));
			try
			{
				if(flag==0)
				{
					//Path pt=new Path("hdfs://localhost:54310/usr/local/hadoop/inputlog_temp1/alert_CG1PRD1_temp.log");//Location of file in HDFS
		              //FileSystem fs = FileSystem.get(new Configuration());
					//Process obj2=Runtime.getRuntime().exec("/usr/local/hadoop/bin/start-all.sh");
					//obj2.waitFor();
		              Process obj=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -rmr hdfs://localhost:54310/usr/local/hadoop/outputlog_temp2");
			obj.waitFor();
			String tempp="/home/pah/Desktop/" + temp_path;

					Process obj1=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/path_test.jar " + temp_path);
					obj1.waitFor();
					Process obj3=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs  -copyToLocal hdfs://localhost:54310/usr/local/hadoop/outputlog_temp2 /home/pah/Desktop");
					obj3.waitFor();
					
br=new BufferedReader(new FileReader("/home/pah/Desktop/outputlog_temp2/o1"));
writer.println("<HTML>");
//Start on the body
writer.println(" <link rel='stylesheet' type='text/css' href='CSS/output.css'>");
writer.println("<BODY>");


writer.println("<div class='CSSTableGenerator' >"+
"<table > "+
 "<tr>" +
     "<td>" +
      "   Error" +
     "</td>" +
     "<td >" +
      "   Time Stamp" +
     "</td>" +
     "<td>" +
      "   Severity" +
     "</td>" +
		  "<td>" +
      "  Occurence" +
     "</td>" +
		  "<td>" +
		   "   Cause of Occurence" +
       "</td>" +
		 "<td>" +
      "   General Desc" +
     "</td>" +
 "</tr>");

while((temp1=br.readLine())!=null)
{
	//temp2=temp2+temp1;

//System.out.println(temp1);

writer.println("<tr>");
StringTokenizer tok=new StringTokenizer(temp1,"*");
while(tok.hasMoreTokens()){
writer.println("<td>"+ tok.nextToken()+ "</td>");
}



writer.println("</tr>");
}
writer.println("</table></BODY></HTML>");
//writer.println(temp1);

flag++;
writer.println("finshed");
				}
					else
				{
					flag++;
	//				System.out.println(flag);
				}
			
			}
			catch(Exception ex)
			{
			ex.printStackTrace();	
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
