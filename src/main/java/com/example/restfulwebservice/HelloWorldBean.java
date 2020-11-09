package com.example.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok 세팅
// settings - annotation Processors -> Enable Anotation processiong 체크
// settings - plugin - lombok install

@Data               // getter, setter, eqauls, hashcode, toString 자동 생성
@AllArgsConstructor // 모든 인자를 통해 생성자를 만든다
@NoArgsConstructor  // 기본 생성자
public class HelloWorldBean {
    private String message;

    // 롬복 @Data로 선언했기때문에 필요 X
//    public String getMessage() {
//        return message;
//    }
//    public void setMessage(String message) {
//        this.message = message;
//    }

    // @AllArgsConstructor로 인해 직접 생성 X, 동시에 생성자를 만들경우 중복메서드이기 때문에 컴파일 에러
//    public HelloWorldBean(String message) {
//        this.message = message;
//    }
}
