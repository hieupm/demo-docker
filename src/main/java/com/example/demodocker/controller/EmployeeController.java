package com.example.demodocker.controller;

import com.example.demodocker.entities.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeController {
    @GetMapping("/index")
    public String print(){
        return "Hello!";
    }

    @GetMapping("/report")
    public String getReport() {

        try {
            // create employee data
            Employee emp1 = new Employee(1, "HieuPM", "Admin", "Hieu city");
            Employee emp2 = new Employee(2, "NamPink", "CEO", "Nam city");

            List<Employee> empLst = new ArrayList<Employee>();
            empLst.add(emp1);
            empLst.add(emp2);

            //dynamic parameters required for report
            Map<String, Object> empParams = new HashMap<String, Object>();
            empParams.put("HieuData", emp1);
            empParams.put("NamData", emp2);

            JasperPrint empReport =
                    JasperFillManager.fillReport
                            (
                                    JasperCompileManager.compileReport(
                                            ResourceUtils.getFile("/home/hieu/Downloads/Blank_A4.jrxml")
                                                    .getAbsolutePath()) // path of the jasper report
                                    , empParams // dynamic parameters
                                    , new JREmptyDataSource()
                            );

            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "employees-details.pdf");
            byte[] bytes = JasperExportManager.exportReportToPdf(empReport);
            //create the report in PDF format
            try (FileOutputStream fos = new FileOutputStream("/home/hieu/Downloads/test.pdf")) {
                fos.write(bytes);
            }
            return "Done";

        } catch(Exception e) {
            return "Failed";
        }
    }


    public static void main(String[] args) {
        try {
            /* User home directory location */

            /* Output file location */
            String outputFile = "/home/hieu/Downloads/test2.pdf";

            /* List to hold Items */
            List<Item> listItems = new ArrayList<>();

            /* Create Items */
            Item iPhone = new Item();
            iPhone.setName("iPhone 6S");
            iPhone.setPrice(65000.00);

            Item iPad = new Item();
            iPad.setName("iPad Pro");
            iPad.setPrice(70000.00);

            Item appleWatch = new Item();
            appleWatch.setName("Apple Watch");
            appleWatch.setPrice(35000.00);

            Item laptop = new Item();
            laptop.setName("Asus Laptop");
            laptop.setPrice(35000.00);

            /* Add Items to List */
            listItems.add(iPhone);
            listItems.add(iPad);
            listItems.add(appleWatch);
            listItems.add(laptop);

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ItemDataSource", itemsJRBean);

            /* Using compiled version(.jasper) of Jasper report to generate PDF */

            JasperPrint jasperPrint = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                    ResourceUtils.getFile("/home/hieu/Downloads/template.jrxml")
                            .getAbsolutePath()), parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "employees-details.pdf");
            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            //create the report in PDF format
            try (FileOutputStream fos = new FileOutputStream("/home/hieu/Downloads/test2.pdf")) {
                fos.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("Failed");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Failed");
        }
    }
}
