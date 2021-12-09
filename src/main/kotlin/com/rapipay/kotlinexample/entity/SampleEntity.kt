package com.rapipay.kotlinexample.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Sample")
data class SampleEntity( @Field("firstName") var name : String){
    @Id var id : String? = null
}