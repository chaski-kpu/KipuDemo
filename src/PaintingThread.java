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

public class PaintingThread extends KipuThread {
	
	Painter painter;
	
	public PaintingThread(Painter _painter) {
		painter = _painter;
	}

	@Override
	public void execute() {
		 painter.repaint();
	}

	@Override
	public int send(Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setup(Object param) {
		// TODO Auto-generated method stub
		
	}

	

}
