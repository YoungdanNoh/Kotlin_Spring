package com.example.mvc.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@Validated // 해당 어노테이션으로 파라미터에 유효성 검사를 적용할 수 있도록 활성화해준다.
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "20보다 커야 합니다.")
        @RequestParam age: Int?
    ): String {
        println(name)
        println(age)

        return name + " " + age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name")
        @Size(min=2, max=5, message = "name의 길이는 2~5 사이어야 합니다.")
        @NotNull
        _name: String, // aa~aaaaa


        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int?
    ): String {
        println(_name)
        println(_age)

        return _name + " " + _age
    }
}