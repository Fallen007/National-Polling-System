package com.national.polling.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "election_candidates")
@Entity
@IdClass(ElectionCandidatePKey.class)
@Getter
@Setter
@ToString
public class ElectionCandidate {
    @Id
    @Column(name = "election_id")
    private Integer electionId;

    @Id
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "political_party")
    private String politicalParty;
}