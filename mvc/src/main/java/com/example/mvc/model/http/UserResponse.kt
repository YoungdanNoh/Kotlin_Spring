package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse (
    var result:Result? = null,
    var decription:String? = null,

    @JsonProperty("user")
    var userRequest: MutableList<UserRequest>? = null
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
    var resultCode: String? = null,
    var resultMessage: String? = null
)

/*
{
    "result": {
        "result_code": "OK",
        "result_message": "성공"
    },
    description: "~~~"
    "user": [
        {
            "name": "yd",
            "age": 10,
            "email": "",
            "phoneNumber": ""
        },
        {
            "name": "yd",
            "age": 10,
            "email": "",
            "phoneNumber": ""
        }
    ]
}
이러한 JSON 처럼 카멜케이스와 스네이크케이스가 혼용되어 들어오는 경우는 어떻게 해야할까?
* */