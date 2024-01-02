package com.vidhya.nnassessment.controller;

import com.vidhya.nnassessment.dto.BatchDTO;
import com.vidhya.nnassessment.dto.BatchProgramDTO;
import com.vidhya.nnassessment.dto.ProgramBatchDTO;
import com.vidhya.nnassessment.entity.Batch;
import com.vidhya.nnassessment.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BatchController {

    @Autowired
    private BatchService batchService;



    @GetMapping("/getBatch/{id}")
    public ResponseEntity<?> getBatchById(@PathVariable Integer id)
    {
        if(batchService.getBatchById(id).isPresent())
        {
            Batch batch = batchService.getById(id);

            BatchProgramDTO batchProgramDTO = new BatchProgramDTO(batch.getBatchId(),batch.getBatchName(),batch.getBatchDescription(),
                    batch.getBatchStatus(),batch.getBatchProgramId(),batch.getBatchNoOfClasses(),batch.getCreationTime(),
                    batch.getLastModTime(),batch.getProgram().getProgramId());

            return new ResponseEntity<>(batchProgramDTO,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found", HttpStatus.NOT_FOUND);
        }
    }





    @GetMapping("/getAllBatches")
    public ResponseEntity<?> getAllBatches()
    {
        List<Batch> batchList = batchService.getAllBatches();
        return new ResponseEntity<>(batchList,HttpStatus.OK);
    }




    @PostMapping("/addBatch")
    public ResponseEntity<?> addBatch(@RequestBody BatchDTO batchDTO) throws Exception {
        if(batchService.getBatchById(batchDTO.getBatchId()).isEmpty())
        {
            batchService.saveBatch(batchDTO);
            Batch batch = batchService.getById(batchDTO.getBatchId());
            BatchProgramDTO batchDto = new BatchProgramDTO(batch.getBatchId(),batch.getBatchName(),batch.getBatchDescription(),
                    batch.getBatchStatus(),batch.getBatchProgramId(),batch.getBatchNoOfClasses(),batch.getCreationTime(),
                    batch.getLastModTime(),batch.getProgram().getProgramId());

            return new ResponseEntity<>(batchDto, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("Message : Id already exists", HttpStatus.BAD_REQUEST);
        }
    }




    @PostMapping("/addBatches")
    public ResponseEntity<?> addBatches(@RequestBody List<BatchDTO> batchDTOList) throws Exception {
        String str = "";
        for(BatchDTO batchDTO : batchDTOList)
        {
            if(batchService.getBatchById(batchDTO.getBatchId()).isEmpty()) {
                batchService.saveBatch(batchDTO);
                str = "Added Successfully";
            }
            else
            {
                str = "ID/ID's already exists";
            }
        }
        return new ResponseEntity<>(str,HttpStatus.OK);
    }





    @PutMapping("/updateBatch/{id}")
    public ResponseEntity<?> updateBatchById(@RequestBody BatchDTO batchDTO, @PathVariable Integer id) throws Exception {
        //if(batchService.getBatchById(id).isPresent())
        if(batchService.getBatchById(id).isPresent() && batchDTO.getBatchId().equals(id))
        {
            batchService.saveBatch(batchDTO);
            Batch batch = batchService.getById(id);
            BatchProgramDTO updatedBatch = new BatchProgramDTO(batch.getBatchId(),batch.getBatchName(),batch.getBatchDescription(),
                    batch.getBatchStatus(),batch.getBatchProgramId(),batch.getBatchNoOfClasses(),batch.getCreationTime(),
                    batch.getLastModTime(),batch.getProgram().getProgramId());

            return new ResponseEntity<>(updatedBatch,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found / Id Mismatch with the Request body and url ",HttpStatus.NOT_FOUND);
        }
    }





    @DeleteMapping("/deleteBatch/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id)
    {
        if(batchService.getBatchById(id).isPresent())
        {
            batchService.deleteBatchById(id);
            return new ResponseEntity<>("Message : Deleted successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found",HttpStatus.NOT_FOUND);
        }
    }



}
