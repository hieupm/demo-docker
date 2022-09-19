package com.example.demodocker.controller;

import com.example.demodocker.dto.StudentReportDataAssembler;
import com.example.demodocker.dto.StudentReportInput;
import com.lowagie.text.pdf.PdfObject;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

import java.io.IOException;
import java.time.LocalDate;

public class StudentReportGenerator {
//    public PdfObject generateReport() throws IOException {
//        StudentReportInput studentReportInput = StudentReportDataAssembler.assemble();
//
//        byte[] reportData = null;
//        try {
//            JRMapArrayDataSource dataSource = new JRMapArrayDataSource(new Object[]{studentReportInput.getDataSources()});
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(TemplateCompiler.studentReportTemplate,
//                    studentReportInput.getParameters(), dataSource);
//
//            reportData = JasperExportManager.exportReportToPdf(jasperPrint);
//        } catch (JRException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        PdfObject pdfObject = new PdfObject.PdfObjectBuilder()
//                .creationDate(LocalDate.now())
//                .pdfContent(reportData)
//                .fileName("studentReport")
//                .build();
//
//        return pdfObject;
//    }
}
