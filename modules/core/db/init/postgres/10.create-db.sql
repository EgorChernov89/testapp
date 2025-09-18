-- begin TESTAPP_STUDENT
create table TESTAPP_STUDENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME_STUDENT varchar(255),
    GROUP_NAME varchar(255),
    --
    primary key (ID)
)^
-- end TESTAPP_STUDENT
-- begin TESTAPP_TEACHER
create table TESTAPP_TEACHER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME_TEACHER varchar(255),
    --
    primary key (ID)
)^
-- end TESTAPP_TEACHER
-- begin TESTAPP_SUBJECT
create table TESTAPP_SUBJECT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end TESTAPP_SUBJECT
-- begin TESTAPP_SCHEDULE
create table TESTAPP_SCHEDULE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEACHER_ID uuid,
    SUBJECT_ID uuid,
    DURATION integer not null,
    --
    primary key (ID)
)^
-- end TESTAPP_SCHEDULE
-- begin TESTAPP_SCHEDULE_STUDENT_LINK
create table TESTAPP_SCHEDULE_STUDENT_LINK (
    SCHEDULE_ID uuid,
    STUDENT_ID uuid,
    primary key (SCHEDULE_ID, STUDENT_ID)
)^
-- end TESTAPP_SCHEDULE_STUDENT_LINK
