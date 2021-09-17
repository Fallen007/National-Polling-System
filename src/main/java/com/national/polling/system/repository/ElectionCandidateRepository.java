package com.national.polling.system.repository;

import com.national.polling.system.entity.ElectionCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionCandidateRepository extends JpaRepository<ElectionCandidate, Long> {
}