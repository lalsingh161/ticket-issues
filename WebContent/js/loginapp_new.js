 $(document).ready(function () {
		
	 
	 	$("#getTickets").click(getTicketDetails);
	 	$("#loginAuth").click(loginAuthentication);
	 	$("#newregistration").click(newRegistration);
 
 });
 
 

 
 
function getTicketDetails(){
	 
	 var successFunction = function(data,textStatus,jXHR){
		 
		 
		 $(data.ticket).each(function(index){
			 
		 
			 $("#ticketTable tbody").append("<tr><td>"+this.ticketno+"</td><td>"+this.summary+"</td><td>"+this.description+"</td><td>"+this.component+"</td><td>"+this.priority+"</td><td>"+this.version+"</td><td>"+this.milestone+"</td><td>"+this.type+"</td><td>"+this.owner+"</td><td>"+this.status+"</td><td>"+this.reporter+"<td><a target=_blank href='www.google.com'>edit</a><td><a target=_blank href='www.google.com'>close</a></tr>");
	
		 });
		 };
	 
	 var errorFunction = function(){
		 alert("error");
	 };
	 
	
	 $.ajax({
		 type: "GET",
		 url: "http://localhost:8080/Loginapp/services/client/get1/",
		 
		 dataType:"json",
		 data:'{}',
		 success:successFunction,
		 error:errorFunction,
		 });
	 
 }
 
 
function loginAuthentication(){
	var successFunction = function(data,status,jXHR){
		//alert(JSON.stringify(data));
		alert(data);
		
		var msg = data.toString();
		if(msg === "success"){
			window.location="http://localhost:8080/Loginapp/ticketregistration.html";
		}
		
		//redirect
			//var url="http://localhost:8080/Loginapp/ticketregistration.html";
		
		
	};
	
	var errorFunction = function(data,status,jXHR){
		alert("loginAuthentication error");
	};
	 var userName = $("#txt1").val();
	 var password = $("#txt2").val();
	 if(userName==0){
		 
		 alert("please enter Username");
		 e.preventDefault();
	 }
	 var url="http://localhost:8080/Loginapp/services/client/login/"+userName+"/"+password;
	 ajaxRequest(url,'POST','application/json',successFunction,errorFunction);
	
}
function ajaxRequest(url,verbtype,dataType,successFunction,errorFunction){
	$.ajax({
		 type:verbtype,
		 url: url,
		 dataType:dataType,
		 data:'{}',
		 success:successFunction,
		 error:errorFunction
		 });
}
function newRegistration(){
	var successFunction = function(data,status,jXHR){
		alert("registartion successfull!!");
	};
	
	var errorFunction = function(data,status,jXHR){
		alert("Registration error");
	};

	 var userName = $("#userName").val();
	 var userPassword = $("#userPassword").val();
	 var userEmail = $("#userEmail").val();
	 var phoneNO = $("#phoneNO").val();
	 
	 
	 if ($.trim(userEmail).length == 0) {
		            alert('Please enter valid email address');
		             e.preventDefault();
			        }
			        if (validateEmail(userEmail)) {
		            // alert('Email is valid');
		         }
		         else {
		             alert('Invalid Email Address');
		             e.preventDefault();
		         }
			       
			        
			        if ($.trim(phoneNO).length == 0) {
			            alert('Please enter mobile number');
			             e.preventDefault();
				        }
				        if (validateMobileNumber(phoneNO)) {
			            // alert('Email is valid');
			         }
			         else {
			             alert('Invalid phone number');
			             e.preventDefault();
			         }
			        
			        
	 //alert(phoneNo);
	 var url="http://localhost:8080/Loginapp/services/client/post1/"+userName+"/"+userPassword+"/"+userEmail+"/"+phoneNO;
	 ajaxRequest(url,'POST','application/json',successFunction,errorFunction);
	 
	
}


function validateEmail(userEmail) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(userEmail)) {
        return true;
    }
    else {
        return false;
    }
}

function validateMobileNumber(phoneNO){
	var mobile=/^[1-9]{1}[0-9]{9}$/;
	if (mobile.test(phoneNO)){
		return true
	}
	else {
        return false;
    }
}