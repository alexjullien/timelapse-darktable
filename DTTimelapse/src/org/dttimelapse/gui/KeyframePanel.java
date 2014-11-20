package org.dttimelapse.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// this class constructs a Jpanel with display of a Polyline

public class KeyframePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private int x[];   // index of keyframes
	private int n;

    //Icon icon = new DynamicIcon();
    
    Icon icon = new RauteIcon();
    
    JLabel dynamicLabel = new JLabel(icon);


    
	public KeyframePanel() { // constructor

		x = new int[0];		

	} // end const

	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		for (int i = 0; i < n; i++) {
			int shift = 0;
//			if (i == 0) shift = 5;
//			if (i == n-1) shift = -5;

			icon.paintIcon(this, g, x[i] + shift, 400);

		}

	}


//	public void setCoord(int xValues[], int number) {		
//		
//		
//		this.n = xValues.length; // number of keyframes
//
//		if (n <= 1)
//			return;
//
//		x = new int[n];
//
//		// change the scaling of the Values to fit the panel
//		// we need global variables for dimensions
//
//		final double factorX = (600.0 / (number - 1));
//
//		// System.out.println("polygon n= " + n);
//		// System.out.println("factor= " + factorX);
//
//		for (int i = 0; i < n; i++) {
//
//			x[i] = (int) (xValues[i] * factorX);
//			
//			//System.out.println("i= " + xValues[i] + " x= " + x[i]);
//
//		}
//
//		return;
//
//	}
//	
	
	
	public void setCoord(PictureModel picModel, int anumber) {

		// search for keyframes
		List<Integer> indexlist = new ArrayList<Integer>();
		int[] xValues;					
		// get indexnumbers of keyframes
		int numberkey = 0;					
		for (int i = 0; i < anumber; i++) {
			if ((Boolean) picModel.getValueAt( i, 1)) {
				indexlist.add(i);
			}											
		}					
		xValues = new int[indexlist.size()];
		// set indexnumbers in array
		for (int i = 0; i < indexlist.size(); i++) {						
			xValues[i] = indexlist.get(i);																		
		}	   										

		
				
		
		this.n = xValues.length; // number of keyframes

		if (n <= 1)
			return;

		x = new int[n];

		// change the scaling of the Values to fit the panel
		// we need global variables for dimensions

		final double factorX = (600.0 / (anumber - 1));

		// System.out.println("polygon n= " + n);
		// System.out.println("factor= " + factorX);

		for (int i = 0; i < n; i++) {

			x[i] = (int) (xValues[i] * factorX);
			
			//System.out.println("i= " + xValues[i] + " x= " + x[i]);

		}

		return;

	}
	

	
	
	
	
    // A little icon class to draw an icon.
    class DynamicIcon implements Icon {
        public int getIconWidth() { return 10; }
        public int getIconHeight() { return 10; }
        
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.fill3DRect(x-5, y-5, getIconWidth(), getIconHeight(), true);
        }
    };

    
    // A little icon class to draw an icon.
    class RauteIcon implements Icon {
        public int getIconWidth() { return 10; }
        public int getIconHeight() { return 10; }
        
        public void paintIcon(Component c, Graphics g, int x, int y) {
        	
        	Graphics2D g2d;
        	g2d = (Graphics2D)g.create();
        	
            //g2d.fill3DRect(x-5, y-5, getIconWidth(), getIconHeight(), true);
            
            // rotate            
            g2d.rotate(Math.toRadians(45), x, y);
            g2d.setColor(Color.RED);
            g2d.fillRect(x-8, y-8, 16, 16);

            
        }
    };

    
    
    
    
//    class RauteIcon implements Icon {
//    	//TODO
//        public int getIconWidth() { return 10; }
//        public int getIconHeight() { return 10; }
//        
//        protected void paintComponent(Graphics g) {
//            Graphics2D g2d;
//            g2d = (Graphics2D)g.create();
//            
//      
//            // base rectangle
//            g2d.setColor(Color.GRAY.brighter());
//            g2d.fillRect(10, 10, 10, 10);
//            
//            
//            // rotated 45 degrees about center of rect
//            g2d = (Graphics2D)g.create();
//            g2d.rotate(Math.toRadians(45), 5, 5);
//            g2d.setColor(Color.BLACK);
//            g2d.fillRect(10, 10, 10, 10);
//
//            // done with g2d, dispose it
//            g2d.dispose();
//        }
//    };


}