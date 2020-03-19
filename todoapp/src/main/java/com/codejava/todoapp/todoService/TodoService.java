package com.codejava.todoapp.todoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codejava.todoapp.todoEntity.Todo;
@Service
public class TodoService {

	private static List<Todo> todos=new ArrayList<>();
	private static int counter=0;
	static {
		todos.add(new Todo(++counter,"nadeem","Learning Rest",new Date(),false));
		todos.add(new Todo(++counter,"fahad","Learning Micro Webservices",new Date(),false));
		todos.add(new Todo(++counter,"patel","Learning Angular",new Date(),false));
	}
	
	public List<Todo> findAll() {
		
		return todos;
	}
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++counter);
			todos.add(todo);
			
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo= findById(id);
		if(todo==null) {
			return null;
		}else {
			todos.remove(todo);
		}
		return todo;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}

}
