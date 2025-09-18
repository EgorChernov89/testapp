package com.company.testapp.web.screens.schedule;

import com.company.testapp.entity.Student;
import com.company.testapp.web.screens.student.StudentBrowse;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Schedule;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@UiController("testapp_Schedule.edit")
@UiDescriptor("schedule-edit.xml")
@EditedEntityContainer("scheduleDc")
@LoadDataBeforeShow
public class ScheduleEdit extends StandardEditor<Schedule> {

    @Inject
    private CollectionPropertyContainer<Student> studentDc;

    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("addStudent")
    public void onAddStudentClick(Button.ClickEvent event) {

        List<UUID> excludeStudentList = studentDc.getItems()
                .stream()
                .map(BaseUuidEntity::getId)
                .collect(Collectors.toList());

        StudentBrowse lookupScreen = (StudentBrowse) screenBuilders.lookup(Student.class, this)
                .withSelectHandler(selectedStudents -> selectedStudents.forEach(s -> {
                    if (!studentDc.getItems().contains(s)) {
                        studentDc.getMutableItems().add(s);
                    }
                })).build();

        lookupScreen.setExcludedStudents(excludeStudentList);
        lookupScreen.show();
    }
}