package com.company.testapp.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Subject;

@UiController("testapp_Subject.edit")
@UiDescriptor("subject-edit.xml")
@EditedEntityContainer("subjectDc")
@LoadDataBeforeShow
public class SubjectEdit extends StandardEditor<Subject> {
}