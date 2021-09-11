package com.national.polling.system.repository;

import com.national.polling.system.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Integer> {
}