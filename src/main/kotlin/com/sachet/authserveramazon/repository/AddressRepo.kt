package com.sachet.authserveramazon.repository

import com.sachet.authserveramazon.model.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepo: CrudRepository<Address, Int> {
}