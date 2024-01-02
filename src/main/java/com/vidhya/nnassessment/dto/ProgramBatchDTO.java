package com.vidhya.nnassessment.dto;

import com.vidhya.nnassessment.entity.Batch;
import java.time.LocalDateTime;
import java.util.List;

public class ProgramBatchDTO {
    private Integer programId;
    private String programName;
    private String programDescription;
    private String programStatus;
    private LocalDateTime creationTime;
    private LocalDateTime lastModTime;
    private List<Batch> batches;

    public ProgramBatchDTO() {
    }

    public ProgramBatchDTO(Integer programId, String programName, String programDescription, String programStatus, LocalDateTime creationTime, LocalDateTime lastModTime, List<Batch> batches) {
        this.programId = programId;
        this.programName = programName;
        this.programDescription = programDescription;
        this.programStatus = programStatus;
        this.creationTime = creationTime;
        this.lastModTime = lastModTime;
        this.batches = batches;
    }

    public ProgramBatchDTO(Integer programId, String programName, String programDescription, String programStatus, LocalDateTime creationTime, LocalDateTime lastModTime) {
        this.programId = programId;
        this.programName = programName;
        this.programDescription = programDescription;
        this.programStatus = programStatus;
        this.creationTime = creationTime;
        this.lastModTime = lastModTime;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(LocalDateTime lastModTime) {
        this.lastModTime = lastModTime;
    }


    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
