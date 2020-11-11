package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})      // 일괄처리하여 데이터를 클라이언트에게 노출시키지 않는 어노테이션
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체") // API 문서에 설명을 추가
@Entity     // 해당하는 클래스를 가지고 DB에 테이블을 만듬
public class User {

    @Id                 // PK 의미
    @GeneratedValue     // PK 값을 위한 자동 생성 전략을 명시하는데 사용
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")    // 2글자 이상 사용해야함.
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;
    @Past           // 현재보다 과거의 데이터만 사용할 수 있다는 제약조건
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;

//    @JsonIgnore     // 하나의 데이터(필드)를 클라이언트에 노출 시키지않기 위한 어노테이션

    @ApiModelProperty(notes = "사용자 패스워드를 입력해 주세요.")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요.")
    private String ssn;
}
