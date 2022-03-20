package installer;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import mainWindow.MainWindow;

public class Install {

	private static String path = System.getProperty("user.home") + File.separator + "Konjugator";
	static String s = File.separator;
	static String[] files = new String[] { "javafx.base", "javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.media",
			"javafx.swing", "javafx-swt", "Window", };

	public static void copyFromResourceToFile() {
		if (!new File(path).exists()) {
			new File(path).mkdir();

			new File(path + s + "bin").mkdir();
		}
		try {
			for(int i = 0; i <  files.length; i++) {
				URL url = MainWindow.class.getResource("/lib/"+files[i]);
				String newPath = Paths.get(url.toURI()).toString().replace("file:/C:", "")+ s+files[i];
				newPath = newPath + s+files[i];
				System.out.println(newPath);
				File file = new File(newPath);
				
				if(!file.exists()) {
					Files.copy(Paths.get(url.toURI().toString().replace("file:/C:", "")+files[i]), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
				}
	}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		copyFromResourceToFile();
//	}
}
