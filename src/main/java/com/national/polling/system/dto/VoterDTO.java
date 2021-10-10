package com.national.polling.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VoterDTO {
    private Long voterId;

    private String name;

    private String gender;

    private Integer age;

    private String ethnicity;

    private String state;

    private String email;
}
