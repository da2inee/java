package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import org.springframework.web.bind.annotation.*;

/**
 * REST API 예시 - GET/POST, @RequestParam, @PathVariable, @RequestBody
 *
 * 실행 후 확인:
 *   GET  http://localhost:8080/hello
 *   GET  http://localhost:8080/hello/Spring
 *   GET  http://localhost:8080/greet?name=김철수
 *   POST http://localhost:8080/users  (Body: {"name":"김","age":25})
 */
@RestController  // 이 클래스는 REST 컨트롤러. 메서드 반환값이 HTTP 응답 본문으로 전달됨 (JSON 등)
public class HelloController {

    /** GET /hello 요청 시 "Hello, Spring!" 문자열 반환 (응답 본문) */
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    /** GET /hello/{name} 요청 시 URL 경로의 name 값을 받아서 "Hello, {name}" 반환 */
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {  // @PathVariable: URL 경로 안의 {name} 값을 매개변수로
        return "Hello, " + name;
    }

    /** GET /greet?name=값 요청 시 쿼리 스트링 name 값을 받아서 "Hi, {name}" 반환. name 없으면 "Guest" */
    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Guest") String name) {  // @RequestParam: ?name=값
        return "Hi, " + name;
    }

    /** POST /users 요청 시 요청 본문(JSON)을 UserDto로 바인딩해서 받고, 그대로 반환 */
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto dto) {  // @RequestBody: JSON 본문 → DTO 객체
        return dto;
    }
}
