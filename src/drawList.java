import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class drawList extends JPanel {

	private int level = 0;
	private String[] al;
	
	public drawList(int num){
		al = new String[num];
	}

	void setBox(int num, String[] al) {
		level = num;
		this.al = al;
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < level; i++) {
			g.setColor(Color.BLACK);			
			if (i > 5) {
				g.setFont(new Font("serif", Font.BOLD, 12));
				g.drawString("----->", 10 + (150 * (i - 5)), 275);
				g.setColor(Color.pink);
				g.drawRect(50 + (150 * (i - 5)), 250, 100, 50);
				g.drawString(al[i], 100 + (150 * (i - 5))-(3*al[i].length()), 280);
				g.drawString(String.valueOf(i),50 + (150 * (i - 5)) , 248);

			} else {
				g.setFont(new Font("serif", Font.BOLD, 12));
				g.drawString("----->", 160 + (150 * i), 125);
				g.setColor(Color.pink);
				g.drawRect(50 + (150 * i), 100, 100, 50);
				g.drawString(al[i], 100+ (150 * i)-(3*al[i].length()), 130);
				g.drawString(String.valueOf(i),50 + (150 * i) , 98);
			}
		}
	}
}
