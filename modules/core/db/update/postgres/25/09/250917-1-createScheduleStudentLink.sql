create table TESTAPP_SCHEDULE_STUDENT_LINK (
    SCHEDULE_ID uuid,
    STUDENT_ID uuid,
    primary key (SCHEDULE_ID, STUDENT_ID)
);
