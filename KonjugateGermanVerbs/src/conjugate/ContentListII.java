package conjugate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ContentListII {


	static int pages = 155;
	static Robot rb;
	static String insert = "=KonjugationList.";
	static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();;
	static int add = 52;
	static int number = 1;

	static String[] letters = { "E", "F", "G", "H", "I", "J", "K", "L", "N", "O", "P", "Q", "R", "S", "T", "U" };


	public static void main(String[] args) throws AWTException, InterruptedException {
		Thread.sleep(3500);
		rb = new Robot();
		for (int p = 0; p < pages; p++) {
			for (int i = 0; i < letters.length; i++) {
				clip.setContents(new StringSelection(insert + letters[i] + number), null);
				Thread.sleep(500);
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				Thread.sleep(100);
				rb.keyPress(KeyEvent.VK_RIGHT);
				rb.keyRelease(KeyEvent.VK_RIGHT);
			}
			Thread.sleep(500);
			for (int i = 0; i < letters.length; i++) {
				rb.keyPress(KeyEvent.VK_LEFT);
				rb.keyRelease(KeyEvent.VK_LEFT);
			}
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			number = number + add;
		}
	}


}
