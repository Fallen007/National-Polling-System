package com.national.polling.system.dto;

import lombok.Data;

@Data
public class VoterDTO {
    private Long voterId;

    private String name;

    private String gender;

    private Integer age;

    private String ethnicity;

    private String state;

    private String email;
}
