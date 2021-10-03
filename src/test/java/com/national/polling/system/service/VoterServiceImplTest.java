package com.national.polling.system.service;

import com.national.polling.system.entity.Voter;
import com.national.polling.system.exception.ConflictWithExistingRecordException;
import com.national.polling.system.exception.ResourceNotFoundException;
import com.national.polling.system.repository.VoterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VoterServiceImplTest {
    @Mock
    VoterRepository voterRepository;

    @InjectMocks
    VoterServiceImpl voterService;

    @Test
    void addVoterPassingTest() {
        Voter voter = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        when(voterRepository.findByEmail(voter.getEmail())).thenReturn(null);
        when(voterRepository.save(any(Voter.class))).thenReturn(voter);
        assertEquals(voter, voterService.addVoter(voter));
    }

    @Test()
    void addVoterUniqueEmailFailTest() {
        Voter voter = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        when(voterRepository.findByEmail(voter.getEmail())).thenReturn(voter);
        assertThatThrownBy(() -> voterService.addVoter(voter)).isInstanceOf(ConflictWithExistingRecordException.class);
    }

    @Test
    void getVoterByIdPassingTest() {
        Voter voter = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        Optional<Voter> voterRecord = Optional.of(voter);
        when(voterRepository.findById(voter.getVoterId())).thenReturn(voterRecord);
        assertEquals(voter, voterService.getVoterById(voter.getVoterId()));
    }

    @Test
    void getVoterByIdInvalidVoterIdTest() {
        Optional<Voter> voterRecord = Optional.empty();
        when(voterRepository.findById(1253239L)).thenReturn(voterRecord);
        assertThatThrownBy(() -> voterService.getVoterById(1253239L)).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void getAllVotersTest() {
        when(voterRepository.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(voterService.getAllVoters());
    }

    @Test
    void updateVoterPassingTest() {
        Voter existingVoterDetails = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        Voter updatedVoterDetails = new Voter(1231219L, "Tom Richardson", "Male", 32, "Black", "Arizona", "tom.richardson@gmail.com");
        Optional<Voter> existingVoterRecord = Optional.of(existingVoterDetails);
        when(voterRepository.findById(updatedVoterDetails.getVoterId())).thenReturn(existingVoterRecord);
        when(voterRepository.findByEmail(updatedVoterDetails.getEmail())).thenReturn(null);
        when(voterRepository.save(updatedVoterDetails)).thenReturn(updatedVoterDetails);
        assertEquals(updatedVoterDetails, voterService.updateVoter(updatedVoterDetails));
    }

    @Test
    void updateVoterInvalidVoterIdTest() {
        Voter updatedVoterDetails = new Voter(1231219L, "Tom Richardson", "Male", 32, "Black", "Arizona", "tom.richardson@gmail.com");
        Optional<Voter> existingVoterRecord = Optional.empty();
        when(voterRepository.findById(updatedVoterDetails.getVoterId())).thenReturn(existingVoterRecord);
        assertThatThrownBy(() -> voterService.updateVoter(updatedVoterDetails)).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void updateVoterUniqueEmailFailTest() {
        Voter existingVoterDetails = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        Voter updatedVoterDetails = new Voter(1231219L, "Tom Richardson", "Male", 32, "Black", "Arizona", "invalid.email@gmail.com");
        Voter conflictingEmailRecord = new Voter(1754291L, "Morgan Freeman", "Male", 41, "Black", "South Dakota", "invalid.email@gmail.com");
        Optional<Voter> existingVoterRecord = Optional.of(existingVoterDetails);
        when(voterRepository.findById(updatedVoterDetails.getVoterId())).thenReturn(existingVoterRecord);
        when(voterRepository.findByEmail(updatedVoterDetails.getEmail())).thenReturn(conflictingEmailRecord);
        assertThatThrownBy(() -> voterService.updateVoter(updatedVoterDetails)).isInstanceOf(ConflictWithExistingRecordException.class);
    }
}