package com.rapipay.kotlinexample.repository

import com.rapipay.kotlinexample.entity.Authentication
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthenticationRepository : MongoRepository<Authentication, String> {

    fun findByPhoneNumberAndIsActive(phoneNumber: String, isActive : Boolean) : Authentication

}