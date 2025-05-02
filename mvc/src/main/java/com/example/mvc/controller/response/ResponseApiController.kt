package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4XX
    // GET http://localhost:8080/api/response
    @GetMapping("")
    fun getMapping(@RequestParam age : Int?) : ResponseEntity<String> {
        // 코틀린에서는 Int?로 age가 오지 않을 수도 있다는 것을 표현할 수 있다.

        return age?.let {
            // age not null
            if(it < 20){
                return ResponseEntity.status(400).body("age는 20보다 커야함")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            // age is null
            return ResponseEntity.status(400).body("age 값이 누락")
        }

        /*
        // 1. age == null -> 400 error
        if(age == null){
            return ResponseEntity.status(400).body("age 값이 누락")
        }

        // 2. age > 20 -> 400 error
        if(age < 20){
            return ResponseEntity.status(400).body("age는 20보다 커야함")
        }

        return ResponseEntity.ok("OK")
        */
        
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?) : ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest) // object mapper -> object -> json
    }

    // 3. put 201
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?) : ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@RequestParam id: Int) : ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}