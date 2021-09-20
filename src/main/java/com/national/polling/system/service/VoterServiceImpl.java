package com.national.polling.system.service;

import com.national.polling.system.entity.Voter;
import com.national.polling.system.exception.ConflictWithExistingRecordException;
import com.national.polling.system.exception.ResourceNotFoundException;
import com.national.polling.system.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService {
    VoterRepository voterRepository;

    @Autowired
    public VoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public Voter addVoter(Voter voter) {
        String email = voter.getEmail();
        if (voterRepository.findByEmail(email) != null) {
            throw new ConflictWithExistingRecordException("The Email: " + email + " already exists, thus can not be used again");
        }
        return voterRepository.save(voter);
    }

    @Override
    public Optional<Voter> getVoterById(Long voterId) {
        Optional<Voter> voterRecord = voterRepository.findById(voterId);
        if (voterRecord.isEmpty()) {
            throw new ResourceNotFoundException("Voter with VoterId: " + voterId + " does not exist");
        }
        return voterRecord;
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public Voter updateVoter(Voter voter) {
        Long voterId = voter.getVoterId();
        String email = voter.getEmail();
        Optional<Voter> existingVoterRecord = getVoterById(voterId);
        if (existingVoterRecord.isEmpty()) {
            throw new ResourceNotFoundException("Voter with VoterId: " + voterId + " does not exist");
        }
        //checking if the provided email is the existing email of voter and if the email already exists in the records
        if (!existingVoterRecord.get().getEmail().equals(email) && voterRepository.findByEmail(email) != null) {
            throw new ConflictWithExistingRecordException("The Email: " + email + " already exists, thus can not be used again");
        }
        voter = voterRepository.save(voter);
        return voter;
    }
}
