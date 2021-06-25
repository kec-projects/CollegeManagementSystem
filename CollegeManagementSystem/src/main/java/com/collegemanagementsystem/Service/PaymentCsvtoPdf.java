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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentCsvtoPdf {
    @Autowired
    private ConstantService constantService;

    public Map generatePdf(Map details, List<String[]> complete) {
        com.itextpdf.kernel.pdf.PdfWriter writer;
        try {
            String filePath = "C:/Users/RAM BABU SINGH/Desktop/sample.pdf";
            String image = "src\\main\\resources\\keclogo.png";
            writer = new PdfWriter(new FileOutputStream(filePath));
            PdfDocument pdf = new PdfDocument(writer);
            com.itextpdf.layout.Document document = new Document(pdf, com.itextpdf.kernel.geom.PageSize.A4);
            com.itextpdf.kernel.geom.PageSize pageSize = new com.itextpdf.kernel.geom.PageSize(PageSize.A4).rotate();
            PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
            // creating image data instance by passing the path to image
            ImageData img = ImageDataFactory.create(image);
            canvas.saveState();
            PdfExtGState state = new PdfExtGState();
            state.setFillOpacity(0.2f);
            canvas.setExtGState(state);
            canvas.addImage(img, 100, 250, pageSize.getWidth() / 2, false);
            canvas.restoreState();

            Text text = new Text("Payment Report").setBold().setFontSize(20f).setUnderline();
            document.add(new com.itextpdf.layout.element.Paragraph(text).setTextAlignment(TextAlignment.CENTER));
            Table table = new Table(new float[]{10, 10});
            table.setWidth(UnitValue.createPercentValue(100));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Registration No ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Registration No")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Student Name ")));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Student Name")))));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Total Amount ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Total Amount")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Payment Type ")));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Payment Type")))));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Payment Id ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Payment Id")))).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Fee Divisions ")));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(details.get("Fee Divisions")))));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Date ")).setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(constantService.getLocalDate()))).setBackgroundColor(Color.LIGHT_GRAY));
           // table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph("Time ")).setBackgroundColor(Color.LIGHT_GRAY));
           //table.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(String.valueOf(constantService.getLocalTime()))).setBackgroundColor(Color.LIGHT_GRAY));
            document.add(table);
            document.add(new com.itextpdf.layout.element.Paragraph());


            document.close();
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        Map msg = new HashMap();
        msg.put("Status", "DF");
        return msg;
    }
}
