package com.national.polling.system.mapper;

import com.national.polling.system.dto.VoterDTO;
import com.national.polling.system.entity.Voter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Voter voterDtoToVoter(VoterDTO voterDTO);

    VoterDTO voterToVoterDto(Voter voter);
}
