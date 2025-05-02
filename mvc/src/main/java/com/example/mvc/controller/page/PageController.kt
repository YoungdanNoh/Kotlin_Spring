package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
// 해당 어노테이션은 static 폴더 안에 있는 html 파일을 찾아 해당 페이지로 보내준다.
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    // 만일 RestController의 기능과 섞고 싶다면?
    // @ResponseBody를 사용
    @ResponseBody
    @GetMapping("/test")
    fun response(): String {
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test2")
    fun response2(): UserRequest {
        return UserRequest().apply {
            this.name = "NYD"
        }
    }
}