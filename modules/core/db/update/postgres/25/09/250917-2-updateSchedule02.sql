alter table TESTAPP_SCHEDULE rename column student_id to student_id__u44827 ;
alter table TESTAPP_SCHEDULE drop constraint FK_TESTAPP_SCHEDULE_ON_STUDENT ;
drop index IDX_TESTAPP_SCHEDULE_ON_STUDENT ;
