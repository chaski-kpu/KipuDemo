import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel; 

/*
Project Kipu 
Copyright (C) 2013, 2014, 2015  Michael Dorin

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

public class Painter extends JFrame {

	private MyCanvas panel;
	int count=0;

	LinkedList<Shape> shapeList = new LinkedList<Shape>();

	public Painter() {
		panel = new MyCanvas();
		setSize(300, 300);	
		setBackground(Color.WHITE);
		getContentPane().add(panel);
		setVisible(true);
	}

	public void add(Shape shape)
	{
		shapeList.add(shape);
	}
	
	
	
   

	/** DrawCanvas (inner class) is a JPanel used for custom drawing */
	private class MyCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);
			int count = shapeList.size();
			for (int i=0;i<count;i++) {
				Shape shape = shapeList.get(i);
				shape.paint(g);
			}
		}
	}
}
