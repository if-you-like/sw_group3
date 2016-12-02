import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Capture {

	public void captureScreenPart(String filename, int x, int y, int width, int height) {
		Robot robot = null;
		Capture cap = new Capture();
		
		// new Rectangle(x, y, width, height) 부분 캡쳐 가능
		Rectangle area = new Rectangle(new Rectangle(x + 10, y, width, height));
		try {
			robot = new Robot();
			BufferedImage bufImage = robot.createScreenCapture(area);
			ImageIO.write(bufImage, cap.getFromat(filename), new File(filename));

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFromat(String imageName) {
		imageName.toLowerCase();
		if (imageName.endsWith(".png"))
			return "PNG";
		if (imageName.endsWith(".gif"))
			return "GIF";
		if (imageName.endsWith(".jpg"))
			return "JPG";
		if (imageName.endsWith(".jpeg"))
			return "JPEG";
		if (imageName.endsWith(".bmp"))
			return "BMP";
		return "null";// 아무 문자열이나..
	}
}
