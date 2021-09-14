package com.national.polling.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "otp")
@Entity
@Getter
@Setter
@ToString
public class Otp {
    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "generated_otp", nullable = false)
    private String generatedOtp;

    @Column(name = "otp_expiration_time", nullable = false)
    private Instant otpExpirationTime;
}