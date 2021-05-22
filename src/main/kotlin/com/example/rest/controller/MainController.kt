package com.example.rest.controller

import com.example.rest.model.TodoItem
import com.example.rest.repository.TodoRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.nio.file.Files.delete
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/todo")
class MainController(private val todoRepo:TodoRepo) {
    @GetMapping("/all")
    fun getTodo(): List<TodoItem> = todoRepo.findAll()

    @PostMapping("/add")
    fun addTodo(@Valid @RequestBody todoItem: TodoItem): TodoItem = todoRepo.save(todoItem)

    @GetMapping("/{id}")
    fun getTodoItem(@PathVariable("id") id: Long): ResponseEntity<TodoItem> {
        return todoRepo.findById(id).map { todoItem ->
            ResponseEntity.ok(todoItem)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PostMapping("/update")
    fun todoUpdate(@RequestBody todoItem: TodoItem): TodoItem = todoRepo.save(todoItem)

    @GetMapping("/{id}/delete")
    fun deleteTodoItem(@PathVariable("id") id: Long): ResponseEntity<Void> {
        return todoRepo.findById(id).map { todoItem ->
            todoRepo.delete(todoItem)
            ResponseEntity<Void> (HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}