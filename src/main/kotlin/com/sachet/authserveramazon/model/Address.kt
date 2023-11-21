package com.sachet.authserveramazon.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var addressId: Int ?= null,
    var line1: String ?= null,
    var line2: String ?= null,
    var postalCode: Int ?= null,
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User ?= null
)