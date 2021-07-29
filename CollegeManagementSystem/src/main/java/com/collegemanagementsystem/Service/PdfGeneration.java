package com.collegemanagementsystem.Service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfGeneration {
    @Autowired
    private ConstantService constantService;

    public Map generatePdf(Map details, List<String[]> complete) {
        PdfWriter writer;
        try {
            String filePath = "C:/Users/MonAmour/Desktop/sample.pdf";
            String image = "src\\main\\resources\\keclogo.png";
            writer = new PdfWriter(new FileOutputStream(filePath));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            PageSize pageSize = new PageSize(PageSize.A4).rotate();
           PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
            // creating image data instance by passing the path to image
            ImageData img = ImageDataFactory.create(image);
            canvas.saveState();
            PdfExtGState state = new PdfExtGState();
            state.setFillOpacity(0.2f);
            canvas.setExtGState(state);
            canvas.addImage(img, 100, 250, pageSize.getWidth() / 2, false);
            canvas.restoreState();

            Text text = new Text("Attendance Report").setBold().setFontSize(20f).setUnderline();
            document.add(new Paragraph(text).setTextAlignment(TextAlignment.CENTER));
            Table table = new Table(new float[]{10, 10});
            table.setWidth(UnitValue.createPercentValue(100));
            table.addCell(new Cell().add(new Paragraph("Subject ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Subject Name")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph("Teacher ")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Teacher Name")))));
            table.addCell(new Cell().add(new Paragraph("Semester ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Semester")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph("Batch ")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Batch")))));
            table.addCell(new Cell().add(new Paragraph("Department ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Branch")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph("Total Class Conducted ")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(details.get("Total Class")))));
            table.addCell(new Cell().add(new Paragraph("Generated Date ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(constantService.getLocalDate()))).setBackgroundColor(Color.LIGHT_GRAY));
            document.add(table);
            document.add(new Paragraph());
            int counter=0,totalClass= (int) details.get("Total Class");
            for(int i =0;i<=(totalClass+6)/10;i++){
                Table table1 = new Table(new float[]{5,5,5,5,5,5,5,5,5,5});
                table1.setWidth(UnitValue.createPercentValue(100));
                for(int k=0;k<complete.size();k++){
                for(int j=counter;j<counter+10;j++){
                    table1.addCell(new Cell().add(new Paragraph(String.valueOf(complete.get(k)[j]))));

                }}
                counter+=10;
                document.add(table1);
             document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }
            document.close();
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        Map msg = new HashMap();
        msg.put("Status", "DF");
        return msg;
    }
}

