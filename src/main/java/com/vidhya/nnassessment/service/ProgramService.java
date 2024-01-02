package com.vidhya.nnassessment.service;


import com.vidhya.nnassessment.dto.ProgramDTO;
import com.vidhya.nnassessment.entity.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {

    public void saveProgram(ProgramDTO programDTO);

    public Optional<Program> getProgramById(Integer id);

    public List<Program> getAllPrograms();

    public void deleteProgramById(Integer id);

    public Program getById(Integer id);

}
