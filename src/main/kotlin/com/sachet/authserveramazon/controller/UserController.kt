package com.sachet.authserveramazon.controller

import com.sachet.authserveramazon.model.Address
import com.sachet.authserveramazon.model.User
import com.sachet.authserveramazon.model.UserLogin
import com.sachet.authserveramazon.service.AddressService
import com.sachet.authserveramazon.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    var userService: UserService,
    var addressService: AddressService
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

    @PutMapping("/address/edit")
    fun editAddAddress(@RequestBody address: Address): ResponseEntity<Address> =
        ResponseEntity.ok(addressService.editAddress(address))

    @PostMapping("/address/add/{userId}")
    fun addAddress(@RequestBody address: Address, @PathVariable userId: Int) =
        ResponseEntity.ok(addressService.addAddress(address, userId))
}