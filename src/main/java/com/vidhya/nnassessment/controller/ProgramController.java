package com.vidhya.nnassessment.controller;


import com.vidhya.nnassessment.dto.ProgramBatchDTO;
import com.vidhya.nnassessment.dto.ProgramDTO;
import com.vidhya.nnassessment.entity.Batch;
import com.vidhya.nnassessment.entity.Program;
import com.vidhya.nnassessment.service.BatchService;
import com.vidhya.nnassessment.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private BatchService batchService;


    @GetMapping("/getProgram/{id}")
    public ResponseEntity<?> getProgramById(@PathVariable Integer id)
    {
        if(programService.getProgramById(id).isPresent())
        {
            Program program = programService.getById(id);
            ProgramDTO programDTO = new ProgramDTO(program.getProgramId(),program.getProgramName(),program.getProgramDescription(),
                    program.getProgramStatus(),program.getCreationTime(),program.getLastModTime());
            return new ResponseEntity<>(programDTO, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found", HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/getAllPrograms")
    public ResponseEntity<?> getAllPrograms()
    {
        List<Program> programList =programService.getAllPrograms();
        return new ResponseEntity<>(programList,HttpStatus.OK);
    }



    @PostMapping("/addProgram")
    public ResponseEntity<?> addProgram(@RequestBody ProgramDTO programDTO)
    {
        if(programService.getProgramById(programDTO.getProgramId()).isEmpty())
        {
            programService.saveProgram(programDTO);

            Program program = programService.getById(programDTO.getProgramId());
            ProgramDTO programDto = new ProgramDTO(program.getProgramId(),program.getProgramName(),program.getProgramDescription(),
                    program.getProgramStatus(),program.getCreationTime(),program.getLastModTime());

            return new ResponseEntity<>(programDto,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("Message : Id already exists", HttpStatus.BAD_REQUEST);
        }
    }




    @PostMapping("/addPrograms")
    public ResponseEntity<?> addPrograms(@RequestBody List<ProgramDTO> programDTOList)
    {
        String str = "";
        for(ProgramDTO programDTO : programDTOList)
        {
            if(programService.getProgramById(programDTO.getProgramId()).isEmpty()) {
                programService.saveProgram(programDTO);
                str = "Added successfully";
            }
            else
            {
                str = "ID/ID's already exists ";
            }
        }
        return new ResponseEntity<>(str,HttpStatus.OK);
    }




    @PutMapping("/updateProgram/{id}")
    public ResponseEntity<?> updateProgramById(@RequestBody ProgramDTO programDTO, @PathVariable Integer id)
    {
        if(programService.getProgramById(id).isPresent() && programDTO.getProgramId().equals(id))
        {
            programService.saveProgram(programDTO);

            Program program = programService.getById(programDTO.getProgramId());
            ProgramDTO programDto = new ProgramDTO(program.getProgramId(),program.getProgramName(),program.getProgramDescription(),
                    program.getProgramStatus(),program.getCreationTime(),program.getLastModTime());

            return new ResponseEntity<>(programDto, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found / Id Mismatch with the Request body and url", HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("deleteProgram/{id}")
    public ResponseEntity<?> deleteProgramById(@PathVariable Integer id)
    {
        if(programService.getProgramById(id).isPresent())
        {
            programService.deleteProgramById(id);
            return new ResponseEntity<>("Message : Deleted Successfully", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : Id not found", HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/getBatchesByProgramId/{id}")
    public ResponseEntity<?> getBatchesByProgramId1(@PathVariable Integer id)
    {
        if(programService.getProgramById(id).isPresent())
        {
            Program program = programService.getById(id);

            List<Batch> batches = batchService.getBatchesByProgramId(id);
            ProgramBatchDTO programBatchDTO = new ProgramBatchDTO(program.getProgramId(),program.getProgramName(),program.getProgramDescription(),
                    program.getProgramStatus(),program.getCreationTime(),program.getLastModTime(),batches);

            return new ResponseEntity<>(programBatchDTO, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Message : ID not found",HttpStatus.NOT_FOUND);
        }
    }

}
