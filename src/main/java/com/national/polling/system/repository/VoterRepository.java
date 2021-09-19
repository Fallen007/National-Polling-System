package com.national.polling.system.repository;

import com.national.polling.system.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    @Query(value = "SELECT voter FROM Voter voter WHERE voter.email = ?1")
    Voter findByEmail(String email);
}