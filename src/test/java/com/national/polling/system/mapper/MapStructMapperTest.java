package com.national.polling.system.mapper;

import com.national.polling.system.dto.VoterDTO;
import com.national.polling.system.entity.Voter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapStructMapperTest {
    @Autowired
    MapStructMapper mapper;

    @Test
    void voterDtoToVoterTest() {
        Voter voter = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        VoterDTO voterDTO = new VoterDTO(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        assertEquals(voter, mapper.voterDtoToVoter(voterDTO));
    }

    @Test
    void voterToVoterDtoTest() {
        Voter voter = new Voter(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        VoterDTO voterDTO = new VoterDTO(1231219L, "Tom Hardy", "Male", 32, "White", "California", "tom.hardy@gmail.com");
        assertEquals(voterDTO, mapper.voterToVoterDto(voter));
    }
}