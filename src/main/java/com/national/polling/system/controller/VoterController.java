package com.national.polling.system.controller;

import com.national.polling.system.dto.VoterDTO;
import com.national.polling.system.entity.Voter;
import com.national.polling.system.mapper.MapStructMapper;
import com.national.polling.system.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VoterController {
    VoterService voterService;
    MapStructMapper mapper;

    @Autowired
    public VoterController(VoterService voterService, MapStructMapper mapper) {
        this.voterService = voterService;
        this.mapper = mapper;
    }

    @PostMapping("/Voters")
    public ResponseEntity<VoterDTO> addVoterDetails(@RequestBody VoterDTO voterDTO) {
        Voter voter = mapper.voterDtoToVoter(voterDTO);
        voterDTO = mapper.voterToVoterDto(voterService.addVoter(voter));
        return ResponseEntity.ok(voterDTO);
    }

    @GetMapping("/Voters")
    public ResponseEntity<List<VoterDTO>> getVotersList() {
        return ResponseEntity.ok(
            voterService.getAllVoters()
                .stream()
                .map(voter -> mapper.voterToVoterDto(voter))
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/Voters/{voterId}")
    public ResponseEntity<VoterDTO> getVoterDetailsById(@PathVariable Long voterId) {
        return ResponseEntity.ok(
            voterService.getVoterById(voterId)
                .map(voter -> mapper.voterToVoterDto(voter))
                .orElse(new VoterDTO())
        );
    }

    @PutMapping("/Voters/{voterId}")
    public ResponseEntity<VoterDTO> updateVoterDetails(@PathVariable Long voterId, @RequestBody VoterDTO voterDTO) {
        voterDTO.setVoterId(voterId);
        Voter voter = mapper.voterDtoToVoter(voterDTO);
        voterDTO = mapper.voterToVoterDto(voterService.updateVoter(voter));
        return ResponseEntity.ok(voterDTO);
    }
}
