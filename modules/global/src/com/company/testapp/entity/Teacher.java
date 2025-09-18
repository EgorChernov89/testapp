package com.company.testapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "TESTAPP_TEACHER")
@Entity(name = "testapp_Teacher")
@NamePattern("%s|fullNameTeacher")
public class Teacher extends StandardEntity {
    private static final long serialVersionUID = 8161345031990153483L;

    @Column(name = "FULL_NAME_TEACHER")
    private String fullNameTeacher;

    @OneToMany(mappedBy = "teacher")
    private List<Schedule> schedule;

    public String getFullNameTeacher() {
        return fullNameTeacher;
    }

    public void setFullNameTeacher(String fullNameTeacher) {
        this.fullNameTeacher = fullNameTeacher;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}