import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cell {
  
	private int x, y;
	private int vx, vy;
	private int status = 0; // healthy is 0
	private int time = 5000;
	private int time2 = 5000;
	private int chance;
	private boolean recovered = false;
	private boolean prime = false;

	public Cell(int initX, int initY) {
		this();
		prime = true;
		status = 1;
		x = initX;
		y = initY;

	}

	public Cell() {

		x = (int) (Math.random() * 501);
		y = (int) (Math.random() * 501);
		vx = (int) (Math.random() * 9) - 4;
		vy = (int) (Math.random() * 9) - 4;

		while (vx == 0) {
			vx = (int) (Math.random() * 9) - 4;
		}
		while (vy == 0) {
			vy = (int) (Math.random() * 9) - 4;
		}

	}

	public void intersect(Cell other) {

		Rectangle og = new Rectangle(x, y, 25, 25);
		Rectangle otherCell = new Rectangle(other.x, other.y, 25, 25);

		if (og.intersects(otherCell)) {
			if (this.recovered == false && other.recovered == false) {
				if (this.status == 1 && other.status == 0) {
					other.status = 1;
				} else if (this.status == 0 && other.status == 1) {
					this.status = 1;
				}

			}
		}

	}

	public void paint(Graphics g) {
		if (status == 0) {
			g.setColor(Color.blue);
			if (recovered) {
				g.setColor(Color.green);
				time2 -= 16;
				if (time2 <= 0) {
					recovered = false;
					time2 = 5000;
				}
			}

		} else if (status == 1) {
			g.setColor(Color.black);
			if (prime == false) {
				time -= 16;
				if (time <= 0) {
					time = 5000;
					chance = (int) (Math.random() * 100);

					if (chance < 50) {
						x = 10000;
						y = 10000;
						vx = 0;
						vy = 0;
					} else {
						g.setColor(Color.green);
						status = 0;
						recovered = true;
					}
				}
			}

		}
		g.fillOval(x, y, 30, 30);
		x += vx;
		y += vy;

		if (x < 0 || x >= 775) {
			vx *= -1;
		}
		if (y < 0 || y >= 575) {
			vy *= -1;
		}

	}

}
