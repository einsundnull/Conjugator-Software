package conjugate;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;



public class Insert {

	static int steps = 52;
	static int pages = 55;
	static int sleep = 7500;
	static Robot rb;
	static String insert = "=ContentList.$E$";
	static Clipboard clip;
	public static int add = 0;
	static int number = 1;

	private static int mode = 1;
	private static final int KONJUGATION = 0;
	private static final int CONTENT_I = 1;
	private static final int CONTENT_II = 2;


	public static void main(String[] args) throws AWTException, InterruptedException {
		Thread.sleep(3500);
		Robot rb = new Robot();
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Thread.sleep(300);
//		switch (mode) {
//
//		case KONJUGATION:
//			setInsertOnKonjugationList();
//			break;
//		case CONTENT_I:
//			setInsertOnContentList();
//			break;
//		case CONTENT_II:
//			setInsertOnContentListII();
//			break;
//
//		default:
//			break;
//		}
		Thread.sleep(2500);
		clip.setContents(new StringSelection(insert + number), null);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		number = number + add;
		for (int i = 0; i < pages; i++) {
			clip.setContents(new StringSelection(new String(insert + number)), null);
			number = number + add;
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			for (int s = 0; s < steps; s++) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
			}
	
			rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(sleep);

		}
	}

	public static void setInsertOnKonjugationList() {
		steps = 52;
		sleep = 1500;
		insert = "=ContentList.E";

		add = 1;
	}

	public static void setInsertOnContentList() {
		steps = 1;
		sleep = 200;
//		insert = "=KonjugationList.G";
		insert = "=KonjugationList.$E$";
		add = 52;
	}

	public static void setInsertOnContentListII() {
		steps = 1;
		sleep = 200;
		insert = "=ContentList.E";
//		add = 52;
		add = 1;
	}

}
