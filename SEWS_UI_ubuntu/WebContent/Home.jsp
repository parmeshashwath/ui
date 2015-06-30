<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <style>
 .form-control {
 
 width: 100%;
 }
  .heading{
  background-color:#505050;
  position:relative;
  top:0%;
  width:1700px;
  height:80px;
  
  
  }
 .container{
 position:relative;
  top:8%;
 }
 .test1{
 position:relative;
  top:82%;
  left:8%;
 }
  </style>
</head>
<body>
 <%@page language="java"%>
 <%@page import="java.lang.*" import="java.sql.*" import="java.io.*" import="java.text.*" import="java.util.*"  import="com.google.gson.*" import="org.*"%>
<div class ="heading">
<p align="center">
<font size="20" color="#FFFFFF">Symptom Based Early Warning System</font> </p>
</div>

    <div class="container">
  <h2>Analysis of DB Alert log file(16 Mar 2015 to 19 Mar 2015) </h2>
            
  <table class="table table-bordered table-hover">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>ERRORS/SYMPTOMS</th>
        
        <th>GENRAL DESCRIPTION</th>
        
        <th>COUNT</th>
        <th>SEVERITY</th>
        <th>LINKS</th>
      </tr>
    </thead>
    <tbody>
     <%
     int cons=3;
     final Gson gson = new Gson(); 
     for (int i=0;i<cons;i++)
     {
     String jsonstr=session.getAttribute("jsonstr"+i).toString();
     Symptom_2 s =gson.fromJson(jsonstr,Symptom_2.class);
    
    String sevtype="";
    String butontype="";
if(s.getSeverity().equals("H"))
{
	System.out.println("The severity is high");
	 sevtype="#FF3300";
	 butontype="btn btn-danger";
}
else if(s.getSeverity().equals("M"))
{
	System.out.println("The severity is Medium");
	 sevtype="#CCCC00";
	 butontype="btn btn-warning";
}
else if (s.getSeverity().equals("L"))
{
	System.out.println("The severity is Low");
	 sevtype="#66CC00";
	 butontype="btn btn-info";
}
	  
    %>
    
      <tr style="color:white;background-color:<%=sevtype %>">
        <!--  <td><b><%=s.getError()%></b></td>-->
        
        <td data-toggle="modal" data-target="#myModal_1<%=i%>"><p class="text-primary" style="color:#000000;"><b><font size="5"><%=s.getError() %></font></b></p></td>
       <!--  <td><%=s.getReason()%></td>
       <td><%=s.getOutcome()%></td> -->
       <td><b><font size="3"><%=s.getGs() %></font></b></td>
       <td data-toggle="modal" data-target="#myModal<%=i%>"><p class="text-primary"><p class="text-primary" style="color:#000000;"><b><font size="3"><%=s.getCnt() %></font></b></p></td>
       
       <td><b><font size="5"><%=s.getSeverity() %></font></b></td>
<!--       <td data-toggle="modal" data-target="#myModal_2<%=i%>"><p class="text-primary"><b>help</b></p></td> --> 
       <td> <a href=<%=s.getLinks() %>><p class="text-primary" style="color:#000000;"><b><font size="3">help</font></b></p></a></td> 
       
      </tr>
        
     <% 
  	
     }
    
     %>
      </tbody>
  </table>
</div>
<%
for(int k=0;k<cons;k++)
{
	 String jsonstr=session.getAttribute("jsonstr"+k).toString();
     Symptom_2 s =gson.fromJson(jsonstr,Symptom_2.class);
%>
<div id="myModal<%=k%>" class="modal fade" role="dialog" tabindex="-1" aria-labelledby="myModalLabel<%=k%>" aria-hidden="true">
  <div class="modal-dialog" id="<%=k%>">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
        <h2 class="modal-title" id="myModalLabel<%=k%>">TimeStamps for <%=s.getError()%></h2>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>TIMESTAMP</th>
        <th>COUNT</th>
        <th>IN_FILE_DESCRIPTION</th>
      </tr>
    </thead>
     <tbody>       
        <%
        HashMap<String,attributes> t=s.getTimestamps();
        try
		{
			Set set = s.ts_cnt.entrySet();
			Iterator i = set.iterator();
		      // Display elements
			
			
		      while(i.hasNext()) {
		    	  
		    	  Map.Entry me = (Map.Entry)i.next();
		    	  String temp=(String)me.getKey();
		    	  attributes obj=(attributes)me.getValue();
		    	  
		    	  %>
		    	  <tr>
		             <td> <%=temp%></td>
		             <td> <%=obj.cnt%></td>
		             <td> <%=obj.file_des%></td>
		              </tr>
		              <%         
		      }
		}
        catch(Exception e)
        {
        	
        }
       
        %>
        	      
           
        </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
<%
}
%> 

<%
for(int k=0;k<cons;k++)
{
	 String jsonstr=session.getAttribute("jsonstr"+k).toString();
     Symptom_2 s =gson.fromJson(jsonstr,Symptom_2.class);
%>
<div id="myModal_1<%=k%>" class="modal fade" role="dialog" tabindex="-1" aria-labelledby="myModalLabel<%=k%>" aria-hidden="true">
  <div class="modal-dialog" id="<%=k%>">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
        <h2 class="modal-title" id="myModalLabel<%=k%>">Reasons and Outcomes for <%=s.getError()%></h2>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>REASONS</th>
        <th>OUTCOMES</th>
      </tr>
    </thead>
    <tbody>       
        <%
        for (int lo=0;lo<Math.max(s.reasons.length,s.outcomes.length);lo++)
        {     	
        %>
        
        	<tr>
        	<%
        	if(lo<s.reasons.length)
        	{
        	%>
             <td> <%=s.reasons[lo] %></td>
             <%
             }%>
             <%
             if(lo<s.outcomes.length)
             {
             %>
             <td><%=s.outcomes[lo] %></td>
             <%
             }
             %>
              </tr>       
           <%  
        }   
        %>
        
        
         
        </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
<%
}
%>    
<%
for(int k=0;k<cons;k++)
{
	 String jsonstr=session.getAttribute("jsonstr"+k).toString();
     Symptom_2 s =gson.fromJson(jsonstr,Symptom_2.class);
     String link=s.links;
	   StringTokenizer token=new StringTokenizer(link,",");
	   String [] link_arr=new String[token.countTokens()];
	   int i=0;
	   while(token.hasMoreTokens())
	   {
		   link_arr[i]=token.nextToken();
		   i++;
	   }
%>
<div id="myModal_2<%=k%>" class="modal fade" role="dialog" tabindex="-1" aria-labelledby="myModalLabel<%=k%>" aria-hidden="true">
  <div class="modal-dialog" id="<%=k%>">
    <div class="modal-content">
      <div class="modal-header">
      <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
        <h2 class="modal-title" id="myModalLabel<%=k%>">Reasons for <%=s.getError()%></h2>
      </div>
      <div class="modal-body">
        <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>Links</th>
      
      </tr>
    </thead>
    <tbody>       
        <%
        for (int lo=0;lo<link_arr.length;lo++)
        {     	
        %>
        
        	<tr>
        	
            <td> <a href=<%=link_arr[lo] %>>click</a></td> 
             
              </tr>       
           <%  
        }   
        %>
        
        
         
        </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
<%
}
%>     
</div>

<div class="test1">
<a id="myLink" title="Click to do something"
 href="test.jsp" onclick="MyFunction();return false;"><p class="text-primary" style="color:#330066;">Results of Regular expression search</p></a>
</div>
</body>

</html>