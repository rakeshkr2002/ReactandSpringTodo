package com.rocks.ReactandSpringTodo.service;

import java.util.List;

import com.rocks.ReactandSpringTodo.model.Todo;

public interface TodoService {

    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    void deleteTodo(Long id);
} 