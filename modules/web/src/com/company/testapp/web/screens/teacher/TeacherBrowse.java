package com.company.testapp.web.screens.teacher;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.testapp.entity.Teacher;
import com.haulmont.reports.entity.Report;
import com.haulmont.reports.gui.ReportGuiManager;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("testapp_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
@LoadDataBeforeShow
public class TeacherBrowse extends StandardLookup<Teacher> {

    @Inject
    ReportGuiManager reportGuiManager;

    @Inject
    GroupTable<Teacher> teachersTable;

    @Inject
    DataManager dataManager;

    @Inject
    private Notifications notifications;

    private void runReportByName(String nameReport) {
        Teacher teacher = teachersTable.getSingleSelected();
        if (teacher == null) {
            notifications
                    .create()
                    .withCaption("Не выбран учитель")
                    .show();
            return;
        }
        Report report = dataManager.load(Report.class)
                .query("select r from report$Report r where r.name =:name")
                .parameter("name", nameReport)
                .one();

        Map<String, Object> params = new HashMap<>();
        params.put("teacher1", teacher);
        reportGuiManager.printReport(report, params);
    }


    @Subscribe("runTeacher")
    public void onRunTeacherClick(Button.ClickEvent event) {
        runReportByName("Отчет по учителям");
    }

    @Subscribe("runStudent")
    public void onRunStudentClick(Button.ClickEvent event) {
        runReportByName("Отчет по количеству учеников");
    }
}