package mainWindow;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import conjugate.ConjugateRegularVerbs;
import conjugate.ExcelClass;
import conjugate.FixedStrings;
import conjugate.WriteExcelFile;
import fileClass.ReadFromList;
import filters.Filters;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import strings.LoadedVerbs;

public class MainWindow extends Application {

	static CWindow window = new CWindow();;
	static CustomButton btn;
	static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

	public static boolean storeAsPDF = true;
	public static boolean storeAsEXCEL;
	public static boolean storeAsTEXT;
	public static boolean verbUsesDatNAkk;
	public static boolean verbUsesDativ;
	public static boolean verbUsesAkkusative;
	public static boolean fileNameGermanFirst;
	public static boolean verbUsesSeinForPerfect;
	public static boolean useAutoProposals;
	public static boolean verbIsReflexive;
	public static boolean verbIsReflexiveDative;
	public static boolean verbIsReflexiveAccusative;
	public static boolean addPräfixInPast = true;

	public static String[] inputTextFieldText = new String[] { "Deutsches Verb", "Vorsilbe", "Übersetzung" };
	public static String[] input = { "", "" };
	public static String refPron = "";

	
	@SuppressWarnings("static-access")
	private void setUIElements() {
		CWindow.germanVerbTextField.setOnKeyReleased(c -> {
			input[0] = CWindow.germanVerbTextField.getText();
			if (MainWindow.fileNameGermanFirst) {
				WriteExcelFile.tableName = refPron + " " + MainWindow.input[0] + " - " + MainWindow.input[1];
			} else {
				WriteExcelFile.tableName = MainWindow.input[1] + " - " + refPron + " " + MainWindow.input[0];
			}
			CWindow.lblFileName.setText(WriteExcelFile.tableName);
		});

		CWindow.translatedVerbTextField.setOnKeyReleased(c -> {
			input[1] = CWindow.translatedVerbTextField.getText();
			if (MainWindow.fileNameGermanFirst) {
				WriteExcelFile.tableName = refPron + " " + MainWindow.input[0] + " - " + MainWindow.input[1];
			} else {
				WriteExcelFile.tableName = MainWindow.input[1] + " - " + refPron + " " + MainWindow.input[0];
			}
			CWindow.lblFileName.setText(WriteExcelFile.tableName);
		});

		CWindow.ckBxAkk.setOnAction(c -> {
			verbUsesAkkusative = !verbUsesAkkusative;
			CWindow.ckBxDativ.setSelected(false);
			CWindow.ckBxDatAkk.setSelected(false);
			setCaseIndex();
		});

		CWindow.ckBxDativ.setOnAction(c -> {
			verbUsesDativ = !verbUsesDativ;
			CWindow.ckBxAkk.setSelected(false);
			CWindow.ckBxDatAkk.setSelected(false);
			setCaseIndex();
		});

		CWindow.ckBxDatAkk.setOnAction(c -> {
			verbUsesDatNAkk = !verbUsesDatNAkk;
			CWindow.ckBxDativ.setSelected(false);
			CWindow.ckBxAkk.setSelected(false);
			setCaseIndex();
		});
		CWindow.ckBxRef.setOnAction(c -> {
			verbIsReflexive = !verbIsReflexive;
			if (verbIsReflexive) {
				refPron = FixedStrings.pronounsReflexAkk[2];
			} else {
				refPron = "";
			}
			if (MainWindow.fileNameGermanFirst) {
				WriteExcelFile.tableName = refPron + " " + MainWindow.input[0] + " - " + MainWindow.input[1];
			} else {
				WriteExcelFile.tableName = MainWindow.input[1] + " - " + refPron + " " + MainWindow.input[0];
			}
		});
		CWindow.ckBxHABEN.setOnAction(c -> {
			verbUsesSeinForPerfect = false;
			CWindow.ckBxSEIN.setSelected(false);
			FixedStrings.auxIndex = 0;

		});
		CWindow.ckBxSEIN.setOnAction(c -> {
			verbUsesSeinForPerfect = !verbUsesSeinForPerfect;
			CWindow.ckBxHABEN.setSelected(false);
			FixedStrings.auxIndex = 1;
		});

		CWindow.ckBxDE.setOnAction(c -> {
			FixedStrings.caseIndexLang = 0;
			CWindow.ckBxDE.setSelected(true);
			CWindow.ckBxEN.setSelected(false);
			CWindow.ckBxRU.setSelected(false);
			CWindow.ckBxGE.setSelected(false);
			setLanguage();
		});
		CWindow.ckBxEN.setOnAction(c -> {
			FixedStrings.caseIndexLang = 1;
			CWindow.ckBxDE.setSelected(false);
			CWindow.ckBxEN.setSelected(true);
			CWindow.ckBxRU.setSelected(false);
			CWindow.ckBxGE.setSelected(false);
			setLanguage();
		});
		CWindow.ckBxRU.setOnAction(c -> {
			FixedStrings.caseIndexLang = 2;
			CWindow.ckBxDE.setSelected(false);
			CWindow.ckBxEN.setSelected(false);
			CWindow.ckBxRU.setSelected(true);
			CWindow.ckBxGE.setSelected(false);
			setLanguage();
		});
		CWindow.ckBxGE.setOnAction(c -> {
			FixedStrings.caseIndexLang = 3;
			CWindow.ckBxDE.setSelected(false);
			CWindow.ckBxEN.setSelected(false);
			CWindow.ckBxRU.setSelected(false);
			CWindow.ckBxGE.setSelected(true);
			setLanguage();
		});

		CWindow.ckBxPDF.setOnAction(c -> {
			storeAsPDF = !storeAsPDF;
			System.err.println(storeAsPDF);
		});

		CWindow.ckBxEXCEL.setOnAction(c -> {
			storeAsEXCEL = !storeAsEXCEL;
		});

		CWindow.ckBxTEXT.setOnAction(c -> {
			storeAsTEXT = !storeAsTEXT;
		});

		CWindow.ckBxFirstGEVerb.setOnAction(c -> {
			fileNameGermanFirst = !fileNameGermanFirst;
			CWindow.ckBxFirstTranslatedVerb.setSelected(!fileNameGermanFirst);
			if (MainWindow.fileNameGermanFirst) {
				WriteExcelFile.tableName = refPron + " " + MainWindow.input[0] + " - " + MainWindow.input[1];
			} else {
				WriteExcelFile.tableName = MainWindow.input[1] + " - " + refPron + " " + MainWindow.input[0];
			}
			CWindow.lblFileName.setText(WriteExcelFile.tableName);
		});

		CWindow.ckBxFirstTranslatedVerb.setOnAction(c -> {
			fileNameGermanFirst = !fileNameGermanFirst;
			CWindow.ckBxFirstGEVerb.setSelected(fileNameGermanFirst);
			if (MainWindow.fileNameGermanFirst) {
				WriteExcelFile.tableName = refPron + " " + MainWindow.input[0] + " - " + MainWindow.input[1];
			} else {
				WriteExcelFile.tableName = MainWindow.input[1] + " - " + refPron + " " + MainWindow.input[0];
			}
			CWindow.lblFileName.setText(WriteExcelFile.tableName);
		});

//		ckBxAutoProp.setOnAction(c -> {
//			useAutoProposals = !useAutoProposals;
//			ckBxDefMan.setSelected(useAutoProposals);
//		});
//
//		ckBxDefMan.setOnAction(c -> {
//			ckBxAutoProp.setSelected(useAutoProposals);
//			useAutoProposals = !useAutoProposals;
//
//		});

		CWindow.btnConjugate.setOnAction(c -> {
			Filters.resetValues();
			input[0] = CWindow.germanVerbTextField.getText();
			input[1] = CWindow.translatedVerbTextField.getText();

			if (!input[0].equals(inputTextFieldText[0])) {
				ReadFromList.readIrregularVerbListCompleteList();
				ReadFromList.readRegularVerbListCompleteList();
				FixedStrings.setReflexive();
				Filters.checkForPresylable(input[0]);
				ConjugateRegularVerbs.startConjugation(input[0], input[1], 0, false);
				FixedStrings strings = new FixedStrings();
				strings.completeTextForConjugationTableTextFile();
				strings.copyTextToClipboard(FixedStrings.completeText);
				ExcelClass excel = new ExcelClass();
				excel.chooseRightTabel();
				excel.setExcelFilePathForTable();
				excel.setStringArrayForExcelTable();
				WriteExcelFile.setFolderNameForConjugatedTables();
				WriteExcelFile.writeToExcelTable();
				ConjugateRegularVerbs.verbIsConjugated = true;
			}
			ReadFromList.readSylVerbList();
		});

	}

	private void setCaseIndex() {
		if (!verbUsesAkkusative && !verbUsesDativ && !verbUsesDatNAkk) {
			FixedStrings.caseIndexCase = 0;
		} else if (verbUsesAkkusative && !verbUsesDativ && !verbUsesDatNAkk) {
			FixedStrings.caseIndexCase = 1;
		} else if (!verbUsesAkkusative && verbUsesDativ && !verbUsesDatNAkk) {
			FixedStrings.caseIndexCase = 2;
		} else if (!verbUsesAkkusative && !verbUsesDativ && verbUsesDatNAkk) {
			FixedStrings.caseIndexCase = 3;
		}

	}

	private void setOnTextKeyAction() {
		window.getScene().setOnKeyPressed(k -> {
			if (k.getCode().equals(KeyCode.F1)) {
				ReadFromList.readInfinitiveVerbList();
				ReadFromList.conjugateInfiniteVerbList();
				FixedStrings strings = new FixedStrings();
				strings.copyTextToClipboard(LoadedVerbs.completeText);
			}
		});

	}

	public static void setLanguage() {
		String I = CWindow.germanVerbTextField.getText();
		String II = CWindow.translatedVerbTextField.getText();
		String deI = FixedStrings.uiText[0][0];
		String enI = FixedStrings.uiText[1][0];
		String ruI = FixedStrings.uiText[2][0];
		String geI = FixedStrings.uiText[3][0];

		String deII = FixedStrings.uiText[0][1];
		String enII = FixedStrings.uiText[1][1];
		String ruII = FixedStrings.uiText[2][1];
		String geII = FixedStrings.uiText[3][1];
		if (I.equals(deI) || I.equals(enI) || I.equals(ruI) || I.equals(geI)) {
			CWindow.germanVerbTextField.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][0]);
		}
		if (II.equals(deII) || II.equals(enII) || II.equals(ruII) || II.equals(geII)) {
			CWindow.translatedVerbTextField.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][1]);
		}

		CWindow.lblWhichCase.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][2]);
		CWindow.ckBxAkk.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][3]);
		CWindow.ckBxDativ.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][4]);
		CWindow.ckBxDatAkk.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][5]);
		CWindow.lblRef.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][6]);
		CWindow.ckBxRef.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][7]);
		CWindow.lblPerf.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][8]);
		CWindow.ckBxHABEN.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][9]);
		CWindow.ckBxSEIN.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][10]);
		CWindow.lblHeader.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][11]);
//		ckBxAutoProp = (CheckBox) root.lookup("#ckBxAutoProp");
//		ckBxDefMan = (CheckBox) root.lookup("#ckBxDefManual");
//		ckBxDE.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][12]);
//		ckBxEN.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][13]);
//		ckBxRU.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][14]);
//		ckBxGE.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][15]);
		CWindow.lblSaveAs.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][12]);
		CWindow.ckBxPDF.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][13]);
		CWindow.ckBxEXCEL.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][14]);
		CWindow.ckBxTEXT.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][15]);
		CWindow.lblChooseFileName.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][16]);
		CWindow.ckBxFirstGEVerb.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][17]);
		CWindow.ckBxFirstTranslatedVerb.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][18]);
		CWindow.btnConjugate.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][19]);
//		lblFileName.setText(FixedStrings.uiText[FixedStrings.caseIndexLang][0]);

	}

	@Override
	public void start(Stage arg0) throws Exception {

		window.createWindow();
		window.setPrefSize(750, 600);
		window.setDragResizeable(true);
		window.setAlwaysOnTopFXML(false);

//		setLanguage();
		
		setUIElements();
		CWindow.germanVerbTextField.requestFocus();
		setLanguage();
		setOnTextKeyAction();
		ConjugateRegularVerbs.createEndingsList();
		window.getFront().widthProperty().addListener(c -> {
			if (window.getFrame().getPrefWidth() != 0) {
				System.err.println(window.getFrame().getWidth());
				CWindow.menuVBox.setPrefWidth(window.getFront().getWidth());
			}
		});
		window.getFront().heightProperty().addListener(c -> {
			if (window.getFrame().getPrefHeight() != 0) {
				CWindow.menuVBox.setPrefHeight(window.getFront().getHeight());
			}
		});

	}

	public static void main(String[] args) {
		launch();
	}

}
