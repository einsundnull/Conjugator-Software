package fileClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import conjugate.ConjugateRegularVerbs;
import filters.Filters;
import mainWindow.MainWindow;
import strings.IrregularVerbs;
import strings.LoadedVerbs;

public class ReadFromList {

	static String s = File.separator;
	public static int sizeOfFile;
	public static boolean fileWasChossenByUser;
	public static File choosenFile;

	public static void readIrregularVerbListCompleteList() {

		try {
			URL url = MainWindow.class.getResource("/shemes/" + "irregularVerbsList.txt");
			String newPath = Paths.get(url.toURI()).toString().replace("file:/C:", "");
			File file = new File(newPath);
			Scanner scn = new Scanner(file, "UTF-8");
			String word = "";
			FileWriter wrt = new FileWriter(new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "newWord.txt"));
			while (scn.hasNext()) {
				try {
					word = scn.next();
//					for (int s = Filters.sepSyl.length - 1; s >= 0; s--) {
//						wrt.write(Filters.sepSyl[s] + "|" + word +"\n");
//					}

//					System.out.println(word + " ReadFromWordList 43");
					LoadedVerbs.infinitiveArray.add(word);

					LoadedVerbs.prs1SG_Irreg.add(scn.next());
					LoadedVerbs.prs2SG_Irreg.add(scn.next());
					LoadedVerbs.prs3SG_Irreg.add(scn.next());

					LoadedVerbs.prs1PL_Irreg.add(scn.next());
					LoadedVerbs.prs2PL_Irreg.add(scn.next());
					LoadedVerbs.prs3PL_Irreg.add(scn.next());

					LoadedVerbs.prät1SG_Irreg.add(scn.next());
					LoadedVerbs.prät2SG_Irreg.add(scn.next());
					LoadedVerbs.prät3SG_Irreg.add(scn.next());

					LoadedVerbs.prät1PL_Irreg.add(scn.next());
					LoadedVerbs.prät2PL_Irreg.add(scn.next());
					LoadedVerbs.prät3PL_Irreg.add(scn.next());

					LoadedVerbs.partI_Irreg.add(scn.next());
					LoadedVerbs.partII_Irreg.add(scn.next());

					LoadedVerbs.impI_Irreg.add(scn.next());
					LoadedVerbs.impII_Irreg.add(scn.next());
					word = scn.next();
//					System.out.println(word);
					LoadedVerbs.impIII_Irreg.add(word);

				} catch (Exception e) {
//					e.printStackTrace();
//					scn.close();
					break;
				}
			}
			scn.close();
			IrregularVerbs.irregularVerbs = new String[LoadedVerbs.infinitiveArray.size()];
			for (int i = 0; i < LoadedVerbs.infinitiveArray.size(); i++) {
				IrregularVerbs.irregularVerbs[i] = LoadedVerbs.infinitiveArray.get(i);
			}
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readRegularVerbListCompleteList() {

		try {
			URL url = MainWindow.class.getResource("/shemes/" + "regularVerbsList.txt");
			String newPath = Paths.get(url.toURI()).toString().replace("file:/C:", "");
			File file = new File(newPath);
			Scanner scn = new Scanner(file, "UTF-8");
			String word = "";
			while (scn.hasNext()) {
				try {
					word = scn.next();
					IrregularVerbs.regularVerbsArray.add(word);
				} catch (Exception e) {
					e.printStackTrace();
//					scn.close();
					break;
				}
			}
			scn.close();
			IrregularVerbs.regularVerbs = new String[IrregularVerbs.regularVerbsArray.size()];
			for (int i = 0; i < LoadedVerbs.infinitiveArray.size(); i++) {
				IrregularVerbs.regularVerbs[i] = IrregularVerbs.regularVerbsArray.get(i);
			}
		} catch (URISyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readInfinitiveVerbList() {

		try {
			File file = null;
			if (!fileWasChossenByUser) {
				URL url = MainWindow.class.getResource("/shemes/" + "irregularVerbsList.txt");
				String newPath = Paths.get(url.toURI()).toString().replace("file:/C:", "");
				file = new File(newPath);
			} else if (fileWasChossenByUser && choosenFile != null) {
				file = choosenFile;
				fileWasChossenByUser = false;
			}
			if (file != null) {
				Scanner scn = new Scanner(file, "UTF-8");
				sizeOfFile = 0;
				while (scn.hasNext()) {
					try {
						String temp = scn.next();
						LoadedVerbs.infinitiveArray.add(temp);
						scn.nextLine();
						sizeOfFile++;
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
				scn.close();
			}
		} catch (URISyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void conjugateInfiniteVerbList() {
		String infinitiveWord = "";
		for (int i = 0; i < sizeOfFile; i++) {
			infinitiveWord = LoadedVerbs.infinitiveArray.get(i);
			ConjugateRegularVerbs.turnStringToArray(infinitiveWord);
//			Filters.checkForPresylable(infinitiveWord);
			ConjugateRegularVerbs.startConjugation(infinitiveWord, "", i, true);
		}
	}

	public static void writePropertiesToFile() {
		File home = FileSystemView.getFileSystemView().getHomeDirectory();
		String path = home.getAbsolutePath();
		String fileName = "VerbPropertyList.txt";
		File write = new File(path + s + fileName);
	}
	
	public static void readSylVerbList() {

		try {
			URL url = MainWindow.class.getResource("/shemes/syslVerbList.txt");
			String newPath = Paths.get(url.toURI()).toString().replace("file:/C:", "");
			File file = new File(newPath);
			Scanner scn = new Scanner(file, "UTF-8");
			String word = "";
			FileWriter wrt = new FileWriter(new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "newWordChecked.txt"));
			while (scn.hasNext()) {
				try {
					boolean contains;
					word = scn.next();
					contains =	IrregularVerbs.checkForVerbsFromIrregularList(IrregularVerbs.irregularVerbs, word);
//					if(contains) {
						wrt.write(word + "\t"+ contains + "\n");
//					} else {
//						
//					}
					LoadedVerbs.sylVerbArray.add(word);


				} catch (Exception e) {
//					e.printStackTrace();
//					scn.close();
					break;
				}
			}
			scn.close();
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void compareSylVerbArray() {
		for(String i: LoadedVerbs.sylVerbArray) {
			IrregularVerbs.checkForVerbsFromIrregularList(IrregularVerbs.irregularVerbs, i);
		}
	}


}
