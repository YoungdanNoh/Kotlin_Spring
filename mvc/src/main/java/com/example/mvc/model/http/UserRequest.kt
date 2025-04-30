package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) // 해당 클래스는 snake 케이스로 동작할거야.
data class UserRequest (
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,

    //var phoneNumber: String? = null
        // but, 대부분의 REST API의 JSON 형태는 snake 케이스가 많다.
        // 따라서 phone_number로 body에 데이터가 들어오기 때문에 매칭이 안 된다.
        // 그러므로 아래와 같이 수정

    //@JsonProperty("phone_number")
    //var phoneNumber: String? = null

    /*
    * 하지만 이처럼 하나의 프로퍼티마다 네이밍을 해준다면 body 데이터가 많아질 경우 매우 힘들것이다.
    * 따라서 class 위에 어노테이션을 달아준다.
    * @JsonNaming을 달아주면 @JsonProperty 없이 매핑이 가능해진다.
    * */

    var phoneNumber: String? = null,
)