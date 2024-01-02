package com.vidhya.nnassessment.service;

import com.vidhya.nnassessment.dto.BatchDTO;
import com.vidhya.nnassessment.entity.Batch;
import com.vidhya.nnassessment.entity.Program;
import com.vidhya.nnassessment.repository.BatchRepository;
import com.vidhya.nnassessment.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private ProgramRepository programRepository;


    @Override
    public Optional<Batch> getBatchById(Integer id) {
        return batchRepository.findById(id);
    }



    @Override
    public Batch getById(Integer id) {
        return batchRepository.getById(id);
    }



    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }


    @Override
    public void saveBatch(BatchDTO batchDTO) throws Exception {
        Batch batch = new Batch();
        batch.setBatchId(batchDTO.getBatchId());
        batch.setBatchName(batchDTO.getBatchName());
        batch.setBatchDescription(batchDTO.getBatchDescription());
        batch.setBatchStatus(batchDTO.getBatchStatus());
        batch.setBatchProgramId(batchDTO.getBatchProgramId());
        batch.setBatchNoOfClasses(batchDTO.getBatchNoOfClasses());
        batch.setCreationTime(batchDTO.getCreationTime());
        batch.setLastModTime(batchDTO.getLastModTime());

        Program program = programRepository.getById(batchDTO.getBatchProgramId());
        try {
            if (program != null) {
            batch.setProgram(program);
            batchRepository.save(batch);
        }}
        catch(Exception ex)
        {
            throw new Exception("Program ID " + batchDTO.getBatchProgramId()  +  " does not exist. " +
                    "Please try registering with the right program ID.");
        }
    }



    @Override
    public void deleteBatchById(Integer id) {
        batchRepository.deleteById(id);
    }




    @Override
    public List<Batch> getBatchesByProgramId(Integer id)
    {
        List<Batch> batchList = batchRepository.getByBatchProgramId(id);
        return batchList;
    }


    }
