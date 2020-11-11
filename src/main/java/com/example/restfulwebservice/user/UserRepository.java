package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DB 관련된 Bean 의미                    //       PK 타입
public interface UserRepository extends JpaRepository<User, Integer> {


}
