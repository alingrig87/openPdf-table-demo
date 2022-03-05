package service;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import models.Employee;

public class PDFWithTable {
    public static final String CREATED_PDF = "D://PDFWithTable.pdf";
    public static void main(String[] args) {
        Document document = null;
        try {
            document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream(CREATED_PDF));
            Font font = new Font(Font.HELVETICA, 12, Font.BOLD);
            Table table = new Table(3);
            table.setPadding(5);
            table.setSpacing(1);
            table.setWidth(100);
            // Setting table headers
            Cell cell = new Cell("Employee Information");
            cell.setHeader(true);
            cell.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            cell.setColspan(3);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(cell);

            table.addCell(new Phrase("Name", font));
            table.addCell(new Phrase("Dept", font));
            table.addCell(new Phrase("Salary", font));
            table.endHeaders();
            // Employee information to table cells
            List<Employee> employees = getEmployees();
            for(Employee emp : employees) {
                table.addCell(emp.getName());
                table.addCell(emp.getDept());
                table.addCell(Integer.toString(emp.getSalary()));
            }
            document.open();
            document.add(table);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // create a list of employees
    private static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jack", "HR", 12000));
        employees.add(new Employee("Liza", "IT", 5000));
        employees.add(new Employee("Jeremy", "Finance", 9000));
        employees.add(new Employee("Frederick", "Accounts", 8000));
        return employees;
    }
}
