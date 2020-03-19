package com.codejava.todoapp.todoEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Todo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String username;

private String description;

private Date targetDate;

private boolean isCompleted;

public Todo() {
	
}

public Todo(long id, String username, String description, Date targetDate, boolean isCompleted) {
	this.id = id;
	this.username = username;
	this.description = description;
	this.targetDate = targetDate;
	this.isCompleted = isCompleted;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getDate() {
	return targetDate;
}

public void setDate(Date targetDate) {
	this.targetDate = targetDate;
}

public boolean isCompleted() {
	return isCompleted;
}

public void setCompleted(boolean isCompleted) {
	this.isCompleted = isCompleted;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Todo other = (Todo) obj;
	if (id != other.id)
		return false;
	return true;
}


}
