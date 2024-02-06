package com.example.jpaparameter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/users")
class UserResource(
  private val userRepository: UserRepository
) {

  @GetMapping()
  fun findUser(
    @RequestParam(required = true) name: String,
    @RequestParam(required = false, defaultValue = "2")  previousCount: Int
  ): List<User> {
    return userRepository.findUser(name, previousCount)
  }
}