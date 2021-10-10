package com.national.polling.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "voters")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voter)) return false;
        Voter voter = (Voter) o;
        return getVoterId().equals(voter.getVoterId()) && getName().equals(voter.getName()) && getGender().equals(voter.getGender()) && getAge().equals(voter.getAge()) && getEthnicity().equals(voter.getEthnicity()) && getState().equals(voter.getState()) && getEmail().equals(voter.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoterId(), getName(), getGender(), getAge(), getEthnicity(), getState(), getEmail());
    }
}