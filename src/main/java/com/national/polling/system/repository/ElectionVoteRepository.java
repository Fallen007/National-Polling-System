package com.national.polling.system.repository;

import com.national.polling.system.entity.ElectionVote;
import com.national.polling.system.entity.ElectionVotePKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionVoteRepository extends JpaRepository<ElectionVote, ElectionVotePKey> {
}