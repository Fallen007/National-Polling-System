package com.national.polling.system.repository;

import com.national.polling.system.entity.ElectionCandidate;
import com.national.polling.system.entity.ElectionCandidatePKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionCandidateRepository extends JpaRepository<ElectionCandidate, ElectionCandidatePKey> {
}