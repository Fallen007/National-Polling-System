package com.national.polling.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "voters")
@Entity
@Getter
@Setter
@ToString
public class Voter {
    @Id
    @Column(name = "voter_id", nullable = false)
    private Long voterId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "ethnicity", nullable = false)
    private String ethnicity;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "email", nullable = false)
    private String email;
}