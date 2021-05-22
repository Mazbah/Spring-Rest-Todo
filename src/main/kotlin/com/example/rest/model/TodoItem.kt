package com.example.rest.model

import java.util.*
import javax.persistence.*


@Entity
@Table(name="todo_list")
data class TodoItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Long=0,
    @Column(name = "date")var date: Date? = Date("2020/05/21"),
    @Column(name = "title")var title: String,
    @Column(name = "description") var des: String,
)
