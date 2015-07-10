import java.awt.Color; 
import java.awt.Graphics;
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

public class SquareShape extends KipuThread implements  Shape {

	int x=0;
	int y=0;
	int size = 20;
	Color color = Color.BLUE;
	
	public SquareShape(int _x, int _y, Color _color, int _size) {
		x = _x;
		y = _y;
		color = _color;
		size = _size;
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
		return color;
	}


	@Override
	public int getSize() {
		return size;
	}
	
	
	
	@Override
	public void setup(Object param) {
	}

	@Override
	public void execute() {
		 y = (y+1)% 300;
	}

	@Override
	public int send(Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override 
	public void paint(Graphics g) {
		g.setColor(getColor());
		g.fill3DRect(getX(), getY(), getSize(), getSize(), true);	
	}

	 
}
