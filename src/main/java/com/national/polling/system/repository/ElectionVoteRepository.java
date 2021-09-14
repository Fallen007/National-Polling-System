package com.national.polling.system.repository;

import com.national.polling.system.entity.ElectionVote;
import com.national.polling.system.entity.ElectionVotePKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionVoteRepository extends JpaRepository<ElectionVote, ElectionVotePKey> {
}