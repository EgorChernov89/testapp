package com.company.testapp.web.screens.student;

import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Student;

@UiController("testapp_Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
@LoadDataBeforeShow
public class StudentEdit extends StandardEditor<Student> {
}