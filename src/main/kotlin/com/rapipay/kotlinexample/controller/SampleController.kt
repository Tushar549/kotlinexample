package com.rapipay.kotlinexample.controller

import com.rapipay.kotlinexample.entity.SampleEntity
import com.rapipay.kotlinexample.repository.SampleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SampleController(@Autowired val sampleRepository: SampleRepository) {



    @GetMapping("/hi")
    fun tryFn(@RequestParam("name") name:String): String{
        return try{
            println(sampleRepository.save(SampleEntity("Tushar")))
            "ok Done"
        }catch(exception:Exception){
            exception.localizedMessage
        }
    }

}