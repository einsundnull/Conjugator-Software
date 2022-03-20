package conjugate;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import filters.Filters;
import strings.IrregularVerbs;
import strings.LoadedVerbs;

public class ConjugateRegularVerbs {

	static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

	public static String input = "";
	public static String infWord = "";
	public final static int numberOfPersonalEndings = 6;
	public final static int numberOfImperatives = 3;
	public static int endingListPresensID = 1;
	public static int endingListPräteritumID = 1;
	public static int endingListePerfektID = 1;
	public static int endingListImperativeID = 0;

	public final static String präfixPerfekt = "ge";
	public final static String suffixPräteritum = "d";

	public static String wordStemmRegularVerb;
	public static String partiI = "";
	public static String partiII = "";

	public static ArrayList<String[]> personalEndingsPräsens = new ArrayList<String[]>();
	final static String[] personalEndingsPräsensOne = { "e", "t", "t", "en", "t", "en" };
	final static String[] personalEndingsPräsensTwo = { "e", "st", "t", "en", "t", "en" };
	final static String[] personalEndingsPräsensThree = { "e", "est", "et", "en", "et", "en" };
	final static String[] personalEndingsPräsensFour = { "e", "st", "t", "n", "t", "n" };

	public static ArrayList<String[]> personalEndingsPräteritum = new ArrayList<String[]>();
	final static String[] personalEndingsPräteritumOne = { "e", "est", "e", "en", "et", "en" };
	final static String[] personalEndingsPräteritumTwo = { "", "st", "", "en", "t", "en" };
	final static String[] personalEndingsPräteritumThree = { "te", "test", "te", "ten", "tet", "ten" };
	final static String[] personalEndingsPräteritumFour = { "ete", "etest", "ete", "eten", "etet", "eten" };
	final static String[] personalEndingsPräteritumIrregularZ = { "", "t", "", "en", "t", "en" };

	final static String[] perfektEnding = { "en", "t", "et" };
	private static String[] addaptedPersonalEndingsPräsens;
	private static String[] addaptedPersonalEndingsPräteritum;

	public static ArrayList<String[]> imperativeEnding = new ArrayList<String[]>();
	final static String[] imperativeEndingOne = { "", "t", "en" };
	final static String[] imperativeEndingTwo = { "e", "et", "en" };
	final static String[] imperativeEndingThree = { "e", "t", "en" };
	final static String[] imperativeEndingFour = { "e", "t", "n" };
	final static String[] imperativeEndingFive = { "", "t", "n" };

	public static ArrayList<String> presens = new ArrayList<String>();
	public static ArrayList<String> perfekt = new ArrayList<String>();
	public static ArrayList<String> preteritum = new ArrayList<String>();
	public static ArrayList<String> imperative = new ArrayList<String>();

	public static String preSyl = "";
	public static String präfix = präfixPerfekt;
	public static String wordStemp2SG = "";

	static String wordStem;
	static String wordStemPräs1PersSG;
	static String wordStemPräs2PersSG;
	static String wordStemPräs3PersSG;
	static String wordStemPräs1PersPL;
	static String wordStemPräs2PersPL;
	static String wordStemPräs3PersPL;
	static String wordStemPrät;
	static String wordStemPartI;
	static String wordStemPartII;
	static String wordPartI;
	static String wordPartII;

	public static char[] inputWordCharArray;

	public static boolean verbIsConjugated;

	public static void createEndingsList() {
		personalEndingsPräsens.add(personalEndingsPräsensOne);
		personalEndingsPräsens.add(personalEndingsPräsensTwo);
		personalEndingsPräsens.add(personalEndingsPräsensThree);
		personalEndingsPräsens.add(personalEndingsPräsensFour);
		personalEndingsPräteritum.add(personalEndingsPräteritumOne);
		personalEndingsPräteritum.add(personalEndingsPräteritumTwo);
		personalEndingsPräteritum.add(personalEndingsPräteritumThree);
		personalEndingsPräteritum.add(personalEndingsPräteritumFour);
		personalEndingsPräteritum.add(personalEndingsPräteritumIrregularZ);

		imperativeEnding.add(imperativeEndingOne);
		imperativeEnding.add(imperativeEndingTwo);
		imperativeEnding.add(imperativeEndingThree);
		imperativeEnding.add(imperativeEndingFour);
		imperativeEnding.add(imperativeEndingFive);
	}

	public static void turnStringToArray(String input) {
		wordStemmRegularVerb = "";
		präfix = "";
		infWord = input;
		inputWordCharArray = infWord.toCharArray();
//		preSyl = MainWindow.inputTextFieldArray.get(1).getText();
//		System.out.println("TURNED STRING TO ARRAY");
	}

	public static void startConjugation(String infinitiveWord, String preSylable, int index, boolean showVerbType) {

		präfix = "";
		wordStemmRegularVerb = "";
		presens.clear();
		perfekt.clear();
		preteritum.clear();
		imperative.clear();
		ConjugateRegularVerbs.infWord = infinitiveWord;
		inputWordCharArray = infinitiveWord.toCharArray();
		IrregularVerbs.checkWhetherLongVerbContainsVerbFromIrregularList(infinitiveWord);
		Filters.checkVerbForItsProperties(infinitiveWord);
		Filters.setValuesAccordingToProperties();
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		addaptedPersonalEndingsPräsens = personalEndingsPräsens.get(endingListPresensID);
		addaptedPersonalEndingsPräteritum = personalEndingsPräteritum.get(endingListPräteritumID);
		setPresensAndPartizip();
		setPreteritum();
		setPerfekt();
		setImperative();
		LoadedVerbs.writeSingleRowOfVerbs();
		LoadedVerbs.createPrintArray(showVerbType, index);

	}

	private static void setPresensAndPartizip() {
		if (!Filters.verbIsIrregular) {
			for (int i = 0; i < numberOfPersonalEndings; i++) {
				presens.add(wordStemmRegularVerb + addaptedPersonalEndingsPräsens[i]);
			}
		}
		if (Filters.verbIsIrregular) {
			presens.add(LoadedVerbs.prs1SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			presens.add(LoadedVerbs.prs2SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			presens.add(LoadedVerbs.prs3SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			presens.add(LoadedVerbs.prs1PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			presens.add(LoadedVerbs.prs2PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			presens.add(LoadedVerbs.prs3PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			partiII = preSyl + LoadedVerbs.partII_Irreg.get(IrregularVerbs.irregularVerbsIndex);
			partiI = preSyl + LoadedVerbs.partI_Irreg.get(IrregularVerbs.irregularVerbsIndex);
		} else {
			partiII = preSyl + präfix + wordStemmRegularVerb + perfektEnding[endingListePerfektID];
			partiI = preSyl + infWord + suffixPräteritum;
		}

	}

	private static void setPreteritum() {
		for (int i = 0; i < numberOfPersonalEndings; i++) {
			if (!Filters.verbIsIrregular) {
				preteritum.add(wordStemmRegularVerb + addaptedPersonalEndingsPräteritum[i]);
			} else {
				preteritum.add(LoadedVerbs.prät1SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
				preteritum.add(LoadedVerbs.prät2SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
				preteritum.add(LoadedVerbs.prät3SG_Irreg.get(IrregularVerbs.irregularVerbsIndex));
				preteritum.add(LoadedVerbs.prät1PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
				preteritum.add(LoadedVerbs.prät2PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
				preteritum.add(LoadedVerbs.prät3PL_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			}
		}
	}

	private static void setPerfekt() {
		for (int i = 0; i < numberOfPersonalEndings; i++) {
			if (!Filters.verbIsIrregular) {
				perfekt.add(partiII);
			} else {
				perfekt.add(LoadedVerbs.partII_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			}
		}
	}

	public static void setImperative() {
		if (!Filters.verbIsIrregular) {
			for (int i = 0; i < imperativeEndingOne.length; i++) {
				imperative.add(wordStemmRegularVerb + imperativeEndingOne[i]);
			}
		} else {
			imperative.add(LoadedVerbs.impI_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			imperative.add(LoadedVerbs.impII_Irreg.get(IrregularVerbs.irregularVerbsIndex));
			imperative.add(LoadedVerbs.impIII_Irreg.get(IrregularVerbs.irregularVerbsIndex));
		}
	}
}
