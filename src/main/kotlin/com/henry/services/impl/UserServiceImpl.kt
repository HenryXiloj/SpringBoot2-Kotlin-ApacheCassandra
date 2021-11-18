package com.henry.services.impl

import com.henry.model.Users
import com.henry.repository.UserRepository
import com.henry.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository;

    override fun byContName(name: String): List<Users?>? {
        return userRepository.findByNameContaining(name)
    }

    override fun findAllUsers(): MutableList<Users> {
        return userRepository.findAll()
    }

    override fun saveUser(user: Users): Users {
        return userRepository.save(user)
    }

    override fun updateUser(email: String, user: Users): Users {
        val obj: Optional<Users> = userRepository.findById(email)
        obj.get().age = user.age
        obj.get().name = user.name
        return userRepository.save(obj.get())

    }

    override fun deleteUser(email: String) {
      userRepository.deleteById(email)
    }
}