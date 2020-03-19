package com.codejava.todoapp.todoController;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codejava.todoapp.Repository.TodoJpaRepository;
import com.codejava.todoapp.todoEntity.Todo;
import com.codejava.todoapp.todoService.TodoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoControllerJpa {
	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoJpaRepository todoJpaRepository;

	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getTodoList(@PathVariable String username) {
		return todoJpaRepository.findByUsername(username);
		/*
		 * List<Todo> todos = todoService.findAll(); return todos;
		 */
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable String username, @PathVariable long id) {
		return todoJpaRepository.findById(id).get();

	}

	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		/* Todo todo = todoService.deleteById(id) */;
		todoJpaRepository.deleteById(id);

		return ResponseEntity.noContent().build();

		// return ResponseEntity.notFound().build();
	}

	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		/* Todo todoUpdated = todoService.save(todo); */
		Todo todoUpdated = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody Todo todo) {
		/* Todo createdTodo = todoService.save(todo); */
		todo.setUsername(username);
		Todo todoUpdated = todoJpaRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoUpdated.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
