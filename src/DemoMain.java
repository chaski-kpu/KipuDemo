import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.chaski.Kipu;
import com.chaski.KipuFCFS;
import com.chaski.KipuRR;
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


public class DemoMain extends JFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Kipu kipu = Kipu.getInstance(10);  // 10 threads
	
	public static void main(String args[]) {
		DemoMain demomain = new DemoMain();
		demomain.mymain();
	}

	public void mymain() {

		Painter painter = new Painter();
		PaintingThread paintingThread = new PaintingThread(painter);
		paintingThread.setReload(10);	
		kipu.insert(paintingThread);

		PolyShape shape1 = new PolyShape(80,0,Color.RED,11);
		shape1.setReload(100);
		kipu.insert(shape1);
		painter.add(shape1);

		AnimatedShape shape2 = new AnimatedShape(40,0);
		kipu.insert(shape2);
		painter.add(shape2);
		shape2.setReload(100);

		SquareShape shape3 = new SquareShape(20,0,Color.CYAN, 16);
		shape3.setReload(1);
		kipu.insert(shape3);
		painter.add(shape3);

		try {
			kipu.kipuMain();  // enter the kipu main loop
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runOnceMain() {

		Painter painter = new Painter();
		PaintingThread paintingThread = new PaintingThread(painter);	
		kipu.always(paintingThread);

		//RunOnceShapeWithStack shape3 = new RunOnceShapeWithStack(100,0,Color.BLACK, 30);
		RunOnceShape shape3 = new RunOnceShape(100,0,Color.BLACK, 30);

		shape3.setTime(400);
		kipu.insert(shape3);
		painter.add(shape3);
		
		RunOnceShape shape1 = new RunOnceShape(0,0,Color.CYAN, 30);
		shape1.setTime(100);
		kipu.insert(shape1);
		painter.add(shape1);
		
		
		RunOnceShape shape2 = new RunOnceShape(50,0,Color.RED, 30);
		shape2.setTime(200);
		kipu.insert(shape2);
		painter.add(shape2);
		

		try {
			kipu.kipuMain();  // enter the kipu main loop
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
