package com.hugo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.hugo.factory.ConnectionFactory;
import com.hugo.model.Client;
import com.hugo.model.Ticket;
public class ClientDAO extends ConnectionFactory {

	private static ClientDAO instance;
	public static ClientDAO getInstance(){
		if(instance == null)
			instance = new ClientDAO();
		return instance;
	}
	
	
	public ArrayList<Client> arrayList(String username){
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Client> clientes = null;
		
		connection = createConnection();
		clientes = new ArrayList<Client>();
		try {
			
			pstmt = connection.prepareStatement("select username,password from app_user where username='"+username+"'");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Client cliente = new Client();
				
				//cliente.setId(rs.getInt("id"));
				cliente.setName(rs.getString("username"));
				cliente.setPassword(rs.getString("password"));
				//cliente.setPhone(rs.getLong("phone"));
				//cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		} finally {
			fecharConnection(connection, pstmt, rs);
		}
		return clientes;
	}

	public Client create(Client client) {
        Connection connection = null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
           // c = ConnectionHelper.getConnection();
            ps = connection.prepareStatement("INSERT INTO app_user (username, phone,email,password) VALUES (?, ?, ?, ?)");
            //ps.setInt(1,client.getId());
            ps.setString(1, client.getName());
          
            ps.setLong(2,client.getPhone());
            ps.setString(3,client.getEmail());
            ps.setString(4, client.getPassword());
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
      return client;
        
    }


	public String login(String userName, String userPassword) {
		// TODO Auto-generated method stub
		
		 Connection connection = null;
	        PreparedStatement ps = null;
	        ResultSet rs=null;
	        connection = createConnection();
	        try {
				
				ps = connection.prepareStatement("select username,password from app_user where username='"+userName+"' and password='"+userPassword+"' and is_deleted='n'");
				rs = ps.executeQuery();
				
			if(rs.next()){
					return "success";
					
					
				}
			else{
					return "failure:Please enter valid username and password!!";
				}
				
				
			} catch (Exception e) {
				System.out.println("Error: " + e);
				
				return e.toString();
			} 
			
	}


	public String register(String userName, String userPassword,
			String userEmail, Long phoneNO) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
          
            ps = connection.prepareStatement("INSERT INTO app_user (username, password,email,phone) VALUES (?, ?, ?, ?)");
            ps.setString(1,userName);
            ps.setString(2, userPassword);
            ps.setString(3, userEmail);
            ps.setLong(4, phoneNO);
            
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
		
		return "inserted successfully";
	}


	
//this is for ticketing
	
	public String registerTicket(String ticketSummary,String ticketReporter,String ticketDescription,
			String ticketComponent, String ticketPriority,Double ticketVersion,Integer ticketMilestone,
			String ticketType,String ticketOwner,String ticketStatus) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
          
            ps = connection.prepareStatement("INSERT INTO ticket_master (summary, description,component,priority,version,milestone,type,owner,status,reporter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1,ticketSummary);
            ps.setString(2, ticketDescription);
            ps.setString(3, ticketComponent);
            ps.setString(4, ticketPriority);
            ps.setDouble(5,ticketVersion);
            ps.setInt(6, ticketMilestone);
            ps.setString(7, ticketType);
            ps.setString(8, ticketOwner);
            ps.setString(9, ticketStatus);
            ps.setString(10, ticketReporter);
            
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
		
		return "inserted successfully";
	}

	
	//getting ticket data
	
	public ArrayList<Ticket> arrayList(){
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Ticket> tickets = null;
		
		connection = createConnection();
		tickets = new ArrayList<Ticket>();
		try {
			
			pstmt = connection.prepareStatement("select ticketno,summary,description,component,priority,version,milestone,type,owner,status,reporter,is_closed from ticket_master");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Ticket tickete = new Ticket();
				
				tickete.setTicketno(rs.getInt("ticketno"));
				tickete.setSummary(rs.getString("summary"));
				tickete.setDescription(rs.getString("description"));
				tickete.setComponent(rs.getString("component"));
				tickete.setPriority(rs.getString("priority"));
				tickete.setVersion(rs.getDouble("version"));
				tickete.setMilestone(rs.getInt("milestone"));
				tickete.setType(rs.getString("type"));
				tickete.setOwner(rs.getString("owner"));
				tickete.setStatus(rs.getString("status"));
				tickete.setReporter(rs.getString("reporter"));
				tickete.setIsClosed(rs.getString("is_closed"));
				tickets.add(tickete);

			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		} finally {
			fecharConnection(connection, pstmt, rs);
		}
		return tickets;
	}


/*	public String updateTicket(Integer ticketNo,String ticketComment,String ticketStatus) {
		// TODO Auto-generated method stub
		Connection connection= null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
          
            ps = connection.prepareStatement("update ticket_details set comment='"+ticketComment+"',status='"+ticketStatus+"' where ticketno="+ticketNo);
           // ps.setString(1,ticketReporter);
           // ps.setString(2, ticketStatus);
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
		
		return "updated successfully";

		
	}
	*/
	
	public String updateTicket(Integer ticketNo,String ticketOwner,String ticketStatus, String ticketComment) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
          
            ps = connection.prepareStatement("INSERT INTO ticket_details_new (ticketno,comment,owner,status) VALUES (?, ?, ?, ?)");
            ps.setInt(1,ticketNo);
            ps.setString(2,ticketComment);
            ps.setString(3,ticketOwner);
            ps.setString(4,ticketStatus);
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
		
		return "inserted successfully";
	}
	
	//ticket closing
	public String closeTicket(Integer ticketNo,String resolution) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        PreparedStatement ps = null;
        connection = createConnection();
        try {
          
        	ps = connection.prepareStatement("update ticket_master set is_closed='y',resolution='"+resolution+"' where ticketno="+ticketNo);
        	ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
          
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(connection);
		}
		
		return "closed successfully";
	}

	
}
