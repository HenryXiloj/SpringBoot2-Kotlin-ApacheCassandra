package com.henry.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table
data class Users(@PrimaryKey
                 var email: String, var name: String, var age: Int)
