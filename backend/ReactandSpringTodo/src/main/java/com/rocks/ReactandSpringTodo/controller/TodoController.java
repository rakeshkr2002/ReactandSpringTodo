package com.rocks.ReactandSpringTodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rocks.ReactandSpringTodo.model.ApiResponse;
import com.rocks.ReactandSpringTodo.model.Todo;
import com.rocks.ReactandSpringTodo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/api")
    public ApiResponse homeController() {
        ApiResponse res = new ApiResponse();
        res.setMessage("welcome to todo api");
        res.setStatus(true);
        return res;
     }
  

    @GetMapping("/api/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/api/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/api/todos/{id}")
    public ApiResponse deleteTodo(@PathVariable Long id) throws Exception {
        todoService.deleteTodo(id);
        ApiResponse res = new ApiResponse();
        res.setMessage("todo deleted succesfully");
        res.setStatus(true);
        return res;
     }
}