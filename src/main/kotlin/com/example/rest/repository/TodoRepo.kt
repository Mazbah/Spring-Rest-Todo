package com.example.rest.repository

import com.example.rest.model.TodoItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepo: JpaRepository<TodoItem, Long> {

}