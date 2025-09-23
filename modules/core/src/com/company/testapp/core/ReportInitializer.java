package com.company.testapp.core;

import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.reports.ReportImportExportAPI;
import org.apache.poi.util.IOUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component("testapp_ReportInitializer")
public class ReportInitializer {

    @Inject
    private ReportImportExportAPI reportImportExportAPI;

    @Inject
    private Resources resources;

    @Authenticated
    @EventListener
    public void onAppStarted(AppContextStartedEvent event) {
        List<String> reportFiles = Arrays.asList("com/company/testapp/core/resources/reports/Отчет по учителям.zip",
                "com/company/testapp/core/resources/reports/Отчет по количеству учеников.zip");

        for (String reportPath : reportFiles) {
            try (InputStream reportStream = resources.getResourceAsStream(reportPath)) {
                if (reportStream != null) {
                    byte[] reportsZip = IOUtils.toByteArray(reportStream);
                    reportImportExportAPI.importReports(reportsZip);
                }
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при импорте отчёта: " + reportPath, e);
            }
        }
    }
}
