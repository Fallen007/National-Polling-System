package com.national.polling.system.service;

import com.national.polling.system.entity.Voter;

import java.util.List;

public interface VoterService {
    Voter addVoter(Voter voter);

    Voter getVoterById(Long voterId);

    List<Voter> getAllVoters();

    Voter updateVoter(Voter voter);
}
