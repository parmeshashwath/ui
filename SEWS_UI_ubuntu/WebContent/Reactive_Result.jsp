<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 30%;
      margin: auto;
      postion:relative;
	  bottom:420px;
 	  left:20%;
  		max-height: 800px !important;
  }
  
  .heading{
  background-color:#505050;
  position:relative;
  top:0%;
  width:1700px;
  height:80px;
  
  
  }
 .container
 {
 position:relative;
  bottom:90px;
  heigth:520px;
  left:5%
 }
 .container1
 {
 position:relative;
  top:350px;
  heigth:120px;
  left:55%
 }
 

#uploadBtn
 {
 position:relative;
  bottom:10px;
  left:410px;
  heigth:10px;
 }
 #submitbutton
 {
 position:relative;
  bottom:5px;
  left:170px;
  heigth:10px;
 }
  </style>
</head>
<body>


<div class ="heading">
<p align="center">
<font size="20" color="#FFFFFF">Symptom Based Early Warning System</font> </p>
</div>




<div class="container1">
<form role="form" action="sevletresultpath1">

<input name="filename" type="text" class="form-control" id="filepath" style="width:400px;">
<input id="uploadBtn" type="file" class="upload" />



 <label for="reg_exp_id">Regular Expressions</label>
  <input type="text" name="reg_exp" id="reg_exp_id" value="" style="width:100px"/>






    

   <button type="submit" class="btn btn-primary" id="submitbutton">Submit</button>

</form>
 </div>


<script>
  document.getElementById("uploadBtn").onchange = function () {
	    document.getElementById("filepath").value = this.value;
  };
  
  
	  
  
  </script>
  
  <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    <div class="item">
        <img src="images/Options-Analysis1.jpg" alt="self-Healing" width="460" height="100">
          
      </div>
      <div class="item active">
        <img src="images/img1_SH.jpg" alt="Proactive-Monitoring" width="460" height="100">
        
        
      </div>

      <div class="item">
        <img src="images/img2_TA.jpg" alt="Analysis" width="460" height="100">
        
       
        </div>
    
      

     
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>

</html>