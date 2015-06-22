package com.itextpdf.samples.sandbox.objects;

import com.itextpdf.basics.image.ImageFactory;
import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfWriter;
import com.itextpdf.core.pdf.xobject.PdfImageXObject;
import com.itextpdf.model.Document;
import com.itextpdf.model.element.Paragraph;
import com.itextpdf.samples.GenericTest;
import org.junit.Ignore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Ignore("image is not overflown. image is not aligned on the yLine")
public class ColumnTextChunkImage extends GenericTest {
    public static final String DOG = "src/test/resources/img/dog.bmp";
    public static final String FOX = "src/test/resources/img/fox.bmp";
    public static final String DEST = "./target/test/resources/sandbox/objects/column_text_chunk_image.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColumnTextChunkImage().manipulatePdf(DEST);
    }

    public void manipulatePdf(String dest) throws IOException {
        FileOutputStream fos = new FileOutputStream(dest);
        PdfWriter writer = new PdfWriter(fos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        PdfImageXObject dog = new PdfImageXObject(pdfDoc, ImageFactory.getImage(DOG));
        PdfImageXObject fox = new PdfImageXObject(pdfDoc, ImageFactory.getImage(FOX));
        Paragraph p = new Paragraph("quick brown fox jumps over the lazy dog.").
            add("Or, to say it in a more colorful way: quick brown ").
            add(new com.itextpdf.model.element.Image(fox)).
            add(" jumps over the lazy ").
            add(new com.itextpdf.model.element.Image(dog)).
            add(".").
            setMultipliedLeading(1);
        doc.add(p);

        doc.close();
    }

}