<!DOCTYPE html>
<html lang="en">
<%@page language="java"%>
 <%@page import="java.lang.*" import="java.sql.*" import="java.io.*" import="java.text.*" import="java.util.*"  import="com.google.gson.*" import="org.*"%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style>
.checkbox1{
postion:absolute;
top:90%;
right:20%;
}
.container
{
postion:absolute;
top:90%;
right:20%;
}
.heading{
  background-color:#505050;
  position:absolute;
  top:0%;
  width:1700px;
  height:80px;
  
  
  }
</style>
</head>

<body>
<%String ab;
String sCurrentLine;
List<String> wordList=new ArrayList<String>();%>
<%
BufferedReader br = null;
Iterator<String> itr=null;
try
{
	

br = new BufferedReader(new FileReader("/home/pah/Desktop/errors"));
while((sCurrentLine=br.readLine())!=null)
{
	wordList.add(sCurrentLine);
}
itr=wordList.iterator();
}
catch (Exception e) {
	e.printStackTrace();
	} 


%>
<div class ="heading">
<p align="center">
<font size="20" color="#FFFFFF">Symptom Based Early Warning System</font> </p>
</div>
<br><br><br><br><br>
<div class="container">
<table class="table table-bordered table-hover">
    <thead>
      <tr style="color:white; background-color:black; font-weight:bold;">
        <th>ERRORS</th>
       
        <th>SEVERITY</th>
        
        
        <th>GENRAL DESCRIPTION</th>
        <th>REASONS</th>
        <th>OUTCOMES</th>
   
        <th>LINKS</th>
         <th>SAVE</th>
      </tr>
    </thead>
    <tbody>
  <h2>Possible Keywords of Interest</h2>
  
  <% ab="cisco_azad"; %>
  
  
  <form  role="form" action="sevletresultpath4">
  
  <%
  int i=0;
  int j=10;
  int k=20;
  int l=30;
  int m=40;
  int n=50;
  int o=60;
  int p=70;
  while(itr.hasNext())
  {  
	  ab=itr.next();
	  i++;
	  j++;
	  k++;
	  l++;
	  m++;
  	  n++;
  	  o++;
  	  p++;
  %>
  <tr class="info">
    <div class="checkbox1">
     <td> <label><input type="checkbox" id=<%=i %> name ="azad" value=<%=ab%> onclick="fun2(<%=j%>,<%=k%>,<%=l%>,<%=n %>,<%=o %>,<%=m %>,<%=i %>)"><%=ab%></label></td>
     <td> <input type="text" class="form-control" name="parmesh" id=<%=j %> disabled="true" ></td>
     <td> <input type="text" class="form-control" name="parmesh" id=<%=k %> disabled="true" ></td>
     <td> <input type="text" class="form-control" name="parmesh" id=<%=l %> disabled="true" ></td>
     <td> <input type="text" class="form-control" name="parmesh" id=<%=n %> disabled="true" ></td>
     <td> <input type="text" class="form-control" name="parmesh" id=<%=o %> disabled="true" ></td>

     <td> <button type="button" class="btn btn-link" onclick="myFunction(<%=i %>,<%=j %>,<%=k%>,<%=l%>,<%=n %>,<%=o %>)" id=<%=m %> disabled="true" >save</button></td>
      
    </div>
    <%
    }
    %>
   
     <input type="submit" class=" btn btn-primary"value="Submit form" id="submit_button" disabled="true">
  
  </form>
  <input type="button" class=" btn btn-primary" value="Go Back" onclick="history.back(-1)" />
</div>
<script>
function myFunction(x,y,z,m,n,a) {
  
   document.getElementById(x).value=document.getElementById(x).value+"*"+document.getElementById(y).value+"*"+document.getElementById(z).value+"*"+document.getElementById(m).value+"*"+document.getElementById(n).value+"*"+document.getElementById(a).value;
   document.getElementById("submit_button").disabled=false;
}
function fun2(u,v,x,y,z,a,b){
	if(document.getElementById(b).checked==true)
		{
		document.getElementById(u).disabled=false;
		document.getElementById(v).disabled=false;
	document.getElementById(x).disabled=false;
	document.getElementById(y).disabled=false;
	document.getElementById(z).disabled=false;
	document.getElementById(a).disabled=false;
		}
	else
		{
		document.getElementById(u).disabled=true;
		document.getElementById(v).disabled=true;
		document.getElementById(x).disabled=true;
		document.getElementById(y).disabled=true;
		document.getElementById(z).disabled=true;
		document.getElementById(a).disabled=true;
		}
	
	document.getElementById("submit_button").disabled=true;
	
	
}
</script>
</body>
</html>
