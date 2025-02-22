package com.rocks.ReactandSpringTodo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocks.ReactandSpringTodo.model.Todo;
import com.rocks.ReactandSpringTodo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

   @Override
public void deleteTodo(Long id) throws NoSuchElementException {
    Todo todo = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Todo not exist"));
    todoRepository.delete(todo);
}

}
