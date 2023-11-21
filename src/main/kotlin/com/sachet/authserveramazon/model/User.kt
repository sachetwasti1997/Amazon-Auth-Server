package com.sachet.authserveramazon.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int ?= null,

    var firstName: String ?= null,
    var lastName: String ?= null,
    var email: String ?= null,
    var password: String ?= null,
    @JsonManagedReference
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "user")
    var address: List<Address>
)