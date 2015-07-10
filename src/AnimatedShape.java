import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import com.chaski.KipuThread;
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


public class AnimatedShape extends KipuThread implements  Shape{
	int x;
	double rotation = Math.PI/2;
	int y;
	BufferedImage[] image = new BufferedImage[3];
	File file;
	int currentImage = 0;

	public AnimatedShape(int _x, int _y) {
		x = _x;
		y = _y;

		try {
			file = new File("roach001.png");	
			image[0] = ImageIO.read(file);
			file = new File("roach002.png");	
			image[1] = ImageIO.read(file);
			file = new File("roach003.png");	
			image[2] = ImageIO.read(file);

		} catch (Exception e ) {

		}

	}

	@Override
	public int getX() {
		return x;
	}


	@Override
	public int getY() {
		return y;
	}


	@Override
	public Color getColor() {
		return Color.BLACK;
	}


	@Override
	public int getSize() {
		return image[currentImage].getHeight();
	}

	@Override
	public void setup(Object param) {	 
	}

	@Override
	public void execute() {
		x = (x+1)% 300;
		currentImage++;
		currentImage = currentImage % 3;
	}

	@Override
	public int send(Object param) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	@Override
	public 
	void paint(Graphics g) 
	{
		AffineTransform transform = new AffineTransform();
		
		transform.rotate(rotation, image[currentImage].getWidth()/2, 
				image[currentImage].getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(transform, 
				AffineTransformOp.TYPE_BILINEAR);
		BufferedImage bufferedImage = op.filter(image[currentImage], null);


		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bufferedImage, x, y, image[currentImage].getWidth(), image[currentImage].getHeight(), null);
	}

	 


	
	

}
