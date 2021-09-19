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
public class VoterServiceImpl implements VoterService{
    VoterRepository voterRepository;

    @Autowired
    public VoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public Voter addVoter(Voter voter) {
        String email = voter.getEmail();
        //checking if given email already exits in the records
        if(checkIfEmailAlreadyExists(email).equals(true)) {
            String message = "The Email: %s already exists, thus can not be used again";
            message = String.format(message, voter.getEmail());
            throw new ConflictWithExistingRecordException(message);
        }
        return voterRepository.save(voter);
    }

    @Override
    public Optional<Voter> getVoterById(Long voterId) {
        //checking if voter with given voterId already exists or not
        if(checkIfVoterIdAlreadyExists(voterId).equals(false)) {
            String message = "Voter with VoterId: %s does not exist";
            message = String.format(message, voterId);
            throw new ResourceNotFoundException(message);
        }
        return voterRepository.findById(voterId);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public Voter updateVoter(Voter voter) {
        Long voterId = voter.getVoterId();
        String email = voter.getEmail();
        //checking if voter with given voterId already exists or not
        if(checkIfVoterIdAlreadyExists(voterId).equals(false)) {
            String message = "Voter with VoterId: %s does not exist";
            message = String.format(message, voterId);
            throw new ResourceNotFoundException(message);
        }
        Optional<Voter> existingVoterRecord = getVoterById(voterId);
        //checking if voter with given voterId exits and the provided email is the existing mail of voter or not
        //there's no need to check for email conflict if it's the voters existing mail
        if(existingVoterRecord.isPresent() && existingVoterRecord.get().getEmail().equals(email))
            voter = voterRepository.save(voter);
        //checking for email conflict
        else if(checkIfEmailAlreadyExists(email).equals(true)){
            String message = "The Email: %s already exists, thus can not be used again";
            message = String.format(message, voter.getEmail());
            throw new ConflictWithExistingRecordException(message);
        }
        return voter;
    }

    public Boolean checkIfVoterIdAlreadyExists(Long voterId) {
        return voterRepository.findById(voterId).isPresent();
    }

    public Boolean checkIfEmailAlreadyExists(String email) {
        return voterRepository.findByEmail(email) != null;
    }
}
