package com.company.testapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "TESTAPP_STUDENT")
@Entity(name = "testapp_Student")
@NamePattern("%s|fullNameStudent")
public class Student extends StandardEntity {
    private static final long serialVersionUID = -2152606135412193608L;

    @Column(name = "FULL_NAME_STUDENT")
    private String fullNameStudent;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @ManyToMany(mappedBy = "student")
    private List<Schedule> schedule;

    public String getFullNameStudent() {
        return fullNameStudent;
    }

    public void setFullNameStudent(String fullNameStudent) {
        this.fullNameStudent = fullNameStudent;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}