package com.sachet.authserveramazon.service

import com.sachet.authserveramazon.model.Address
import com.sachet.authserveramazon.repository.AddressRepo
import com.sachet.authserveramazon.repository.UserRepo
import org.springframework.stereotype.Service

@Service
class AddressService(
    var addressRepo: AddressRepo,
    var userRepo: UserRepo
) {

    fun editAddress(address: Address): Address {
        val savedAddress = address.addressId?.let { addressRepo.findById(it) }
        if (savedAddress?.isPresent == true) {
            address.user = savedAddress.get().user
            return addressRepo.save(address)
        }
        throw Exception("Address Not Found")
    }

    fun addAddress(address: Address, userId: Int): Address {
        val user = userRepo.findById(userId)
        address.user = user.get()
        return addressRepo.save(address)
    }

}