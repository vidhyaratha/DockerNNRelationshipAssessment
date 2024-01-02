package com.vidhya.nnassessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tbl_lms_batch")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Batch {

    @Id
    @Column(name = "batch_id")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batchId;
    @Column(name = "batch_name")
    private String batchName;
    @Column(name = "batch_description")
    private String batchDescription;
    @Column(name = "batch_status")
    private String batchStatus;
    @Column(name = "batch_program_id")
    private int batchProgramId;
    @Column(name = "batch_no_of_classes")
    private int batchNoOfClasses;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "last_mod_time")
    private LocalDateTime lastModTime;


    @JsonIgnore
//    @JsonProperty
    @ManyToOne
    @JoinColumn(referencedColumnName = "program_id")
    private Program program;
}
