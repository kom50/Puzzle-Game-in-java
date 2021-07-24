package puzzle;

import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;

class ActionButton extends MouseAdapter {

	private JLabel[] box;
	private int x, y, blankY = 200, blankX = 200;
	private int []locX = { 0, 100, 200, 0, 100, 200, 0, 100, 200 }, locY = { 0, 0, 0, 100, 100, 100, 200, 200, 200 };
	private int move = 0;
	// refresh Button
	private JLabel refresh;
	private JLabel moveLabel;
	private JLabel winLabel;
	private int[] randomIndex = new int[9];
	private Random random = new Random();

	public void addButton(JLabel[] box) {
		this.box = new JLabel[box.length];
		for (int i = 0; i < this.box.length; i++) {
			this.box[i] = new JLabel();
			this.box[i] = box[i];
			this.box[i].addMouseListener(this);
		}
	}

	void addRefreshButton(JLabel btn) {
		refresh = btn;
		refresh.setName("Refresh");
		refresh.addMouseListener(this);
	}

	public void addMoveLabel(JLabel label) {
		moveLabel = label;
	}

	public void addWinLabel(JLabel label) {
		winLabel = label;
	}

	public void mousePressed(MouseEvent e) {

		Object obj = e.getSource();
		JLabel b = (JLabel) obj;
		int tempX = 0, tempY = 0;
		int index = 0;

		switch (b.getName()) {
		case "b0":
			index = 0;
			break;
		case "b1":
			index = 1;
			break;
		case "b2":
			index = 2;
			break;
		case "b3":
			index = 3;
			break;
		case "b4":
			index = 4;
			break;
		case "b5":
			index = 5;
			break;
		case "b6":
			index = 6;
			break;
		case "b7":
			index = 7;
			break;
		}
		System.out.println("Name :->  " + index);

		x = (int) box[index].getX();
		y = (int) box[index].getY();

		tempX = blankX - x;
		tempY = blankY - y;
		if (((tempX == -100 || tempX == 100) && tempY == 0) || ((tempY == -100 || tempY == 100) && tempX == 0)) {
			box[index].setLocation(blankX, blankY);
			blankX = x;
			blankY = y;
			//
			move++;
			moveLabel.setText("Total Move : " + move);
		}

		System.out.println("Move : " + move);

		//
		if (b.getName().equals("Refresh")) {
			System.out.println("Refresh Button clicked");
			refresh();
		} // restart end

		//
		win();
	}// mousePressed method end

	public void refresh() {
		
		move = 0;
		moveLabel.setText("Total Move : " + move);
		// Generate random numbers
		//randomIndexGenerator();

		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		Collections.shuffle(list);

		int blankIndex = list.get(list.size() - 1);  //randomIndex[randomIndex.length - 1];

		for (int i = 0; i < box.length; i++) {
			box[i].setLocation(locX[list.get(i)], locY[list.get(i)]);
//			box[i].setLocation(locX[randomIndex[i]], locY[randomIndex[i]]);
		}
		blankX = locX[blankIndex];
		blankY = locY[blankIndex];
		System.out.println(blankX + " " + blankY + " Blank Index : " + blankIndex);
		
		win();
	}

//	private String textLabelOfField(int lx, int ly) {
//		String text = "";
//		for (int i = 0; i < 8; i++) {
//			x = box[i].getX();
//			y = box[i].getY();
//			if (lx == x && ly == y) {
//				text = box[i].getName();
//			}
//		}
//		return text;
//	}

	private void win() {
		int full = 0;
//		String data = "";
		for (int i = 0; i < locX.length - 1; i++) {
			// data = textLabelOfField(locX[i], locY[i]);
			if (box[i].getX() == locX[i] && box[i].getY() == locY[i]) {// data.equals("b" + (k - 1))) {
				full += 1;
			}
		}
		if (full == 8) {
			System.out.println("Congratulations! You won.");
			winLabel.setText("Congratulations! You won.");
			box[8].setVisible(true);
			blankX = blankY = -1;
		} else {
			winLabel.setText("");
			box[8].setVisible(false);

		}
		System.out.println("Win method. " + full);
	}

	private void randomIndexGenerator() {
		// initial all randomIntex array data -1
		for (int i = 0; i < randomIndex.length; i++) {
			randomIndex[i] = -1;
		}
		int index = 0;
		boolean flag;
		do {
			int data = random.nextInt(9);
			flag = false;
			for (int j = 0; j <= index; j++) {
				if (randomIndex[j] == data) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				randomIndex[index++] = data;
			}
		} while (index != randomIndex.length);
	}
}