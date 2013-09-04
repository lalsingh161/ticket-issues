package com.hugo.resource;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//import org.json.JSONObject;

import com.hugo.dao.ClientDAO;
import com.hugo.model.Client;
import com.hugo.model.Ticket;


@Path("/client")
public class ClientResource {

	ClientDAO dao=new ClientDAO();
	//private String ticketComment;
	@GET
	@Path("/get/{username}")
	@Produces("application/json")
	public ArrayList<Client> arrayList(@PathParam("username") String username){
		//return new ClientController().arrayList(username);
		return ClientDAO.getInstance().arrayList(username);
			
	}
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Client create(Client client) {
		System.out.println("creating client");
		return dao.create(client);
	}
	
	
	@Path("/newRegistration/{userName}/{userPassword}/{userEmail}/{phoneNO}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})	
	public String register(@PathParam("userName") String userName, @PathParam("userPassword") String userPassword,@PathParam("userEmail") String userEmail,@PathParam("phoneNO") Long phoneNO) {
		ClientDAO dao1=new ClientDAO();
		System.out.println(userName+" "+userPassword+" "+userEmail+" "+phoneNO);
		String newuserregistration_data= dao1.getInstance().register(userName,userPassword,userEmail,phoneNO);
		return newuserregistration_data;
	}
	
	
	@Path("/login/{userName}/{userPassword}")
	@POST
	//@Produces(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public String login(@PathParam("userName") String userName, @PathParam("userPassword") String userPassword,@Context HttpServletResponse response){
		System.out.println(userName+" : "+userPassword);
		//UriInfo uriInfo = null;
		
		ClientDAO clientdao=new ClientDAO();
		@SuppressWarnings("static-access")
		String data=clientdao.getInstance().login(userName,userPassword);
		//return data;
		if(data.toString().equals("success")){
			System.out.println(data);
			
			
		}
		return data;
		
		//return null;
		
	}	
	
	
/*	
//put method	

@SuppressWarnings("static-access")
//@PUT
@Path("/ticketput")
@POST

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String updateTicket(@FormParam("ticketno") Integer ticketNo,@FormParam("ticketComment") String ticketReporter,@FormParam("ticketStatus") String ticketStatus) {
	ClientDAO ticketdetails=new ClientDAO();
	
	String updateticketdetails= ticketdetails.getInstance().updateTicket(ticketNo, ticketComment,ticketStatus);
	return updateticketdetails;
}*/

/*
 * line32://@Produces({ MediaType.APPLICATION_JSON})
 * line44//@Produces("application/json")
 * line45//@Consumes("application/json")
 * @POST
	@Path("/post1")
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//@Produces("application/json")
	//@Consumes("application/json")
	public String register(@FormParam("userName") String userName, @FormParam("userPassword") String userPassword,@FormParam("userEmail") String userEmail,@FormParam("phoneNo") Long phoneNO,@Context HttpServletResponse response) {
		System.out.println("creating client");
		
		ClientDAO dao1=new ClientDAO();
		String data1= dao1.getInstance().register(userName,userPassword,userEmail,phoneNO);
		return data1;
	}
 * */
	
	
	

	//ticketing
	
	


@SuppressWarnings("static-access")
@Path("/ticketpost/{ticketSummary}/{ticketReporter}/{ticketDescription}/{ticketComponent}/{ticketPriority}/{ticketVersion}/{ticketMilestone}/{ticketType}/{ticketOwner}/{ticketStatus}")
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
public String registerTicket(@PathParam("ticketSummary") String ticketSummary,@PathParam("ticketReporter") String ticketReporter, @PathParam("ticketDescription") String ticketDescription,@PathParam("ticketComponent") String ticketComponent,@PathParam("ticketPriority") String ticketPriority,@PathParam("ticketVersion") Double ticketVersion,@PathParam("ticketMilestone") Integer ticketMilestone,@PathParam("ticketType") String ticketType,@PathParam("ticketOwner") String ticketOwner,@PathParam("ticketStatus") String ticketStatus) {
	ClientDAO ticketdetails=new ClientDAO();
	
	//System.out.println(userName+" "+userPassword+" "+userEmail+" "+phoneNO);
	String ticketdetails1= ticketdetails.getInstance().registerTicket(ticketSummary,ticketReporter,ticketDescription,ticketComponent,ticketPriority,ticketVersion,ticketMilestone,ticketType,ticketOwner,ticketStatus);
	return ticketdetails1;
}



@GET
@Path("/getTicketDetails")
@Produces(MediaType.APPLICATION_JSON) 
//@Produces("application/json")
public ArrayList<Ticket> arrayList(){
	//return new ClientController().arrayList();
	return ClientDAO.getInstance().arrayList();
	//JSONObject jsonData = (JSONObject) JSONSerializer.toJSON( new ClientController().arrayList());
    //String name = jsonData.getString("name");	
	
}


@SuppressWarnings("static-access")
@Path("/ticketupdate/{editticketNo}/{editticketOwner}/{editticketStatus}/{editticketComment}")
@POST
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)	
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})
public String updateTicket(@PathParam("editticketNo") Integer ticketNo,@PathParam("editticketOwner") String ticketOwner,@PathParam("editticketStatus") String ticketStatus,@PathParam("editticketComment") String ticketComment) {
	ClientDAO ticketdetails_c=new ClientDAO();
	
	//System.out.println(userName+" "+userPassword+" "+userEmail+" "+phoneNO);
	String update_ticketdetails= ticketdetails_c.getInstance().updateTicket(ticketNo,ticketOwner,ticketStatus,ticketComment);
	return update_ticketdetails;
}


@Path("/closeTicket/{closeticketNo}/{resolution}")
@PUT
//@Produces(MediaType.TEXT_HTML)
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED})

public String CloseTicket(@PathParam("closeticketNo") Integer ticketNo,@PathParam("resolution") String resolution){
	//System.out.println(userName+" : "+userPassword);
	//UriInfo uriInfo = null;
	
	ClientDAO clientdao=new ClientDAO();
	@SuppressWarnings("static-access")
	String close_ticket_data=clientdao.getInstance().closeTicket(ticketNo,resolution);
	return close_ticket_data;
	
}	
}
