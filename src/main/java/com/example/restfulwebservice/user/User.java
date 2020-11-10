package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")    // 2글자 이상 사용해야함.
    private String name;
    @Past           // 현재보다 과거의 데이터만 사용할 수 있다는 제약조건
    private Date joinDate;
}
