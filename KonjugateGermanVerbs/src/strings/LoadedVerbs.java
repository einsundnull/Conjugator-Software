package strings;

import java.util.ArrayList;

import conjugate.ConjugateRegularVerbs;
import filters.Filters;

public class LoadedVerbs {

	public static String completeText = "";
	public static ArrayList<Integer> endingsPresIDArray = new ArrayList<Integer>();
	private static ArrayList<Integer> endingsPretIDArray = new ArrayList<Integer>();
	private static ArrayList<Integer> endingsPerfIDArray = new ArrayList<Integer>();
	private static ArrayList<Integer> endingsImpIDArray = new ArrayList<Integer>();

	public static ArrayList<String[]> printArray = new ArrayList<String[]>();
	public static ArrayList<String> printArrayList = new ArrayList<String>();
	public static ArrayList<String> infinitiveArray = new ArrayList<String>();

	public static String prs1SG = new String();
	public static String prs2SG = new String();
	public static String prs3SG = new String();

	public static String prs1PL = new String();
	public static String prs2PL = new String();
	public static String prs3PL = new String();

	public static String prät1SG = new String();
	public static String prät2SG = new String();
	public static String prät3SG = new String();

	public static String prät1PL = new String();
	public static String prät2PL = new String();
	public static String prät3PL = new String();

	public static String partI = new String();
	public static String partII = new String();

	public static String impI = new String();
	public static String impII = new String();
	public static String impIII = new String();

	public static ArrayList<String> prs1SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prs2SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prs3SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prs1PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prs2PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prs3PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät1SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät2SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät3SG_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät1PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät2PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> prät3PL_Irreg = new ArrayList<String>();;
	public static ArrayList<String> partI_Irreg = new ArrayList<String>();;
	public static ArrayList<String> partII_Irreg = new ArrayList<String>();;
	public static ArrayList<String> impI_Irreg = new ArrayList<String>();;
	public static ArrayList<String> impII_Irreg = new ArrayList<String>();;
	public static ArrayList<String> impIII_Irreg = new ArrayList<String>();
	public static ArrayList<String> sylVerbArray = new ArrayList<String>();


	public static void writeSingleRowOfVerbs() {

//		infinitiveArray.add(ConjugateRegularVerbs.infinitiveWord);

		prs1SG = ConjugateRegularVerbs.presens.get(0);
		prs2SG = ConjugateRegularVerbs.presens.get(1);
		prs3SG = ConjugateRegularVerbs.presens.get(2);

		prs1PL = ConjugateRegularVerbs.presens.get(3);
		prs2PL = ConjugateRegularVerbs.presens.get(4);
		prs3PL = ConjugateRegularVerbs.presens.get(5);

		prät1SG = ConjugateRegularVerbs.preteritum.get(0);
		prät2SG = ConjugateRegularVerbs.preteritum.get(1);
		prät3SG = ConjugateRegularVerbs.preteritum.get(2);

		prät1PL = ConjugateRegularVerbs.preteritum.get(3);
		prät2PL = ConjugateRegularVerbs.preteritum.get(4);
		prät3PL = ConjugateRegularVerbs.preteritum.get(5);

		partI = ConjugateRegularVerbs.partiI;
		partII = ConjugateRegularVerbs.partiII;

		impI = ConjugateRegularVerbs.imperative.get(0);
		impII = ConjugateRegularVerbs.imperative.get(1);
		impIII = ConjugateRegularVerbs.imperative.get(2);

//		endingsPresIDArray.add(ConjugateRegularVerbs.endingListPresensID);
//		endingsPretIDArray.add(ConjugateRegularVerbs.endingListPräteritumID);
//		endingsPerfIDArray.add(ConjugateRegularVerbs.endingListePerfektID);
//		endingsImpIDArray.add(ConjugateRegularVerbs.endingListImperativeID);
	}

	public static void createPrintArray(boolean showVerbType, int i) {

		String row = "";
		String newLine = "\n";
		String verbType = "" + Filters.verbIsIrregular;
		String verbTypeTab = "\t";
		int prsID = ConjugateRegularVerbs.endingListPresensID;
		int pretID = ConjugateRegularVerbs.endingListPräteritumID;
		int perfID = ConjugateRegularVerbs.endingListePerfektID;
		int impID = ConjugateRegularVerbs.endingListImperativeID;
//		printArrayList.clear();
//		printArray.clear();
		if (!showVerbType) {
			verbType = "";
			verbTypeTab = "";
		}
		if (i == infinitiveArray.size() - 2) {
			newLine = "";
		}
		row = infinitiveArray.get(i) + "\t" + prs1SG + "\t" + prs2SG + "\t" + prs3SG + "\t" + prs1PL + "\t" + prs2PL + "\t" + prs3PL + "\t" + prät1SG + "\t" + prät2SG + "\t"
				+ prät3SG + "\t" + prät1PL + "\t" + prät2PL + "\t" + prät3PL + "\t" + partI + "\t" + partII + "\t" + impI + "\t" + impII + "\t" + impIII + "\t" + prsID + "\t"
				+ pretID + "\t" + perfID + "\t" + impID + verbTypeTab + verbType + newLine;
		printArrayList.add(row);

//		String[] rowArray = { infinitiveArray.get(i), "", prs1SG, "", prs2SG, "", prs3SG, "", prs1PL, "", prs2PL, "", prs3PL, "", prät1SG, "", prät2SG, "",
//				prät3SG, "", prät1PL, "", prät2PL, "", prät3PL, "", partI, "", partII, "", impI, "", impII, "", impIII};
//		printArray.add(rowArray);
		
		completeText = completeText + row;
	}

	public static void convertPrintArrayToSingelString() {
//		for (int i = 0; i < printArray.size(); i++) {
////			completeText = completeText + printArray.get(i);
//		}
	}

}
