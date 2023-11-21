package com.sachet.authserveramazon.controller

import com.sachet.authserveramazon.model.User
import com.sachet.authserveramazon.model.UserLogin
import com.sachet.authserveramazon.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    var userService: UserService
) {

    @PostMapping("/signup")
    fun signUpUser(@RequestBody user: User) =
        ResponseEntity.ok(userService.saveUser(user))

    @PostMapping("/login")
    fun loginUser(@RequestBody login: UserLogin) =
        ResponseEntity.ok(userService.userLogin(login))

    @GetMapping("/isAuthenticated")
    fun check() = ResponseEntity
        .ok("Authenticated")
}