create table world_record
(
    id               bigint auto_increment,
    description             varchar(255),
    record_value       double ,
    unit_of_measure varchar(255),
    date_of_record       date,
    recorder_id bigint,
        recorder_name varchar(255),
    primary key (id)
);
