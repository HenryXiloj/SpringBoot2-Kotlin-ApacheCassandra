package com.henry.controller

import com.henry.model.Users
import com.henry.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["http://localhost:9000"])
@RestController
@RequestMapping("/ws")
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<MutableList<Users>>? {
        return ResponseEntity(userService.findAllUsers(), HttpStatus.OK)
    }

    @PostMapping("/save")
    fun save(@RequestBody user: Users):  ResponseEntity<Users>?{
        return ResponseEntity(userService.saveUser(user), HttpStatus.OK)
    }

    @PutMapping("/update/{email:.*}")
    fun update(@PathVariable email: String, @RequestBody user: Users):  ResponseEntity<Users>?{
        return ResponseEntity(userService.updateUser(email, user), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{email:.*}")
    fun delete(@PathVariable email: String): ResponseEntity<Unit> {
        return ResponseEntity(userService.deleteUser(email), HttpStatus.OK)
    }




}