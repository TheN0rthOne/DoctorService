CREATE TABLE pius_project_history.user
(
    id BIGINT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);
CREATE TABLE pius_project_history.records
(
    record_id      BIGINT NOT NULL,
    doctor_id      BIGINT NOT NULL,
    doctor_fio     TEXT,
    specialization TEXT,
    organization   TEXT,
    status         SMALLINT,
    date_time      TIMESTAMP WITHOUT TIME ZONE,
    user_id        BIGINT,
    CONSTRAINT pk_records PRIMARY KEY (record_id)
);

ALTER TABLE pius_project_history.records
    ADD CONSTRAINT FK_RECORDS_ON_USER FOREIGN KEY (user_id) REFERENCES pius_project_history."user" (id);