/*

    This file is part of the iText (R) project.
    Copyright (c) 1998-2016 iText Group NV

*/

package com.itextpdf.samples.book.part1.chapter02;

// TODO DEVSIX-459 No VerticalPositionMark
//public class PositionedArrow extends VerticalPositionMark {
//
//    /** Indicates if the arrow needs to be drawn to the left. */
//    protected boolean left;
//
//    /** Thee font that will be used to draw the arrow. */
//    protected BaseFont zapfdingbats;
//
//    /** An arrow pointing to the right will be added on the left. */
//    public static final PositionedArrow LEFT = new PositionedArrow(true);
//    /** An arrow pointing to the left will be added on the right. */
//    public static final PositionedArrow RIGHT = new PositionedArrow(false);
//
//    /**
//     * Constructs a positioned Arrow mark.
//     * @param    left    if true, an arrow will be drawn on the left;
//     * otherwise, it will be drawn on the right.
//     * @throws IOException
//     * @throws DocumentException
//     */
//    public PositionedArrow(boolean left) {
//        this.left = left;
//        try {
//            zapfdingbats = BaseFont.createFont(
//                    BaseFont.ZAPFDINGBATS, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
//        }
//        catch(DocumentException de) {
//            zapfdingbats = null;
//        }
//        catch(IOException ioe) {
//            zapfdingbats = null;
//        }
//    }
//
//    /**
//     * Draws a character representing an arrow at the current position.
//     * @see com.itextpdf.text.pdf.draw.VerticalPositionMark#draw(
//     *      com.itextpdf.text.pdf.PdfContentByte, float, float, float, float, float)
//     */
//    public void draw(PdfContentByte canvas, float llx, float lly, float urx, float ury, float y) {
//        canvas.beginText();
//        canvas.setFontAndSize(zapfdingbats, 12);
//        if (left) {
//            canvas.showTextAligned(Element.ALIGN_CENTER,
//                    String.valueOf((char)220), llx - 10, y, 0);
//        }
//        else {
//            canvas.showTextAligned(Element.ALIGN_CENTER,
//                    String.valueOf((char)220), urx + 10, y + 8, 180);
//        }
//        canvas.endText();
//    }
//}