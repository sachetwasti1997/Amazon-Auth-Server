package com.sachet.authserveramazon.repository

import com.sachet.authserveramazon.model.User
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepo: CrudRepository<User, Int> {
    fun findByEmail(email: String): Optional<User>
}