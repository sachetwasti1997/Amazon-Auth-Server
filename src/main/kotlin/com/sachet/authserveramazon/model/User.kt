package com.sachet.authserveramazon.model

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
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    var address: Address
)