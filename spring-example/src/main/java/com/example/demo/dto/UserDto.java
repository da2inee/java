package com.example.demo.dto;

/**
 * POST /users 요청 본문(JSON) 바인딩용 DTO.
 * - 스프링이 JSON {"name":"김철수","age":25} 를 이 객체로 변환해 줌 (getter/setter 필요)
 * 예: {"name":"김철수","age":25}
 */
public class UserDto {

    /** 이름 (JSON 키 "name"과 매핑) */
    private String name;
    /** 나이 (JSON 키 "age"와 매핑) */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
