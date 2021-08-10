package com.example.userservice.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUser {

    private String email;
    private String name;
    private String userId;
    // 사용자 정보를 요청했을 때, 그 사용자의 유저 정보 뿐만 아니라 사용자가 가진 주문 정보도 함께 반환할 것이다.
    private List<ResponseOrder> orders;
}
