package com.example.jpaparameter

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Int> {


  @Query(
    value = """
      SELECT u.*
      FROM users u
      WHERE u.name = :name
      ORDER BY u.id DESC
      LIMIT :previousCount
    """,
    nativeQuery = true
  )
  fun findUser(name: String, previousCount: Int): List<User>
}