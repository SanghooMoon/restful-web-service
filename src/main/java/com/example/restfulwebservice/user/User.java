package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password", "ssn"})      // 일괄처리하여 데이터를 클라이언트에게 노출시키지 않는 어노테이션
public class User {

    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")    // 2글자 이상 사용해야함.
    private String name;
    @Past           // 현재보다 과거의 데이터만 사용할 수 있다는 제약조건
    private Date joinDate;

//    @JsonIgnore     // 하나의 데이터(필드)를 클라이언트에 노출 시키지않기 위한 어노테이션
    private String password;
    private String ssn;
}
