import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private int rightscore;
	private int leftscore;
	private Ball ball;
	private Layer Pads;
	private Block block;
	private Paddle Pad;
	private boolean[] keys;
	private BufferedImage back;
	private boolean level1 = true;

	public Pong() {
		// set up all variables related to the game
		ball = new Ball();
		block = new Block();
		Pad = new Paddle(350, 244, 40, 40, Color.RED, 4);
		Pads = new Layer(10);
		keys = new boolean[4];
		rightscore = 0;
		leftscore = 0;
		Pads.buildblocks(2, 10, block);
		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and
		// smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);

		Pad.draw(graphToBack);
		
		Pads.draw(graphToBack);
		graphToBack.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

		graphToBack.setColor(Color.BLACK);

		if (!(ball.getX() >= 10 && ball.getX() <= 780)) {
			ball.setXSpeed(-ball.getXSpeed());
		}

		if (!(ball.getY() >= 50 && ball.getY() <= 540)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		if (ball.didCollideLeft(Pad) || ball.didCollideRight(Pad)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.didCollideTop(Pad) || ball.didCollideBottom(Pad)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (level1) {
			for (int i = 0; i < Pads.getSize(); i++) {
				if (ball.didCollideLeft(Pads.getsomething(i))
						|| ball.didCollideRight(Pads.getsomething(i))) {
					ball.setXSpeed(-ball.getXSpeed());
					Pads.removal(i);
				}
				if (ball.didCollideTop(Pads.getsomething(i))
						|| ball.didCollideBottom(Pads.getsomething(i))) {
					ball.setYSpeed(-ball.getYSpeed());
					Pads.removal(i);
				}
			}
		} else if (!level1) {
			for (int i = 0; i < Pads.getSize(); i++) {
				if (ball.didCollideLeft(Pads.getsomething(i))
						|| ball.didCollideRight(Pads.getsomething(i))) {
					ball.setXSpeed(-ball.getXSpeed());
					Pads.getsomething(i).decreaseHp();
					if (Pads.getsomething(i).getHp() == 0) {
						Pads.removal(i);
					}
				}
				if (ball.didCollideTop(Pads.getsomething(i))
						|| ball.didCollideBottom(Pads.getsomething(i))) {
					ball.setYSpeed(-ball.getYSpeed());
					Pads.getsomething(i).decreaseHp();
					if (Pads.getsomething(i).getHp() == 0) {
						Pads.removal(i);
					}
				}
			}

		}

		if (Pads.getSize() == 0 && level1) {
			Pads.buildblocks(2, 10, block);
			level1 = false;

		}
		if (level1) {
			graphToBack.drawString("Level 1", 10, 20);
		} else {
			graphToBack.drawString("Level 2", 10, 20);

		}

		if (keys[0] == true) {
			Pad.moveUpAndDraw(graphToBack);
		}
		if (keys[1] == true) {
			Pad.moveDownAndDraw(graphToBack);
		}

		if (keys[2] == true) {
			Pad.moveLeftAndDraw(graphToBack);
		}
		if (keys[3] == true) {
			Pad.moveRightAndDraw(graphToBack);
		}
		twoDGraph.drawImage(back, null, 0, 0);
		graphToBack.clearRect(0, 0, 800, 600);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'S':
			keys[1] = true;
			break;
		case 'A':
			keys[2] = true;
			break;
		case 'D':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'S':
			keys[1] = false;
			break;
		case 'A':
			keys[2] = false;
			break;
		case 'D':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}