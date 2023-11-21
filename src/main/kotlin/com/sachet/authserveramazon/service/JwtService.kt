package com.sachet.authserveramazon.service

import com.sachet.authserveramazon.model.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Date

@Service
class JwtService {

    @Value("\${secure-key}")
    var SECURE_KEY: String? = null

    fun generateToken(user: User): String {
        val claims = HashMap<String, Any>()
        return createToken(claims, user)
    }

    private fun createToken(claims: HashMap<String, Any>, user: User): String {
        val keys = Keys.hmacShaKeyFor(SECURE_KEY?.toByteArray())
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(user.email)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000))
            .signWith(keys).compact()
    }

}