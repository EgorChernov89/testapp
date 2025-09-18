package com.company.testapp.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "TESTAPP_SCHEDULE")
@Entity(name = "testapp_Schedule")
public class Schedule extends StandardEntity {
    private static final long serialVersionUID = -8824466740866401420L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TESTAPP_SCHEDULE_STUDENT_LINK",
    joinColumns = @JoinColumn(name = "SCHEDULE_ID"),
    inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<Student> student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID")
    private Subject subject;

    @Column(name = "DURATION", nullable = false)
    private Integer duration;


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}