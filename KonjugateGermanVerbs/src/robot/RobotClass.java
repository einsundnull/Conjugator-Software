package robot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class RobotClass {
	
	static Thread thread;
	static Thread tabelThread;
	static Robot rb;
	static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

	static int pages = 158;
	final static int add = 53;
	static String insert = "=ContentList.";
	static String insertII;
	static int number = 1;
	
	private static void move(int moves, int keyEvent) {
		try {
			Robot rb = new Robot();
			for (int i = 0; i < moves; i++) {
				rb.keyPress(keyEvent);
				rb.keyRelease(keyEvent);
			}
		} catch (Exception e) {

		}
	}

	private static void insert(int moves, ArrayList<String> words) {
		try {
			Robot rb = new Robot();
			for (int i = 0; i < moves; i++) {
				clip.setContents(new StringSelection(words.get(i)), null);
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				Thread.sleep(250);
				move(1, KeyEvent.VK_DOWN);
				Thread.sleep(250);
			}
		} catch (Exception e) {

		}
	}

	public static void startToInsertIntoTable() {
		try {

			rb = new Robot();
			Thread.sleep(4000);

			tabelThread = new Thread() {

				@Override
				public void run() {
					int plus = 0;
					int minus = -1;
					try {
//					
						clip.setContents(new StringSelection(insert + 1), null);
						tabelThread.sleep(500);
						pressInsert();
						move(1, KeyEvent.VK_DOWN);
						tabelThread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {
						for (int i = 0; i < pages; i++) {
							plus = plus + add;
							minus++;
							tabelThread.sleep(100);
//							clip.setContents(new StringSelection(insert + (plus - minus)), null);
							clip.setContents(new StringSelection(insert + (i + 1)), null);
							tabelThread.sleep(500);
							pressInsert();
							move(1, KeyEvent.VK_DOWN);
//							if (MainWindow.stop) {
//								tabelThread.currentThread().stop();
//
//								break;
//
//							}
						}
						plus = 0;
						minus = -1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			tabelThread.setDaemon(true);
			tabelThread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startToInsertFromContentList() {
		try {
			int sleep = 1200;

			int steps = 46;
			rb = new Robot();
			Thread.sleep(3500);

			tabelThread = new Thread() {

				@SuppressWarnings({ "static-access", "unused" })
				@Override
				public void run() {
					int minus = 0;
					try {
//					
						clip.setContents(new StringSelection(insert + "1"), null);
						tabelThread.sleep(500);
						pressInsert();
						move(steps, KeyEvent.VK_DOWN);
						tabelThread.sleep(sleep);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {
						for (int i = 2; i < pages + 1; i++) {
							tabelThread.sleep(sleep);
							clip.setContents(new StringSelection(insert + (i)), null);
							tabelThread.sleep(sleep);
							pressInsert();
							move(steps, KeyEvent.VK_DOWN);
							minus++;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			tabelThread.setDaemon(true);
			tabelThread.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pressInsert() {
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
	}
}
