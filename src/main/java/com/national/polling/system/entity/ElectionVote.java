package com.national.polling.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "election_votes")
@Entity
@IdClass(ElectionVotePKey.class)
@Getter
@Setter
@ToString
public class ElectionVote {
    @Id
    @Column(name = "election_id", nullable = false)
    private Integer electionId;

    @Column(name = "candidate_id", nullable = false)
    private Long candidateId;

    @Id
    @Column(name = "voter_id", nullable = false)
    private Long voterId;
}