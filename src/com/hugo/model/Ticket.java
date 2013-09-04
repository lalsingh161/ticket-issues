package com.hugo.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
//@Entity
//@Table(name="ticket_master")
@XmlRootElement
public final class Ticket {
	
	private Integer ticketno ;
	private String summary;
	private String description;
	private String component;
	private String priority;
	private Double version;
	private Integer milestone;
	private String type;
	private String owner;
	private String status;
	private String createddate;
	private String reporter;
	private String isClosed;
	//private String resolution;
	//@Column(name="ticketno")
	public Integer getTicketno() {
		return ticketno;
	}
	public void setTicketno(Integer ticketno) {
		this.ticketno = ticketno;
	}
	//@Column(name="summary")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	//@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//@Column(name="component")
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	//@Column(name="priority")
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	//@Column(name="version")
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
	}
	//@Column(name="milestone")
	public Integer getMilestone() {
		return milestone;
	}
	public void setMilestone(Integer milestone) {
		this.milestone = milestone;
	}
	//@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//@Column(name="owner")
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	//@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	
	//@Column(name="createdate")
	public String getCreatedDate() {
		return createddate;
	}
	public void setCreatedDate(String createddate) {
		this.createddate = createddate;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	
/*	@Override
	public String toString() {
		return "Ticket [ticketno=" + ticketno + ", summary=" + summary + ", description=" + description
				+ ", component=" + component + ",priority="+priority+",version="+version+",milestone="+milestone+",type="+type+",owner="+owner+",status="+status+"]";
	}
	*/
	
}
