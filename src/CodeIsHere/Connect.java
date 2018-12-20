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
	public static final int X = 8, Y = 7, Z = 8; //Z is the boards, Y is the rows, X is the columns
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

	public char[][][] getBoard() {
		return board;
	}

	public void setBoard(char[][][] board) {
		this.board = board;
	}
}

class Location {
	int x, y, z;

	Location(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "(" +
				"x=" + x +
				", y=" + y +
				", z=" + z +
				')';
	}
}

class Move {
	private int z, y, x;
	char[][][] b;
	private boolean possible = true;

	Move(int z, int x, char[][][] b) {
		this.z = z;
		this.x = x;

		this.b = b;

		isPossible:
		{
			for (int r = b[0].length; r >= 0; r--) {
				if (b[z][r][x] == '-') {
					y = r;
					break isPossible;
				}
			}
			possible = false;
		}
	}

	@Override
	public String toString() {
		return "(" +
				"Board " + z +
				", Row " + y +
				", Column" + x +
				')';
	}



	public int getZ() {
		return z;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
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