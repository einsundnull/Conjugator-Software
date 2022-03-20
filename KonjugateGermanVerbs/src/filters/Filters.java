package filters;

import static mainWindow.MainWindow.inputTextFieldText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import conjugate.ConjugateRegularVerbs;
import mainWindow.MainWindow;

public class Filters {

	public static boolean verbIsIrregular;
	public static boolean verbIsSeparable;
	public static boolean verbIsReflexive;
	public static boolean verbIsTransitive;
	public static boolean verbUsesDative;
	public static boolean verbExistsInReflAndNonRef;
	public static boolean verbDontUsesGE;
	public static boolean verbStemEndsOnIEREN;
	public static boolean verbEndsOnEST;
	public static boolean verbEndsOnST;
	public static boolean verbEndsOnT;
	public static boolean verbStemEndsOnS;
	public static boolean verbStemEndsOnß;
	public static boolean verbStemEndsOnZ;
	public static boolean verbStemEndsOnR;
	public static boolean verbStemEndsOnFrikative;
	public static boolean foundNonseparableSylable;

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

	final static String[] nonseparapeblePresylables = { "be", "emp", "ent", "er", "miss", "ver", "zer", "wider" };

	public final static String[] sepSylII = { "ab", "an", "aneinander", "auf", "aus", "bei", "bereit", "breit", "daher", "daneben", "dazwischen", "ein", "einher", "entgegen",
			"entlang", "fest", "fertig", "gegen", "her", "herab", "herauf", "heraus", "herein", "hin", "hinunter", "hinter", "hinterher", "hinzu", "lang", "leer", "los", "mit",
			"nach", "rauf", "raus", "rein", "runter", "über", "um", "unter", "voll", "vor", "voran", "voraus", "vorbei", "vorwärts", "rückwärts", "weg", "weiter", "wieder", "zu",
			"zuende", "zurück", "zusammen", "zuvor", "zwischen", };

	public final static String[] sepSyl = { "bereit", "daher", "einher", "empor", "entgegen", "entlang", "entzwei", "nieder", "rüber", "überein", "um", "los", "zu", "da",
			"zurecht", "hinzu", "heim", "fern", "fort", "füreinander", "gegenüber", "aufeinander", "auseinander", "beieinander", "gegeneinander", "hintereinander", "miteinander",
			"nacheinander", "nebeneinander", "übereinander", "untereinander", "voreinander", "zueinander", "zwischeneinander", };

	final static String[] nonseparableVerbs = { "umarmen", "umfahren", "umfassen", "umgeben", "umgehen", "umringen", "umschlingen", "umsorgen", "umzingeln", "hindern", "hinken",
			"hinterlassen", "langen", "langweilen", "überarbeiten", "überbieten", "überbringen", "überdachen", "überdauern", "überdenken", "überfahren", "überfallen",
			"überfliegen", "überfliegen", "überfordern", "überführen", "übergeben", "übergehen", "übergießen", "überholen", "überhören", "überlassen", "überlasten", "überleben",
			"überlegen", "übernachten", "übernehmen", "überprüfen", "überqueren", "überragen", "überraschen", "überreden", "überreichen", "überrollen", "überschätzen",
			"überschlagen", "überschneiden", "überschütten", "übersetzen", "überspringen", "übersteuern", "übertragen", "übertreiben", "übertreten", "überwachen", "überwältigen",
			"überweisen", "überwerfen", "überwinden", "überwintern", "überzeugen", "überziehen", "unterbieten", "unterbrechen", "unterdrücken", "unterfordern", "unterhalten",
			"unterkühlen", "unterlassen", "unterliegen", "unternehmen", "unterrichten", "unterschätzen", "unterscheiden", "unterschlagen", "untergraben", "unterschreiben",
			"unterspülen", "unterstreichen", "unterstützen", "untersuchen", "unterweisen", "unterwerfen", "unterzeichnen", "vollbringen", "widerfahren", "losen", "lehren" };

	final static String[] semiSeparableVerbs = { "hintergehen", "durchsetzen", "umfahren", "überfahren", "überlegen", "überschätzen", "übersetzen", "überspringen", "übertreten",
			"überwerfen", "überziehen", "unterkommen" };

	public static String checkSylable;
	public static String checkEnding;

	public static boolean foundSeparableSylable;
	private static boolean verbStemEndsOnRN;
	private static boolean verbStemEndsOnLN;
	private static boolean verbStemEndsOnTEN;
	private static boolean verbStemEndsOnDEN;
	private static boolean verbStemEndsOnMEN;
	private static boolean verbStemEndsOnLEN;
	private static boolean verbStemEndsOnFEN;
	private static boolean verbStemEndsOnKEN;
	private static boolean verbStemEndsOnGEN;
	private static boolean verbStemEndsOnCHEN;
	private static boolean verbStemEndsOnPEN;
	private static boolean verbStemEndsOnREN;
	private static boolean verbStemEndsOnGGEN;
	private static boolean verbStemEndsOnAGEN;
	private static boolean verbStemEndsOnÜGEN;
	private static boolean verbStemEndsOnÄGEN;
	private static boolean verbStemEndsOnEGEN;
	private static boolean verbStemEndsOnLGEN;
	private static boolean verbStemEndsOnRGEN;
	private static boolean verbStemEndsOnHEN;
	private static boolean verbStemEndsOnCKEN;
	private static boolean verbStemEndsOnNEN;
	private static boolean verbStemEndsOnSEN;
	private static boolean verbStemEndsOnZEN;
	private static boolean verbStemEndsOnXEN;
	private static boolean verbStemEndsOnCEN;
	private static boolean verbStemEndsOnIEN;
	private static boolean verbStemEndsOnSZEN;
	private static boolean verbStemEndsOnAKEN;
	private static boolean verbStemEndsOnUEN;
	private static boolean verbStemEndsOnVEN;
	private static boolean verbStemEndsOnWEN;
	private static boolean verbStemEndsOnAUEN;
	private static boolean verbStemEndsOnEUEN;
	private static boolean foundExcludedVerb;
	private static boolean verbStemEndsOnGNEN;
	private static boolean verbStemEndsOnCHNEN;
	public static boolean verbIsRealVerb;
	public static boolean verbStemEndsOnBEN;

	public static void checkForPresylable(String infinitiveWord) {
		foundSeparableSylable = false;
		ConjugateRegularVerbs.preSyl = "";
		foundExcludedVerb = false;
		char[] letterArray = infinitiveWord.toCharArray();
		String temp = "";
		int charLength = 0;
		for (int i = 0; i < nonseparableVerbs.length; i++) {
			if (("" + nonseparableVerbs[i]).equals(infinitiveWord)) {
				foundExcludedVerb = true;
//				System.err.println("found Excluded verb " + i + " Filters 115");
			}
		}
		if (!foundExcludedVerb) {
			for (int i = 0; i < letterArray.length; i++) {
				temp = temp + letterArray[i];
				System.err.println(temp);
				for (int s = sepSylII.length - 1; s >= 0; s--) {
//					System.err.println(sepSyl[s] + "   " + temp);
					if (sepSylII[s].equals(temp)) {
						if (temp.toCharArray().length > charLength) {
							foundSeparableSylable = true;
							charLength = temp.toCharArray().length;
							ConjugateRegularVerbs.preSyl = sepSylII[s];
							ConjugateRegularVerbs.präfix = "";
							System.err.println(ConjugateRegularVerbs.preSyl);
							break;
						}
					}
				}
			}
			infinitiveWord.replaceFirst(ConjugateRegularVerbs.preSyl, "");
			if (foundSeparableSylable) {
				infinitiveWord = "";
				for (int i = ConjugateRegularVerbs.preSyl.toCharArray().length; i < letterArray.length; i++) {
					infinitiveWord = infinitiveWord + "" + letterArray[i];
				}
				MainWindow.input[0] = infinitiveWord;
			}
		}
//		ExcelClass.setExcelFilePathForTable();
	}

	public static boolean checkVerbForItsProperties(String word) {
		String two = "";
		String three = "";
		String four = "";
		String five = "";
		int le = word.toCharArray().length;
		char[] wordArray = word.toCharArray();
		if (le - 5 > 0) {
			String ending = "" + wordArray[le - 5] + wordArray[le - 4] + wordArray[le - 3] + wordArray[le - 2] + wordArray[le - 1];
			if (ending.equals("ieren")) {
				verbStemEndsOnIEREN = true;
				verbIsRealVerb = true;
			}
		}
		try {
			two = "" + wordArray[le - 2] + wordArray[le - 1];
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			three = "" + wordArray[le - 3] + wordArray[le - 2] + wordArray[le - 1];
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			four = "" + wordArray[le - 4] + wordArray[le - 3] + wordArray[le - 2] + wordArray[le - 1];
		} catch (Exception e) {
		}
		try {
			five = "" + wordArray[le - 5] + wordArray[le - 4] + wordArray[le - 3] + wordArray[le - 2] + wordArray[le - 1];
		} catch (Exception e) {
		}

		for (int i = 0; i < le; i++) {
			checkSylable = checkSylable + wordArray[i];
			for (int n = 0; n < nonseparapeblePresylables.length; n++) {
				if (checkSylable.equals(nonseparapeblePresylables[n])) {
					foundNonseparableSylable = true;
					if (verbIsIrregular && ("" + wordArray[0] + wordArray[1]).equals(nonseparapeblePresylables[0])) {
						foundNonseparableSylable = false;
					}
					break;
				}
				if (foundNonseparableSylable) {
					break;
				}
			}
			if (two.equals("rn")) {
				verbStemEndsOnRN = true;
				verbIsRealVerb = true;
			}
			if (two.equals("ln")) {
				verbStemEndsOnLN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ten")) {
				verbStemEndsOnTEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ben")) {
				verbStemEndsOnBEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("den")) {
				verbStemEndsOnDEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("men")) {
				verbStemEndsOnMEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("len")) {
				verbStemEndsOnLEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("fen")) {
				verbStemEndsOnFEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ken")) {
				verbStemEndsOnKEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("gen")) {
				verbStemEndsOnGEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("pen")) {
				verbStemEndsOnPEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ren")) {
				verbStemEndsOnREN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("nen")) {
				verbStemEndsOnNEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("sen")) {
				verbStemEndsOnSEN = true;
				verbStemEndsOnFrikative = true;

			}
			if (three.equals("ßen")) {
				verbStemEndsOnSZEN = true;
				verbStemEndsOnFrikative = true;
				verbIsRealVerb = true;
			}
			if (three.equals("zen")) {
				verbStemEndsOnZEN = true;
				verbStemEndsOnFrikative = true;
				verbIsRealVerb = true;
			}
			if (three.equals("xen")) {
				verbStemEndsOnXEN = true;
				verbStemEndsOnFrikative = true;
				verbIsRealVerb = true;
			}
			if (three.equals("cen")) {
				verbStemEndsOnCEN = true;
				verbStemEndsOnFrikative = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ien")) {
				verbStemEndsOnIEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("ven")) {
				verbStemEndsOnVEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("wen")) {
				verbStemEndsOnWEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("hen")) {
				verbStemEndsOnHEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("fen")) {
				verbStemEndsOnFEN = true;
				verbIsRealVerb = true;
			}
			if (three.equals("uen")) {
				verbStemEndsOnUEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("cken")) {
				verbStemEndsOnCKEN = true;
				verbIsRealVerb = true;
			}

			if (four.equals("aken")) {
				verbStemEndsOnAKEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("chen")) {
				verbStemEndsOnCHEN = true;
				verbIsRealVerb = true;
			}

			if (four.equals("ggen")) {
				verbStemEndsOnGGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("agen")) {
				verbStemEndsOnAGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("ügen")) {
				verbStemEndsOnÜGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("ägen")) {
				verbStemEndsOnÄGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("egen")) {
				verbStemEndsOnEGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("lgen")) {
				verbStemEndsOnLGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("rgen")) {
				verbStemEndsOnRGEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("auen")) {
				verbStemEndsOnAUEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("euen")) {
				verbStemEndsOnEUEN = true;
				verbIsRealVerb = true;
			}
			if (four.equals("gnen")) {
				verbStemEndsOnGNEN = true;
				verbIsRealVerb = true;
			}
			if (five.equals("chnen")) {
				verbStemEndsOnCHNEN = true;
				verbIsRealVerb = true;
			}

		}
		return false;
	}

	public static boolean setValuesAccordingToProperties() {
		int length = 0;

		if (!verbIsIrregular) {
			if (!foundNonseparableSylable && !foundExcludedVerb) {
				ConjugateRegularVerbs.präfix = ConjugateRegularVerbs.präfixPerfekt;
			} else {
				ConjugateRegularVerbs.präfix = "";
			}
			if (verbStemEndsOnRN || verbStemEndsOnLN) {
				length = ConjugateRegularVerbs.inputWordCharArray.length - 1;
			} else {
				length = ConjugateRegularVerbs.inputWordCharArray.length - 2;
			}
			if (ConjugateRegularVerbs.preSyl.equals(inputTextFieldText[1]) || ConjugateRegularVerbs.preSyl.isEmpty()) {
				ConjugateRegularVerbs.preSyl = "";
			}
			for (int i = 0; i < length; i++) {
				ConjugateRegularVerbs.wordStemmRegularVerb = ConjugateRegularVerbs.wordStemmRegularVerb + ConjugateRegularVerbs.inputWordCharArray[i];
				ConjugateRegularVerbs.wordStemp2SG = ConjugateRegularVerbs.wordStemmRegularVerb;
			}
			if (verbStemEndsOnIEREN) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
				ConjugateRegularVerbs.präfix = "";
			}
			if (verbStemEndsOnRN == true) {
				ConjugateRegularVerbs.endingListPresensID = 3;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnLN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnTEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 2;
				ConjugateRegularVerbs.endingListPräteritumID = 3;
				ConjugateRegularVerbs.endingListePerfektID = 2;
				ConjugateRegularVerbs.endingListImperativeID = 1;
			}
			if (verbStemEndsOnBEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 1;
			}
			if (verbStemEndsOnDEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 2;
				ConjugateRegularVerbs.endingListPräteritumID = 3;
				ConjugateRegularVerbs.endingListePerfektID = 2;
				ConjugateRegularVerbs.endingListImperativeID = 1;
			}
			if (verbStemEndsOnMEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 2;
				ConjugateRegularVerbs.endingListPräteritumID = 3;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnLEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnFEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnKEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnPEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnREN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnLGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnHEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnFEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnNEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 2;
				ConjugateRegularVerbs.endingListImperativeID = 3;
			}

			if (verbStemEndsOnSEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 0;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnZEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 0;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnXEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 0;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnCEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 0;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnIEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnUEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnVEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnWEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnAUEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnEUEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnGNEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 2;
				ConjugateRegularVerbs.endingListPräteritumID = 3;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 1;
			}
			if (verbStemEndsOnGGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnAGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnÜGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnÄGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnEGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnRGEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}
			if (verbStemEndsOnCKEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnSZEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 0;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 2;
			}

			if (verbStemEndsOnAKEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}

			if (verbStemEndsOnCHEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 1;
				ConjugateRegularVerbs.endingListPräteritumID = 2;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 0;
			}
			if (verbStemEndsOnCHNEN == true) {
				ConjugateRegularVerbs.endingListPresensID = 2;
				ConjugateRegularVerbs.endingListPräteritumID = 3;
				ConjugateRegularVerbs.endingListePerfektID = 1;
				ConjugateRegularVerbs.endingListImperativeID = 1;
			}
		}
		if (verbIsIrregular) {
			ConjugateRegularVerbs.präfix = "";
		}

		return true;
	}

	public static void resetValues() {
		checkSylable = "";
		checkEnding = "";

		verbIsRealVerb = false;

		foundNonseparableSylable = false;
		verbStemEndsOnIEREN = false;
		verbStemEndsOnR = false;
		verbStemEndsOnS = false;
		verbStemEndsOnß = false;
		verbStemEndsOnZ = false;

		verbStemEndsOnFrikative = false;

		//////////////////

		verbStemEndsOnRN = false;
		verbStemEndsOnLN = false;
		verbStemEndsOnTEN = false;
		verbStemEndsOnBEN = false;
		verbStemEndsOnDEN = false;
		verbStemEndsOnMEN = false;
		verbStemEndsOnLEN = false;
		verbStemEndsOnFEN = false;
		verbStemEndsOnKEN = false;
		verbStemEndsOnGEN = false;
		verbStemEndsOnCHEN = false;
		verbStemEndsOnPEN = false;
		verbStemEndsOnREN = false;
		verbStemEndsOnGGEN = false;
		verbStemEndsOnAGEN = false;
		verbStemEndsOnÜGEN = false;
		verbStemEndsOnÄGEN = false;
		verbStemEndsOnEGEN = false;
		verbStemEndsOnLGEN = false;
		verbStemEndsOnRGEN = false;
		verbStemEndsOnHEN = false;
		verbStemEndsOnFEN = false;
		verbStemEndsOnCKEN = false;
		verbStemEndsOnNEN = false;
		verbStemEndsOnSEN = false;
		verbStemEndsOnSZEN = false;
		verbStemEndsOnZEN = false;
		verbStemEndsOnXEN = false;
		verbStemEndsOnCEN = false;
		verbStemEndsOnIEN = false;
		verbStemEndsOnAKEN = false;
		verbStemEndsOnUEN = false;
		verbStemEndsOnVEN = false;
		verbStemEndsOnWEN = false;
		verbStemEndsOnAUEN = false;
		verbStemEndsOnEUEN = false;
		verbStemEndsOnGNEN = false;
		verbStemEndsOnCHNEN = false;
	}

}
