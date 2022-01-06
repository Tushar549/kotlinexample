package com.rapipay.kotlinexample.controller

import com.rapipay.kotlinexample.entity.Authentication
import com.rapipay.kotlinexample.entity.SampleEntity
import com.rapipay.kotlinexample.repository.AuthenticationRepository
import com.rapipay.kotlinexample.repository.SampleRepository
import com.rapipay.kotlinexample.utils.Util
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class SampleController(@Autowired var authenticationRepository: AuthenticationRepository, @Autowired val sampleRepository: SampleRepository, @Autowired var util: Util) {



    @GetMapping("/hi")
    fun tryFn(@RequestParam("name") name:String, @RequestHeader("jwt") jwt : String): String{
        var arrayList : ArrayList<String> = jwt.split(".") as ArrayList<String>
        System.err.println(arrayList.get(0)+" "+arrayList.get(1)+" "+arrayList.get(2));

        return try{
            println(sampleRepository.save(SampleEntity("ABCCCCCCCC")))
//            println(arrayList.get(2)+"   "+util.encode("your-256-bit-secrett",arrayList.get(0)+"."+arrayList.get(1)))
            if(!util.validateJwt(jwt)){
                "invalid token"
            }
            "ok Done"
        }catch(exception:Exception){
            exception.localizedMessage
        }
    }

    @GetMapping("/createAuth")
    fun createAuth(): String{
        return try{
            authenticationRepository.save(Authentication("Tushar",true,"9999999999"))
            "Done"
        }catch(exception:Exception){
            exception.localizedMessage
        }
    }

}