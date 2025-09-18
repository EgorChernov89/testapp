package com.company.testapp.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Subject;

@UiController("testapp_Subject.browse")
@UiDescriptor("subject-browse.xml")
@LookupComponent("subjectsTable")
@LoadDataBeforeShow
public class SubjectBrowse extends StandardLookup<Subject> {
}