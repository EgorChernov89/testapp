package com.company.testapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "TESTAPP_SUBJECT")
@Entity(name = "testapp_Subject")
@NamePattern("%s|name")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = -8967943406408177239L;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy="subject")
    private List<Schedule> schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}