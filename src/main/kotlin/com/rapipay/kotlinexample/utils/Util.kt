package com.rapipay.kotlinexample.utils

import com.rapipay.kotlinexample.repository.AuthenticationRepository
import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.binary.Hex
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.collections.ArrayList

@Component
class Util(@Autowired var authenticationRepository: AuthenticationRepository) {



    fun validateJwt(jwt : String) : Boolean{

        var arrayList : ArrayList<String> = jwt.split(".") as ArrayList<String>
        System.err.println(arrayList.get(0)+" "+arrayList.get(1)+" "+arrayList.get(2));
        System.err.println("Header : " + String(Base64.decodeBase64(arrayList.get(0))))
        System.err.println("Body : " + String(Base64.decodeBase64(arrayList.get(1))))
        if(encode("your-256-bit-secrett",arrayList.get(0)+"."+arrayList.get(1)).equals(arrayList.get(2))){
            var auth = authenticationRepository.findByPhoneNumberAndIsActive("9999999999",true);
            if(Objects.nonNull(auth))
                return true;
        }

        return false;

    }


    fun encode(key: String, data: String): String? {

        val sha256_HMAC = Mac.getInstance("HmacSHA256")
        val secret_key = SecretKeySpec(key.toByteArray(charset("UTF-8")), "HmacSHA256")
        sha256_HMAC.init(secret_key)
        return Base64.encodeBase64String(sha256_HMAC.doFinal(data.toByteArray(charset("UTF-8"))))
    }

}