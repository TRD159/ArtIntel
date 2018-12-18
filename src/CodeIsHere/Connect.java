package CodeIsHere;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Connect {
	Object o = new Frame("Connect Four");
}

class Frame extends JFrame {
	Frame(String name) {
		super(name);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		pack();

		Insets i = getInsets();

		setPreferredSize(new Dimension(getWidth() + (i.left + i.right), getHeight() + (i.top + i.bottom)));
		pack();

		setResizable(false);

		Panel p = new Panel(new Dimension(getWidth(), getHeight()));
		add(p);
		setVisible(true);

	}
}

class Panel extends JPanel {
	private int width, height;

	Panel(Dimension d) {
		super();
		this.setSize(d);
		width = getWidth();
		height = getHeight();
	}

	public void paint(Graphics g) {
		g.fillRect(0, 0, width, height);
	}
}

class Board {
	public static final int X = 8, Y = 7, Z = 8;
	public static final char TIE = 'T', RED = 'R', BLUE = 'B', EMPTY = '-', PLAYING = '-';

	private char[][][] board;
	private char winner;

	Board() {
		winner = PLAYING;
		board = new char[Z][Y][X];
		for(int z = 0; z < Z; z++) {
			for(int y = 0; y < Y; y++) {
				for(int x = 0; x < X; x++) {
					board[z][y][x] = EMPTY;
				}
			}
		}
	}

	Board(Board b) {
		this.board = b.board;
		this.winner = b.winner;
	}
}
	/*

	Please keep with the convention we've set up and make changes in the same file.
	It makes everything look a lot less arbitrary.

	TODO:
	 *  Implement a system to draw the board in a clear and concise way
	 *  Set up the move and location classes
	TODO:
	 *  Implement the following methods:
	 *   boolean makeMove(Move m, char p)
	 *   void setLocation(Location l, char p)
	 *   char getLocation()
	 *   char getWinner()
	 *   char[][][] getBoard()
	 *   boolean isFull(Move m)
	 *   void reset()
	 *   void draw()


	 */