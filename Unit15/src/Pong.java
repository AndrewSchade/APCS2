//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

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
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;

	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;

	private static final int ballx = 380;
	private static final int bally = 265;

	public Pong() {
		// set up all variables related to the game
		ball = new Ball(ballx, bally, 10, 10, Color.BLUE);

		leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
		rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
		keys = new boolean[4];
		leftScore = 0;
		rightScore = 0;

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

		// draw Objectsc
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		// see if ball hits left wall or right wall
		if ((ball.getX() <= 10))
				{
			rightScore++;
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack, getBackground());
			ball.setPos(ballx-8, bally-8);
			ball.setColor(getBackground());
			
			leftPaddle.draw(graphToBack, getBackground());
			leftPaddle.setColor(getBackground());
			rightPaddle.draw(graphToBack, getBackground());
			rightPaddle.setColor(getBackground());
			ball = new Ball(ballx, bally, 10, 10, Color.BLUE);
			leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
			rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
			
		}
	if(ball.getX() >= 780){
		leftScore++;
		ball.setXSpeed(0);
		ball.setYSpeed(0);
		ball.draw(graphToBack, getBackground());
		ball.setPos(ballx-8, bally-8);
		ball.setColor(getBackground());
		
		leftPaddle.draw(graphToBack, getBackground());
		leftPaddle.setColor(getBackground());
		rightPaddle.draw(graphToBack, getBackground());
		rightPaddle.setColor(getBackground());
		ball = new Ball(ballx, bally, 10, 10, Color.BLUE);
		leftPaddle = new Paddle(10, 244, 10, 70, Color.YELLOW, 4);
		rightPaddle = new Paddle(760, 244, 10, 70, Color.YELLOW, 4);
		}

		// see if the ball hits the top or bottom wall
		if ((ball.getY() <= 10 || ball.getY() >= 550)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		graphToBack.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		graphToBack.clearRect(1, 556, 799, 247);
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Player 1 Score: " + leftScore + "                                       "
				+ "Player 2 Score: " + rightScore, 70, 590);

		// see if the ball hits the left paddle
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() && ball.getY() >= leftPaddle.getY()
				&& (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()
						|| ball.getY() + ball.getHeight() >= leftPaddle.getY()
								&& ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())) {
			// no idea what this is
			if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			// make ball bounce
			else
				ball.setXSpeed(-ball.getXSpeed());
		}

		// see if the ball hits the right paddle
		if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() && ball.getY() >= rightPaddle.getY()
				&& (ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()
						|| ball.getY() + ball.getHeight() >= rightPaddle.getY()
								&& ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight())) {
			// no idea what this is
			if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() + Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			// make ball bounce
			else
				ball.setXSpeed(-ball.getXSpeed());
		}
		// see if the paddles need to be moved
		if (keys[0] == true) {
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1] == true) {
			leftPaddle.moveDownAndDraw(graphToBack);
		}

		if (keys[2] == true) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3] == true) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}