package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        println(name)
        println(age)

        return name + " " + age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name") _name: String,
        @PathVariable(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)

        return _name + " " + _age
    }
}