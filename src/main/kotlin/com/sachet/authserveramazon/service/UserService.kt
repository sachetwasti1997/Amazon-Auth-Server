package com.sachet.authserveramazon.service

import com.sachet.authserveramazon.model.User
import com.sachet.authserveramazon.model.UserLogin
import com.sachet.authserveramazon.repository.UserRepo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class UserService(
    var userRepo: UserRepo,
    var bCryptPasswordEncoder: BCryptPasswordEncoder,
    var jwtService: JwtService
) {

    fun saveUser(user: User): String {
        val userExist = user.email?.let { userRepo.findByEmail(it) }
        if (userExist?.isPresent == true) {
            throw Exception("User Already Exist, please try with different email address!")
        }
        user.password = bCryptPasswordEncoder.encode(user.password)
        return jwtService.generateToken(userRepo.save(user))
    }

    fun userLogin(userLogin: UserLogin): String {
        val userExist = userLogin.email?.let { userRepo.findByEmail(it) }
        if (userExist?.isPresent == false) {
            throw Exception("Invalid Credentials!")
        }
        val foundUser = userExist!!.get()
        if (!bCryptPasswordEncoder.matches(userLogin.password, foundUser.password)) {
            throw Exception("Invalid Credentials!")
        }
        return jwtService.generateToken(foundUser)
    }

}