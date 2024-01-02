package com.vidhya.nnassessment.service;

import com.vidhya.nnassessment.dto.BatchDTO;
import com.vidhya.nnassessment.entity.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchService {

    public void saveBatch(BatchDTO batchDTO) throws Exception;

    public Optional<Batch> getBatchById(Integer id);

    public List<Batch> getAllBatches();

    public void deleteBatchById(Integer id);

    public Batch getById(Integer id);

    public List<Batch> getBatchesByProgramId(Integer id);
}
