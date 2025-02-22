package com.rocks.ReactandSpringTodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocks.ReactandSpringTodo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
    
}
