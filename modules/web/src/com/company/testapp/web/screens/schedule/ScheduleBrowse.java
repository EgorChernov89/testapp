package com.company.testapp.web.screens.schedule;

import com.company.testapp.entity.Student;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Schedule;

import javax.inject.Inject;
import java.util.stream.Collectors;

@UiController("testapp_Schedule.browse")
@UiDescriptor("schedule-browse.xml")
@LookupComponent("schedulesTable")
@LoadDataBeforeShow
public class ScheduleBrowse extends StandardLookup<Schedule> {
    @Inject
    private UiComponents uiComponents;

    @Install(to = "schedulesTable.students", subject = "columnGenerator")
    private Component schedulesTableStudentsColumnGenerator(Schedule schedule) {

      Label<String> label = uiComponents.create(Label.TYPE_STRING);

        if (schedule.getStudent().isEmpty()) {
            label.setValue("");
        } else {
            String studentsNames = schedule.getStudent().stream()
                    .map(Student::getFullNameStudent)
                    .collect(Collectors.joining(", "));
            label.setValue(studentsNames);
        }
        return label;
    }
}