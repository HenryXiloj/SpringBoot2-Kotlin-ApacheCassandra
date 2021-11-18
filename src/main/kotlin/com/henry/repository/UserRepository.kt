package com.henry.repository

import com.henry.model.Users
import org.springframework.data.cassandra.repository.CassandraRepository

interface UserRepository : CassandraRepository<Users,String> {
    fun findByNameContaining(name: String?): List<Users?>?

}