package com.vidhya.nnassessment.dto;


import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.time.LocalDateTime;
import java.util.List;

public class ProgramDTO {

    private Integer programId;
    private String programName;
    private String programDescription;
    private String programStatus;
    private LocalDateTime creationTime;
    private LocalDateTime lastModTime;
    private List<Batch> batches;

    public ProgramDTO() {
    }

    public ProgramDTO(Integer programId, String programName, String programDescription, String programStatus, LocalDateTime creationTime, LocalDateTime lastModTime) {
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


}
