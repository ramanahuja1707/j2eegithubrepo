package com.CloudPrinting.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class printdoc implements Printable {
  private String filedata;
  static AttributedString myStyledText = null;
	public String getFiledata() {
	return filedata;
    }
public void setFiledata(String filedata) {
	this.filedata = filedata;
}
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
	if(pageIndex>0)
	{
		return NO_SUCH_PAGE;
	}
	   Graphics2D graphics2d = (Graphics2D) graphics;
       /**
        * Move the origin from the corner of the Paper to the corner of the imageable
        * area.
        */
       graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

       /** Setting the text color**/
       graphics2d.setPaint(Color.black);
       /**
        * Use a LineBreakMeasurer instance to break our text into lines that fit the
        * imageable area of the page.
        */
       Point2D.Float pen = new Point2D.Float();
       AttributedCharacterIterator charIterator = myStyledText.getIterator();
       LineBreakMeasurer measurer = new LineBreakMeasurer(charIterator,
               graphics2d.getFontRenderContext());
       float wrappingWidth = (float) pageFormat.getImageableWidth();
       while (measurer.getPosition() < charIterator.getEndIndex()) {
           TextLayout layout = measurer.nextLayout(wrappingWidth);
           pen.y += layout.getAscent();
           float dx = layout.isLeftToRight() ? 0 : (wrappingWidth - layout
                   .getAdvance());
           layout.draw(graphics2d, pen.x + dx, pen.y);
           pen.y += layout.getDescent() + layout.getLeading();
       }
/*	Graphics2D g2d=(Graphics2D)graphics;
	g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
String[] s=new String[10];
s=getFiledata().split("\n");
	graphics.drawString(s[0], 100, 100);*/
		return PAGE_EXISTS;
	}

}
