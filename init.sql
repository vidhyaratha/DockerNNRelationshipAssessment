CREATE TABLE public.tbl_lms_program
(
    program_id integer NOT NULL,
    creation_time timestamp(6) without time zone,
    last_mod_time timestamp(6) without time zone,
    program_description character varying(255) COLLATE pg_catalog."default",
    program_name character varying(255) COLLATE pg_catalog."default",
    program_status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tbl_lms_program_pkey PRIMARY KEY (program_id)
);


CREATE TABLE public.tbl_lms_batch
(
    batch_id integer NOT NULL,
    batch_description character varying(255) COLLATE pg_catalog."default",
    batch_name character varying(255) COLLATE pg_catalog."default",
    batch_no_of_classes integer,
    batch_program_id integer,
    batch_status character varying(255) COLLATE pg_catalog."default",
    creation_time timestamp(6) without time zone,
    last_mod_time timestamp(6) without time zone,
    program_program_id integer,
    CONSTRAINT tbl_lms_batch_pkey PRIMARY KEY (batch_id),
    CONSTRAINT fkgfpwdqk81ytodx4ah5rs4k4yk FOREIGN KEY (program_program_id)
        REFERENCES public.tbl_lms_program (program_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



INSERT INTO public.tbl_lms_program(
	program_id, creation_time, last_mod_time, program_description, program_name, program_status)
	VALUES (1, '2024-05-05 01:43:02.035','2024-05-05 01:43:02.035', '001', 'SQL', 'Active'),
	 (2, '2024-05-05 01:43:02.035','2024-05-05 01:43:02.035', '001', 'SDET', 'Active'),
	 (3, '2024-05-05 01:43:02.035','2024-05-05 01:43:02.035', '001', 'DA', 'Active');



INSERT INTO public.tbl_lms_batch(
	batch_id, batch_description, batch_name, batch_no_of_classes, batch_program_id, batch_status, creation_time, last_mod_time, program_program_id)
	VALUES (9, '06', 'SMPO Batch 06', 15, 1, 'Active','2024-05-05 01:43:21.361', '2024-05-05 01:43:21.361',1),
	 (10, '05', 'SQL Batch 05', 15, 2, 'Active','2024-05-05 01:43:21.361', '2024-05-05 01:43:21.361',2),
	 (11, '03', 'DA Batch 03', 15, 3, 'Active','2024-05-05 01:43:21.361', '2024-05-05 01:43:21.361',3),
	 (12, '07', 'SDET Batch 07', 15, 1, 'Active','2024-05-05 01:43:21.361', '2024-05-05 01:43:21.361',1),
	 (13, '02', 'SDET Batch 02', 10, 2, 'Active','2024-05-05 01:43:21.361', '2024-05-05 01:43:21.361',2);