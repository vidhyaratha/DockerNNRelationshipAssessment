package com.vidhya.nnassessment.service;

import com.vidhya.nnassessment.dto.ProgramDTO;
import com.vidhya.nnassessment.entity.Program;
import com.vidhya.nnassessment.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService{


    @Autowired
    private ProgramRepository programRepository;


    @Override
    public Optional<Program> getProgramById(Integer id) {
        return programRepository.findById(id) ;
    }



    @Override
    public Program getById(Integer id) {
        return programRepository.getById(id);
    }



    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }



    @Override
    public void saveProgram(ProgramDTO programDTO) {
            Program program = new Program();
            program.setProgramId(programDTO.getProgramId());
            program.setProgramName(programDTO.getProgramName());
            program.setProgramDescription(programDTO.getProgramDescription());
            program.setProgramStatus(programDTO.getProgramStatus());
            program.setCreationTime(programDTO.getCreationTime());
            program.setLastModTime(programDTO.getLastModTime());
            programRepository.save(program);
    }



    @Override
    public void deleteProgramById(Integer id) {
        programRepository.deleteById(id);
    }
}
