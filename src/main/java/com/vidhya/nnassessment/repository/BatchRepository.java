package com.vidhya.nnassessment.repository;

import com.vidhya.nnassessment.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

    public Batch getById(Integer id);

    public List<Batch> getByBatchProgramId(Integer batch_program_id);
}
