package com.codejava.todoapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codejava.todoapp.todoEntity.Todo;
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
	
	List<Todo> findByUsername(String username);

}
