package com.example.rest.controller

import com.example.rest.model.TodoItem
import com.example.rest.repository.TodoRepo
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*


@RestController
@RestControllerAdvice
class MainController(private var todoRepo:TodoRepo) {
    @GetMapping("/todo/all")
    fun getTodo(): List<TodoItem> { return todoRepo.findAll() }

    @GetMapping("/todo/{id}")
    fun getTodoItem(@PathVariable("id") id: Integer): Optional<TodoItem> {
        return todoRepo.findById(id)
    }

    @PostMapping("/todo/add")
    fun addTodo(@RequestBody todoItem: TodoItem): TodoItem {
        return todoRepo.save(todoItem)
    }

    @PostMapping("/todo/update")
    fun todoUpdate(@RequestBody todoItem: TodoItem): TodoItem {
        return todoRepo.save(todoItem)
    }

    @GetMapping("/todo/{id}/delete")
    fun deleteTodoItem(@PathVariable("id") id: Integer): String {
        try {
            todoRepo.deleteById(id)
        } catch (e: Exception) {
            return "Failed"
        }
        return "Successful"
    }

}