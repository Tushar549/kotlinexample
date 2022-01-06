package com.rapipay.kotlinexample.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Auth")
class Authentication( @Field("name") var name : String, @Field("is_active") var isActive: Boolean, @Indexed(unique = true) @Field("phone_number") var phoneNumber: String){
    @Id
    var id : String? = null



}