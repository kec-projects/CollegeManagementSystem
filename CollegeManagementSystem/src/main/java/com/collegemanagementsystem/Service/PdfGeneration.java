package com.collegemanagementsystem.Service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Service
public class PdfGeneration {

    public void generatePdf() {
        try {
            String filePath =  "C:/Users/MonAmour/Desktop/sample.pdf";
            String image="C:\\Users\\MonAmour\\Desktop\\CollegeManagementSystem\\resume.jpg";
            ImageData data = ImageDataFactory.create(image);
            Image img = new Image(data);
            img.setFixedPosition(0, 140);
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            pdf.addNewPage();
            Document document = new Document(pdf);
            document.add(img);
            float [] pointColumnWidths = {150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            table.addCell(new Cell().add("Name").setBorder(Border.NO_BORDER).setFontColor(Color.GREEN));
            table.addCell(new Cell().add("Raju").setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Id").setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("1001").setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Designation").setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Programmer").setBorder(Border.NO_BORDER));

            // Adding Table to document
            document.add(table);
            document.close();
            System.out.println("PDF Created");

        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

