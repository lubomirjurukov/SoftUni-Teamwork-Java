package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
	public boolean up = false;
	public boolean down = false;
	public boolean left = false;
	public boolean right = false;
	public boolean enter = false;

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			up = true;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			down = true;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			right = true;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			left = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = false;
		}
	}
}
