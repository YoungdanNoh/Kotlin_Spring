package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController // Rest API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    // "/hello"와 "hello"는 동일하게 동작한다.
    // 하지만 url 끝에는 /를 붙이면 안 되므로, "hello/"는 안 된다.

    @GetMapping(path = ["/hello", "/abcd"]) // GET http://localhost:8080/api/hello, GET http://localhost:8080/api/abcd
    fun hello(): String { // return 타입이 String임을 명시
        return "hello kotlin"
    }

    //@RequestMapping("request-mapping") // http 메서드의 제한 없이 get, post, patch 등..이 모두 동작하도록 하는 방식
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve/20
    fun pathVariables(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve/20
    fun pathVariables2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {
        val name = "kotlin"

        println("${_name}, ${age}")
        return _name + " " + age
    }

    // 쿼리 파라미터
    // http://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param") // ?name=steve&age=20
    fun gueryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    // 객체로 쿼리 파라미터 받기
    // name, age, address, email
    /* url에는 대문자를 쓰지 않는 것이 좋다고 했다.
    * 따라서 phonenumber 또는 phone-number로 작성하는 것이 좋다.
    * 하지만 코틀린에서는 변수에 하이픈을 쓸 수 없기 때문에 object로 받는 경우 phone-number로 받는 것은 불가능하다.
    * 따라서 이와 같은 경우는 위 함수와 같이 @RequestParam(name = "phone-number")로 받아야 한다.
    * */
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // 이렇게 map으로 받을 때는 phone-number로도 받을 수 있다.
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }
}