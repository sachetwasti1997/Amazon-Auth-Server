package com.sachet.authserveramazon.model

import jakarta.persistence.*

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var addressId: Int ?= null,
    var line1: String ?= null,
    var line2: String ?= null,
    var postalCode: Int ?= null
)