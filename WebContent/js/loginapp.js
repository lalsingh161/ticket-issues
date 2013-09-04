 $(document).ready(function () {
		
	 
	 	$("#getTickets").click(getTicketDetails);
	 	$("#loginAuth").click(loginAuthentication);
	 	$("#newregistration").click(newRegistration);
	 	$("#ticketRegistration").click(ticketRegistration);
	 	$("#edit_ticket").click(edit_ticket);
	 	$("#close_ticket").click(closeTicket);
	 	
 });
 
function getTicketDetails(){
	
	
	$("#ticketdetails").show();/*dialog({
	    resizable: false,
	    height:480,
	    width: 1020,
	    modal: true
	});*/
	 
	 var successFunction = function(data,textStatus,jXHR){
		 $("#ticketTable tbody tr").remove();
			  $(data.ticket).each(function(index){
				
				 if(this.isClosed==='y'){
					$("#ticketTable tbody").append("<tr><td>"+this.ticketno+"</td><td>"+this.summary+"</td><td>"+this.description+"</td><td>"+this.component+"</td><td>"+this.priority+"</td><td>"+this.version+"</td><td>"+this.milestone+"</td><td>"+this.type+"</td><td>"+this.owner+"</td><td>"+this.status+"</td><td>"+this.reporter+"</td><td>TicketClosed</td><td></td></tr>");	
				} else{ 
					$("#ticketTable tbody").append("<tr><td>"+this.ticketno+"</td><td>"+this.summary+"</td><td>"+this.description+"</td><td>"+this.component+"</td><td>"+this.priority+"</td><td>"+this.version+"</td><td>"+this.milestone+"</td><td>"+this.type+"</td><td>"+this.owner+"</td><td>"+this.status+"</td><td>"+this.reporter+"<td><a target=_blank onclick='editTicket("+this.ticketno+")'>edit</a><td><a onclick='closeTicket_table("+this.ticketno+")'>close</a></tr>");
				}
			  });	 
	 };
	 
	 var errorFunction = function(){
		 alert("error");
	 };
	
	 $.ajax({
		 type: "GET",
		 url: "http://localhost:8080/Loginapp/services/client/getTicketDetails/",
		 
		 dataType:"json",
		 data:'{}',
		 success:successFunction,
		 error:errorFunction,
		 }); 
 };
 
 
function loginAuthentication(){
	var successFunction = function(data,status,jXHR){
		//alert(data);
		
		var msg = data.toString();
		if(msg === "success"){
			
			$('#loginstyle').hide();
			$('#registrationstyle').hide();
			$("#homepage").show();
			//window.location="http://localhost:8080/Loginapp/homepage.html";
		}	
		else{
			alert(data);
		}
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
	
};

function ajaxRequest(url,verbtype,dataType,successFunction,errorFunction){
	$.ajax({
		 
		 url: url,
		 type:verbtype,
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
			            
			         }
			         else {
			             alert('Invalid phone number');
			             e.preventDefault();
			         }
			        
	 var url="http://localhost:8080/Loginapp/services/client/newRegistration/"+userName+"/"+userPassword+"/"+userEmail+"/"+phoneNO;
	 ajaxRequest(url,'POST','application/json',successFunction,errorFunction);
	
};


function validateEmail(userEmail) {
    var email = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (email.test(userEmail)) {
        return true;
    }
    else {
        return false;
    }
};

function validateMobileNumber(phoneNO){
	var mobile=/^[1-9]{1}[0-9]{9}$/;
	if (mobile.test(phoneNO)){
		return true;
	}
	else {
        return false;
    }
};
function editTicket(t){
	
	$("#editticketNo").val(t);
	$("#editticketNo1").val(t);
	
	
	$("#ticketbdy").dialog({
        resizable: false,
        height:300,
        width: 600,
        modal: true
    });
	return false;
};
function closeTicket_table(ticketNo){
	$("#closeticketNo").val(ticketNo);
	$("#closeticketNo1").val(ticketNo);
	
	$("#ticket_close").dialog({
        resizable: false,
        height:200,
        width: 600,
        modal: true
    });
}
function closeTicket(){
	
	var successFunction = function(data,textStatus,jXHR){
		alert(data);
		};	
	
	var errorFunction = function(data,textStatus,jXHR){
		alert("success");
	};
	var closeticketNo = $("#closeticketNo").val();
	var resolution= $("#resolution").val();
	$.ajax({
		 type: "PUT",
		 url: "http://localhost:8080/Loginapp/services/client/closeTicket/"+closeticketNo+"/"+resolution,
		 dataType:"json",
		 data:'{}',
		 success:successFunction,
		 error:errorFunction
		 }); 
	
};

function registerTicket(){
	$("#ticketreg").dialog({
    resizable: false,
    height:350,
    width: 600,
    modal: true
});
return false;
};
function ticketRegistration(){
	
	var successFunction = function(data,status,jXHR){
		
		alert("registration success!!");
	};
	var errorFunction=function(){
		alert("error");
	};
	
        
	 var ticketSummary = $("#newticketSummary").val();
	 //var ticketReporter = $("#newticketReporter").val();
	 var ticketReporter="rakesh";
	 var ticketDescription = $("#newticketDescription").val();
	 var ticketComponent = $("#newticketComponent").val();
	 var ticketPriority = $("#newticketPriority").val();
	 var ticketVersion = $("#newticketVersion").val();
	 var ticketMilestone = $("#newticketMilestone").val();
	 var ticketType = $("#newticketType").val();
	 var ticketOwner = $("#newticketOwner").val();
	 //var ticketStatus = $("#newticketStatus").val();
	 var ticketStatus="new";
	// var url="http://localhost:8080/Loginapp/services/client/ticketpost/"+ticketSummary+"/"+ticketReporter+"/"+ticketDescription+"/"+ticketComponent+"/"+ticketPriority+"/"+ticketVersion+"/"+ticketMilestone+"/"+ticketType+"/"+ticketOwner+"/"+ticketStatus;
	 //ajaxRequest(url,'POST','application/json',successFunction,errorFunction);
	 
	 $.ajax({
		 type: "POST",
		 url: "http://localhost:8080/Loginapp/services/client/ticketpost/"+ticketSummary+"/"+ticketReporter+"/"+ticketDescription+"/"+ticketComponent+"/"+ticketPriority+"/"+ticketVersion+"/"+ticketMilestone+"/"+ticketType+"/"+ticketOwner+"/"+ticketStatus,
		 dataType:"application/json",
		 data:'{}',
		 success:successFunction,
		 error:errorFunction
		 }); 
	
	 
}

function edit_ticket(){
	
	var successFunction = function(data,status,jXHR){
		
		alert("registration success!!");
	};
	var errorFunction=function(){
		alert("error");
	};
	
	 var editticketNo = $("#editticketNo").val();
	 var editticketComment = $("#editticketComment").val();
	 /*var editticketReporter = $("#editticketReporter").val();
	 var editticketComponent = $("#editticketComponent").val();
	 var editticketPriority = $("#editticketPriority").val();
	 var editticketVersion = $("#editticketVersion").val();
	 var editticketSummary = $("#editticketSummary").val();
	 var editticketMilestone = $("#editticketMilestone").val();
	 var editticketType = $("#editticketType").val();*/
	 var editticketOwner = $("#editticketOwner").val();
	 var editticketStatus = $("#editticketStatus").val();
	
	 
	 $.ajax({
		 type: "POST",
		 url: "http://localhost:8080/Loginapp/services/client/ticketupdate/"+editticketNo+"/"+editticketOwner+"/"+editticketStatus+"/"+editticketComment,
		 dataType:"application/json",
		 data:'{}',
		 success:successFunction,
		 error:errorFunction
		 }); 
	
	 
}
