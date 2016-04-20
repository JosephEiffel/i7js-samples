/*

    This file is part of the iText (R) project.
    Copyright (c) 1998-2016 iText Group NV

*/

/**
 * This example was written by Bruno Lowagie in answer to the following question:
 * http://stackoverflow.com/questions/28450668/how-to-add-in-reply-to-annotation-using-itextsharp
 */
package com.itextpdf.samples.sandbox.annotations;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.samples.GenericTest;
import com.itextpdf.test.annotations.type.SampleTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.experimental.categories.Category;

@Category(SampleTest.class)
public class AddInReplyTo extends GenericTest {
    public static final String DEST = "./target/test/resources/sandbox/annotations/add_in_reply_to.pdf";
    public static final String SRC = "./src/test/resources/pdfs/hello_sticky_note.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddInReplyTo().manipulatePdf(DEST);
    }

    @Override
    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
        PdfPage page = pdfDoc.getFirstPage();
        List<PdfAnnotation> annots = page.getAnnotations();
        PdfDictionary sticky = annots.get(0).getPdfObject();
        Rectangle stickyRectangle = sticky.getAsArray(PdfName.Rect).toRectangle();
        PdfAnnotation replySticky = new PdfTextAnnotation(stickyRectangle)
                .setIconName(new PdfName("Comment"))
                .setInReplyTo(annots.get(0))
                .setText(new PdfString("Reply"))
                .setContents("Hello PDF")
                .setOpen(true);
        pdfDoc.getFirstPage().addAnnotation(replySticky);
        pdfDoc.close();
    }
}
