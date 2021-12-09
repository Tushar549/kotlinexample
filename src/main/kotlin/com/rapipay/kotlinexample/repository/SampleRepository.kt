package com.rapipay.kotlinexample.repository

import com.rapipay.kotlinexample.entity.SampleEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


interface SampleRepository : MongoRepository<SampleEntity,String>