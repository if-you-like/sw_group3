import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class FileUI {
	static JFileChooser chooser;
	static String filePath = "";

	void FileOpen() {
		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "��μ��� ����", "���", JOptionPane.WARNING_MESSAGE);
			return;
		}
		filePath = chooser.getSelectedFile().getPath();
	}

	String getFilePath() {
		return filePath;
	}
}