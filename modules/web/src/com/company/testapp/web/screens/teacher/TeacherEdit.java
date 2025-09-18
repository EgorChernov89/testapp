package com.company.testapp.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Teacher;

@UiController("testapp_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
@LoadDataBeforeShow
public class TeacherEdit extends StandardEditor<Teacher> {
}