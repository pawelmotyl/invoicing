package printer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import company.*;
 
public class Printer implements Printable, ActionListener {
 
 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        /*
         * From PageFormat object get information about imageable area
         */
        Double imageableX = pf.getImageableX();
        Double imageableY = pf.getImageableY();
        Double imageableWidth = pf.getImageableWidth();
        Double imageableHeight = pf.getImageableHeight();
        Double imageableWidthHalf = imageableWidth/2;
        
        CompanyInterface seller = new Company();
        seller.setName1("Pawe³ Motyl");
        seller.setZipCode("31-229");
        seller.setCity("Kraków");
        seller.setStreet("Danka");
        seller.setZipCode("31-229");
        
        CompanyInterface buyer = new Company();
        buyer.setName1("Pawe³ Motyl1111");
        buyer.setZipCode("31-229");
        buyer.setCity("Kraków");
        buyer.setStreet("Danka");
        buyer.setZipCode("31-229");
        Font font = new Font("Arial", Font.PLAIN, 12);
 
        FontMetrics fontMetric = g.getFontMetrics(font);
        
        /* 
         * Move all the content to imageable area
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(imageableX, imageableY);
        
        SectionPrinter cp_1 = new CompanyPrinter()
        		.addGraphics(g)
        		.addPrintableSection((PrintableSectionInterface)seller)
        		.setFontMetrics(fontMetric)
        		.setX(imageableX.intValue())
        		.setY(imageableY.intValue());
        
        int current_top = ((CompanyPrinter)cp_1).generate();

        
        SectionPrinter cp_2 = new CompanyPrinter()
        		.addGraphics(g)
        		.addPrintableSection((PrintableSectionInterface)buyer)
        		.setFontMetrics(fontMetric)
        		.setX(imageableWidthHalf.intValue())
        		.setY(imageableY.intValue());
    	int top_after_buyer = ((CompanyPrinter)cp_2).generate();
    	
    	current_top = current_top > top_after_buyer ? current_top : top_after_buyer;
    	
    	System.out.println("CURRENT TOP " + current_top);
        
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
 
    public static void main(String args[]) {
  
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Hello World Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Hello World");
        printButton.addActionListener(new Printer());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
}