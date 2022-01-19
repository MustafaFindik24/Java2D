package Calisma;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	private int genlik = 30;
	private double dalga_boyu = 8;// 5, 8, 10, 13.4, 20, 26.5, 40

	private double minSinCos = -8;
	private double maxSinCos = 80;

	private double minTanCot = -14.2;
	private double maxTanCot = 23.6;

	public Surface() {
	}

	private void doDrawing(Graphics g) {

		g.drawLine(0, 250, 840, 250);
		g.drawLine(450, 10, 450, 450);

		g.drawLine(450, 10, 445, 15);
		g.drawLine(450, 10, 455, 15);

		g.drawLine(450, 450, 445, 445);
		g.drawLine(450, 450, 455, 445);

		g.drawLine(0, 250, 5, 245);
		g.drawLine(0, 250, 5, 255);

		g.drawLine(840, 250, 835, 245);
		g.drawLine(840, 250, 835, 255);

		g.drawString("0", 455, 265);
		g.drawString("+y", 470, 20);
		g.drawString("+x", 820, 240);

		g.setColor(Color.blue);
		g.drawString("sin() :", 705, 18);
		g.drawLine(745, 15, 765, 15);

		g.setColor(Color.red);
		g.drawString("cos():", 705, 33);
		g.drawLine(745, 30, 765, 30);

		g.setColor(Color.orange);
		g.drawString("cot() :", 705, 48);
		g.drawLine(745, 45, 765, 45);

		g.setColor(Color.green);
		g.drawString("tan() :", 705, 63);
		g.drawLine(745, 60, 765, 60);

		for (double i = minSinCos; i <= maxSinCos; i += 0.05) {
			g.setColor(Color.blue);
			g.drawLine(200 + (int) (dalga_boyu * i), 250 - (int) (genlik * (Math.sin(i))),
					200 + (int) (dalga_boyu * (i + 0.05)), 250 - (int) (genlik * (Math.sin(i + 0.05))));

			g.setColor(Color.red);
			g.drawLine(200 + (int) (dalga_boyu * i), 250 - (int) (genlik * (Math.cos(i))),
					200 + (int) (dalga_boyu * (i + 0.05)), 250 - (int) (genlik * (Math.cos(i + 0.05))));
		}

		for (double i = minTanCot; i <= maxTanCot; i += 0.05) {
			g.setColor(Color.orange);
			g.drawLine(325 + (int) (10 * i), 250 - (int) (20 * (1 / Math.tan(i))), 325 + (int) (10 * (i + 0.05)),
					250 - (int) (20 * (1 / Math.tan(i + 0.05))));

			g.setColor(Color.green);
			g.drawLine(325 + (int) (10 * i), 250 - (int) (20 * (Math.tan(i))), 325 + (int) (10 * (i + 0.05)),
					250 - (int) (20 * (Math.tan(i + 0.05))));
		}
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}

public class Odev4 extends JFrame {

	public Odev4() {
		initUI();
	}

	private void initUI() {

		add(new Surface());
		setTitle("Trigonometri");
		setSize(855, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Odev4 ex = new Odev4();
				ex.setVisible(true);
			}

		});
	}
}
