package com.lsy.wordcheck.utils

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import java.text.SimpleDateFormat

class JsonUtils {

    private var objectMapper : ObjectMapper? = null

    private constructor(){
        objectMapper = configureObjectMapperInstance()
    }

    private fun configureObjectMapperInstance(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false)
        objectMapper.setDateFormat(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"))
        return objectMapper
    }

    private fun toJsonString(any: Any):String{

        return objectMapper!!.writeValueAsString(any)
    }

   companion object {

       private var instance: JsonUtils? =null

       @JvmStatic
       private fun getInstance():JsonUtils{
           if (instance==null){
               instance = JsonUtils();
           }
           return instance as JsonUtils
       }

       @JvmStatic
       public fun toString(any:Any):String {

           return getInstance().toJsonString(any);
       }
   }

}