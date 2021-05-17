package com.example.rest.model

import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.*


@Component
@Entity
@Table(name="todo_list")
data class TodoItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Integer,
    var date: Date? = Date("2020/05/21"),
    var title: String,
    @Column(name = "Description") var des: String,
)
{
}