package com.national.polling.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "election_candidates")
@Entity
@Getter
@Setter
@ToString
public class ElectionCandidate {
    @Column(name = "election_id")
    private Integer electionId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "candidate_voter_id")
    private Long candidateVoterId;

    @Column(name = "political_party")
    private String politicalParty;
}