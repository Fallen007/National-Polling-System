package com.national.polling.system.controller;

import com.national.polling.system.dto.VoterDTO;
import com.national.polling.system.entity.Voter;
import com.national.polling.system.mapper.MapStructMapper;
import com.national.polling.system.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<VoterDTO> addVoterDetails(@RequestBody VoterDTO voterDTO){
        Voter voter = mapper.voterDtoToVoter(voterDTO);
        voter = voterService.addVoter(voter);
        voterDTO = mapper.voterToVoterDto(voter);
        return ResponseEntity.ok(voterDTO);
    }

    @GetMapping("/Voters")
    public ResponseEntity<List<VoterDTO>> getVotersList(){
        List<VoterDTO> votersList = new ArrayList<>();
        voterService.getAllVoters().forEach(voter -> votersList.add(mapper.voterToVoterDto(voter)));
        return ResponseEntity.ok(votersList);
    }

    @GetMapping("/Voters/{voterId}")
    public ResponseEntity<VoterDTO> getVoterDetailsById(@PathVariable Long voterId){
        Optional<Voter> voter = voterService.getVoterById(voterId);
        VoterDTO voterDTO = new VoterDTO();
        if(voter.isPresent())
            voterDTO = mapper.voterToVoterDto(voter.get());
        return ResponseEntity.ok(voterDTO);
    }

    @PutMapping("/Voters/{voterId}")
    public ResponseEntity<VoterDTO> updateVoterDetails(@PathVariable Long voterId,@RequestBody VoterDTO voterDTO){
        voterDTO.setVoterId(voterId);
        Voter voter = mapper.voterDtoToVoter(voterDTO);
        voter = voterService.updateVoter(voter);
        voterDTO = mapper.voterToVoterDto(voter);
        return ResponseEntity.ok(voterDTO);
    }
}
