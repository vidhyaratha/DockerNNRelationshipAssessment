package com.vidhya.nnassessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tbl_lms_program")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Program {

    @Id
    @Column(name = "program_id")
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programId;
    @Column(name = "program_name")
    private String programName;
    @Column(name = "program_description")
    private String programDescription;
    @Column(name = "program_status")
    private String programStatus;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "last_mod_time")
    private LocalDateTime lastModTime;

    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Batch> batches;

}
