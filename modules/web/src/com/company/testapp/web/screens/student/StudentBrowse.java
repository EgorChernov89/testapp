package com.company.testapp.web.screens.student;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Student;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@UiController("testapp_Student.browse")
@UiDescriptor("student-browse.xml")
@LookupComponent("studentsTable")
@LoadDataBeforeShow
public class StudentBrowse extends StandardLookup<Student> {

    @Inject
    private CollectionLoader<Student> studentsDl;

    public void setExcludedStudents(List<UUID> excludedIds) {
        if (excludedIds == null || excludedIds.isEmpty()) {
            studentsDl.removeParameter("excludeList");
        } else {
            studentsDl.setParameter("excludeList", excludedIds);
        }
        studentsDl.load();
    }
}