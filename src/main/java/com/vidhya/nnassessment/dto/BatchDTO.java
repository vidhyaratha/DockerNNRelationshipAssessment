package com.vidhya.nnassessment.dto;

import com.vidhya.nnassessment.entity.Program;


import java.time.LocalDateTime;

public class BatchDTO {

    private Integer batchId;
    private String batchName;
    private String batchDescription;
    private String batchStatus;
    private int batchProgramId;
    private int batchNoOfClasses;
    private LocalDateTime creationTime;
    private LocalDateTime lastModTime;
    private Program program;

    public BatchDTO() {
    }

    public BatchDTO(Integer batchId, String batchName, String batchDescription, String batchStatus, int batchProgramId, int batchNoOfClasses, LocalDateTime creationTime, LocalDateTime lastModTime, Program program) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.batchDescription = batchDescription;
        this.batchStatus = batchStatus;
        this.batchProgramId = batchProgramId;
        this.batchNoOfClasses = batchNoOfClasses;
        this.creationTime = creationTime;
        this.lastModTime = lastModTime;
        this.program = program;
    }

    public BatchDTO(Integer batchId, String batchName, String batchDescription, String batchStatus, int batchProgramId, int batchNoOfClasses, LocalDateTime creationTime, LocalDateTime lastModTime) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.batchDescription = batchDescription;
        this.batchStatus = batchStatus;
        this.batchProgramId = batchProgramId;
        this.batchNoOfClasses = batchNoOfClasses;
        this.creationTime = creationTime;
        this.lastModTime = lastModTime;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public int getBatchProgramId() {
        return batchProgramId;
    }

    public void setBatchProgramId(int batchProgramId) {
        this.batchProgramId = batchProgramId;
    }

    public int getBatchNoOfClasses() {
        return batchNoOfClasses;
    }

    public void setBatchNoOfClasses(int batchNoOfClasses) {
        this.batchNoOfClasses = batchNoOfClasses;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

  }
