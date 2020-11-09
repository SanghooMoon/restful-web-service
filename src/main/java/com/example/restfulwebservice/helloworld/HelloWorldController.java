package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // 반환되는 값은 자동으로 JSON 형식으로 변경됨
public class HelloWorldController {
    // GET
    // /hello-world (endPoint)
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // alt + enter
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");   // { "message" : "Hello World" } -> Json 형태로 반환
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){    // 이 매개변수는 가변인자로 사용하겠다.
//        return new HelloWorldBean("Hello World, " + name);
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
