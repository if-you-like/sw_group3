import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class UI extends JFrame {
	static UI ui;
	FileUI Fui = new FileUI();
	Capture capture = new Capture();
	JButton btnPart, btnAll;

	public UI() {
		getContentPane().setLayout(null);

		btnPart = new JButton("Part");
		btnPart.setFont(new Font("±¼¸²", Font.PLAIN, 31));
		btnPart.setBounds(54, 21, 319, 79);
		getContentPane().add(btnPart);

		btnAll = new JButton("All");
		btnAll.setFont(new Font("±¼¸²", Font.PLAIN, 31));
		btnAll.setBounds(54, 147, 319, 79);
		getContentPane().add(btnAll);
	}

	public void buttoon() {
		btnPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ui.mouseClicked();

			}
		});

		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fui.FileOpen();
				capture.captureScreenAll(Fui.getFilePath());
			}
		});
	}

	public void mouseClicked() {
		ui.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("X:" + e.getX() + "Y:" + e.getY());
				Fui.FileOpen();
				capture.captureScreenPart(Fui.getFilePath(), ui.getX(), ui.getY(), e.getX(), e.getY());

			}
		});
	}

	public static void main(String args[]) {
		ui = new UI();
		ui.setSize(434, 312);
		Dimension frameSize = ui.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ui.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		ui.setVisible(true);

		ui.buttoon();
	}
}
