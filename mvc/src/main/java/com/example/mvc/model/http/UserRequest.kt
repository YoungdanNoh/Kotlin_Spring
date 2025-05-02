package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) // 해당 클래스는 snake 케이스로 동작할거야.
data class UserRequest (

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 < 숫자를 검증 0도 포함(양수)
    var age: Int? = null,

    @field:Email // email 양식
    var email: String? = null,
    
    @field:NotBlank // 공백을 검증
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

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
    var phoneNumber: String? = null,

    // 이건 어노테이션으로 딱히 표현할 방법이 없다.
    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss
){
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 이어야 함")
    private fun isValidCreatedAt() : Boolean {
        // 정상 true, 비정상 false
        return try{
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e: Exception){
            false
        }
    }
}