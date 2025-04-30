package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    /* JSON <-> Object 시 object mapper를 사용
    * object mapper가 하는 일:
    * json -> object
    * object -> json
    * */
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        // 들어올 때는 json -> object
        println(userRequest)
        return userRequest // 나갈 때는 object -> json
    }

}