package com.itextpdf.samples;

import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfWriter;
import com.itextpdf.model.Document;
import com.itextpdf.model.elements.ElementPosition;
import com.itextpdf.model.layout.ILayoutMgr;
import com.itextpdf.model.layout.shapes.BoxShape;
import com.itextpdf.model.elements.Paragraph;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Example demonstrates how to add paragraphs using floating and fixed layouts
 */
public class Listing_99_01_DifferentLayouts {

    static private final String RESULT = "./result.pdf";

    public static void main(String args[]) throws IOException {

        //Initialize writer
        FileOutputStream fos = new FileOutputStream(RESULT);
        PdfWriter writer = new PdfWriter(fos);
        writer.setCloseStream(true);

        //Initialize document
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        //Add floating paragraph
        doc.add(new Paragraph("Flowing paragraph"));

        //Add fixed paragraph
        Paragraph p = new Paragraph("Fixed paragraph");
        p.setRequestedPosition(new ElementPosition(new BoxShape(100, 100, 200, 200), ILayoutMgr.Fixed));
        doc.add(p);

        //Close document
        doc.close();

    }

}