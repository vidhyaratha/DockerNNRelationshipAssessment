package com.vidhya.nnassessment.repository;

import com.vidhya.nnassessment.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,Integer> {

    public Program getById(Integer id);
}
