package com.national.polling.system.service;

import com.national.polling.system.entity.Voter;

import java.util.List;
import java.util.Optional;

public interface VoterService {
    Voter addVoter(Voter voter);

    Optional<Voter> getVoterById(Long voterId);

    List<Voter> getAllVoters();

    Voter updateVoter(Voter voter);
}
