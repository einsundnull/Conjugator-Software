package strings;

import java.util.ArrayList;

import filters.Filters;

public class IrregularVerbs {

//	public static boolean foundIrregularWord;
	public static int irregularVerbsIndex = 0;
	public static ArrayList<String> irregularVerbsArray = new ArrayList<String>();
	public static ArrayList<String> regularVerbsArray = new ArrayList<String>();
	
	public static String[] irregularVerbs;
	public static String[] regularVerbs;

	public static String[] irregularVerbsPräs ;

	public static String[] irregularVerbsPrät ;

	public static String[] irregularVerbsIIPartizip;

	public static String[] irregularVerbsImperativeI ;

	public static String[] irregularVerbsImperativeII ;

	public static String[] irregularVerbsImperativeIII ;
	
	public static String[] irregularVerbs2PSSing;

	public static boolean checkForVerbsFromIrregularList(String[] array, String word) {
		irregularVerbsIndex = 0;
		int searchIndex = 0;
		int lengthOfCurrentWord = 0;
		int lengthOfWordThatHasBeenFoundBefore = 0;
		Filters.verbIsIrregular = false;
		for (String i : array) {
			lengthOfCurrentWord = i.toCharArray().length;
			if (i.equals(word)) {
				if(lengthOfCurrentWord > lengthOfWordThatHasBeenFoundBefore) {
					lengthOfWordThatHasBeenFoundBefore = lengthOfCurrentWord;
					Filters.verbIsIrregular = true;
					irregularVerbsIndex = searchIndex;
					Filters.verbIsRealVerb = true;
				}	
			}
			searchIndex++;
		}
		return false;
	}

	public static boolean checkWhetherLongVerbContainsVerbFromIrregularList(String word) {
		String temp = "";
		char[] array = word.toCharArray();
		Filters.verbIsIrregular = false;
		for (int i = array.length - 1; i >= 0; i--) {
			temp = array[i] + temp;
			IrregularVerbs.checkForVerbsFromIrregularList(IrregularVerbs.irregularVerbs, temp);
		}
		return false;
	}
	
	public static void setCompleteIrregularVerbsFilter() {
		
	}

}
