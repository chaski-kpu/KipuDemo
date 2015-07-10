import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

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


public class RunOnceShapeWithStack extends KipuThread implements  Shape{

	Stack<Object> stack = new Stack<Object>();

	public RunOnceShapeWithStack(Integer _x,Integer _y, Color _color, Integer _size) {
		stack.push (_x);
		stack.push (_y);
		stack.push(_color);
		stack.push(_size);
	}

	@Override
	public int getX() {
		Integer size= (Integer)stack.pop();
		Color color = (Color)stack.pop();
		Integer y = (Integer)stack.pop();
		Integer x = (Integer)stack.pop();
		stack.push(x);
		stack.push (y);
		stack.push(color);
		stack.push(size);
		return x;
	}


	@Override
	public int getY() {
		Integer size= (Integer)stack.pop();
		Color color = (Color)stack.pop();
		Integer y = (Integer)stack.pop();
		Integer x = (Integer)stack.pop();
		stack.push(x);
		stack.push (y);
		stack.push(color);
		stack.push(size);

		return y;
	}


	@Override
	public Color getColor() {
	
		Integer size= (Integer)stack.pop();
		Color color = (Color)stack.pop();
		Integer y = (Integer)stack.pop();
		Integer x = (Integer)stack.pop();
		stack.push(x);
		stack.push (y);
		stack.push(color);
		stack.push(size);
		return (color);
	}


	@Override
	public int getSize() {
		Integer size= (Integer)stack.pop();
		Color color = (Color)stack.pop();
		Integer y = (Integer)stack.pop();
		Integer x = (Integer)stack.pop();
		stack.push(x);
		stack.push (y);
		stack.push(color);
		stack.push(size);
		return size;
	}

	@Override
	public void setup(Object param) {	 
	}

	@Override
	public void execute() {

		Integer size= (Integer)stack.pop();
		Color color = (Color)stack.pop();
		Integer y = (Integer)stack.pop();
		Integer x = (Integer)stack.pop();
		

		y = (y+1)% 300;

		//x = (int) (x+1) %300;
		time--;
		if (time <=0)
			time = 0;
		
		stack.push(x);
		stack.push (y);
		stack.push(color);
		stack.push(size);
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
		g.setColor(getColor());
		g.fill3DRect(getX(), getY(), getSize(), getSize(), true);	
	}


}
