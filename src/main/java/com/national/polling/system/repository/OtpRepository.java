package com.national.polling.system.repository;

import com.national.polling.system.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, String> {
}