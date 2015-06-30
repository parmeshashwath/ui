package org;

import java.util.List;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletresult
 */
@WebServlet(description = "to diaplay the results of parsing", urlPatterns = { "/sevletresultpath1" })
public class Servletresult extends HttpServlet {
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
		String reg_exp=request.getParameter("reg_exp");
		StringTokenizer reg=new StringTokenizer(reg_exp,",");
		BufferedWriter bw=null;
		try
		{
			FileWriter fw1 = new FileWriter("/home/pah/Desktop/regular_expressions");
	    	  bw = new BufferedWriter(fw1);
			
		while(reg.hasMoreTokens())
		{
			bw.write(reg.nextToken());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		PrintWriter writer=response.getWriter();
		writer.println(temp_path);
	System.out.println(temp_path);
			System.out.println(String.valueOf(flag));
			try
			{
				if(flag==0)
				{
					
		           Process obj=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -rmr hdfs://localhost:54310/usr/local/hadoop/output_jat_fin");
			obj.waitFor();
			Process obj5=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -rmr hdfs://localhost:54310/usr/local/hadoop/inputlog_temp/"+temp_path);
			obj5.waitFor();
			Process obj6=Runtime.getRuntime().exec("sudo rm /home/pah/Desktop/part-00000" );
			obj6.waitFor();
			Process obj2=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -copyFromLocal /home/pah/Desktop/"+temp_path +" /usr/local/hadoop/inputlog_temp/" );
					obj2.waitFor();
				System.out.println("/usr/local/hadoop/bin/hadoop dfs -copyFromLocal /home/pah/Desktop/"+temp_path +" /usr/local/hadoop/inputlog_temp/"); 	
					System.out.println("test1");
		//Process obj4=Runtime.getRuntime().exec(" rm /home/pah/Desktop/part-00000 ");
			//		obj4.waitFor();
			//		Process obj1=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/intern/sym.jar " + "/usr/local/hadoop/inputlog_temp/" + temp_path + " /usr/local/hadoop/output_jat_fin");
				//	obj1.waitFor();
					Runtime re = Runtime.getRuntime();
					BufferedReader output=null;  		
					try{ 
					  Process cmd = re.exec("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/intern/sym.jar " + "/usr/local/hadoop/inputlog_temp/" + temp_path + " /usr/local/hadoop/output_jat_fin"); 
					  output =  new BufferedReader(new InputStreamReader(cmd.getInputStream()));
					} catch (IOException ioe){
					  ioe.printStackTrace();
					}
					
					String resultOutput;
					while((resultOutput=output.readLine())!=null)
						{
						System.out.println(resultOutput);
						}
					//writer.println("/usr/local/hadoop/bin/hadoop jar /home/pah/Desktop/rr.jar " + "/usr/local/hadoop/inputlog_temp/" + name_file + " /usr/local/hadoop/output_jat_fin");
				Process obj3=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs  -copyToLocal hdfs://localhost:54310/usr/local/hadoop/output_jat_fin/part-00000 /home/pah/Desktop");
					obj3.waitFor();
HttpSession session = request.getSession();
String[] jsonstrarr=new String[10];
final Gson gson = new Gson();
int jsonite=0;
 br=new BufferedReader(new FileReader("/home/pah/Desktop/part-00000"));
 while((temp1=br.readLine())!=null)
 {
 	//temp2=temp2+temp1;
 System.out.println(temp1);
 StringTokenizer tok=new StringTokenizer(temp1,"*");
 Symptom_2 s =new Symptom_2();
 int token_iterator=0;
 while(tok.hasMoreTokens())
 {
	 switch(token_iterator)
	 {
	 case 0:
		 s.setError(tok.nextToken());
		 System.out.println("ERROR"+s.getError());
		 break;
	 case 2:
		 String rawtext=tok.nextToken();
		 String proc1=rawtext.replace("{{   {", "");
		 String proc2=proc1.replace("} }}","");
		 String proc3=proc2.replace("}{", "*");
		 StringTokenizer itok=new StringTokenizer(proc3,"*");
		 //String temp=itok.nextToken();
		  s.setReason(itok.nextToken());
			s.setOutcome(itok.nextToken());
			System.out.println("REASON"+s.getReason());
			System.out.println("OUTCOME"+s.getOutcome());
		 break;
			
	 case 1:
		 s.setGs(tok.nextToken().toString());
		 System.out.println("General Description"+s.getGs());
		 break;
	 
	 case 4:
		 String rt=tok.nextToken();
		// String rt2=rt.replace(" ","");
		 System.out.println(rt);
		 int c=Integer.parseInt(rt);
		 System.out.println("Cnt"+c+"rt2"+rt);
		 s.setcnt(c);
		 System.out.println("Count"+s.getCnt());
		 break;
	 case 3:
		 String rawstr=tok.nextToken().toString();
		// String pr1=rawstr.replace("{   ", "");
		 String pr2=rawstr.replace("} }}", "");
		 String pr3=pr2.replace("}{", ",");
		 
		 
		 System.out.println("To be tokenized String"+pr3);
		 String ts[]=new String[s.getCnt()];
		 StringTokenizer itt=new StringTokenizer(pr3,",");
		 int k=0;
		 while(itt.hasMoreTokens())
		 {
			 /*ts[k]=itt.nextToken();
			 System.out.println(ts[k]);
			 k++;*/
			 System.out.println("hello");
			 s.setTimestamps(itt.nextToken());
		 }
	//	 System.out.println("Timestamps:"+s.getTimestamps());
		 break;
		 
	 case 5:
		 s.setSeverity(tok.nextToken().toString());
		 System.out.println("Severity"+s.getSeverity());
		 break;
	 case 6:
		 s.setLinks(tok.nextToken().toString());
		 System.out.println("Links"+s.getLinks());
		 break;
	default:
		System.out.println("In default bloack");
		System.out.println(tok.nextToken());
		break;
	
	 }
	 
 token_iterator++;
 
 }
 String jsonstr = gson.toJson(s);
 System.out.println("Json String^^^^^^^^^^^^^^^^^^^^ "+jsonite+":"+jsonstr);
 jsonstrarr[jsonite]=jsonstr;
 jsonite++;

 }
 jsonstrarr[jsonite]="@";
 System.out.println("JSON STRINGS");
 for(int pk=-0;pk<jsonstrarr.length;pk++)
 {
	 if(jsonstrarr[pk].equals("@"))
			 {
		 		break;
			 }
	 session.setAttribute("jsonstr"+pk, jsonstrarr[pk]);
	 System.out.println("Json String "+pk+":"+jsonstrarr[pk]);
	 
 }

 

flag++;

writer.println("finshed");



String nextJSP = "/Home.jsp";
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
System.out.println(dispatcher.toString());
dispatcher.forward(request,response);
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
	
	
	
	
}


