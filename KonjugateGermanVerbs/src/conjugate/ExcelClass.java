package conjugate;

import static conjugate.ConjugateRegularVerbs.imperative;
import static conjugate.ConjugateRegularVerbs.infWord;
import static conjugate.ConjugateRegularVerbs.partiI;
import static conjugate.ConjugateRegularVerbs.partiII;
import static conjugate.ConjugateRegularVerbs.preSyl;
import static conjugate.ConjugateRegularVerbs.presens;
import static conjugate.ConjugateRegularVerbs.preteritum;
import static conjugate.FixedStrings.PlusquKon;
import static conjugate.FixedStrings.aux;
import static conjugate.FixedStrings.auxFut;
import static conjugate.FixedStrings.auxIPerf;
import static conjugate.FixedStrings.auxIPlQua;
import static conjugate.FixedStrings.auxIndex;
import static conjugate.FixedStrings.caseIndexCase;
import static conjugate.FixedStrings.caseIndexLang;
import static conjugate.FixedStrings.cases;
import static conjugate.FixedStrings.condit;
import static conjugate.FixedStrings.headers;
import static conjugate.FixedStrings.pron;
import static conjugate.FixedStrings.reflFill;
import static conjugate.FixedStrings.reflTab;

import filters.Filters;
import mainWindow.MainWindow;
import strings.LoadedVerbs;

public class ExcelClass {

	public static String excelFilePath;
	public static boolean fileIsTextFile;
	public static boolean fileIsTableFile;

	String em = " ";
	String[] row1;
	String[] row2;
	String[] row3;
	String[] row4;
	String[] row5;
	// Present

	String[] row6;
	String[] row7;
	String[] row8;
	String[] row9;
	String[] row10;
	String[] row11;
	// Perfect & Past Continuous

	String[] row12;
	String[] row13;
	String[] row14;
	String[] row15;
	String[] row16;
	String[] row17;
	String[] row18;
	String[] row19;
	String[] row20;
	// Futur tense I Futur tense II

	String[] row21;
	String[] row22;
	String[] row23;

	String[] row24;
	String[] row25;
	String[] row26;
	String[] row27;
	String[] row28;
	String[] row29;

	// Conditional Past Perfect (Subjunctive)

	String[] row30;
	String[] row31;
	String[] row32;

	String[] row33;
	String[] row34;
	String[] row35;
	String[] row36;
	String[] row37;
	String[] row38;

	String[] row39;
	String[] row40;
	String[] row41;
	String[] row42;
	String[] row43;
	String[] row44;
	String[] row45;

	public void setSimpleInsertToExcelFile() {

		row1 = new String[] { MainWindow.input[1], em, em, infWord, em, em, cases[caseIndexLang][caseIndexCase], em, em, aux[auxIndex], em, em };
		row2 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row3 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row4 = new String[] { headers[caseIndexLang][0], em, em, em, headers[caseIndexLang][1], em, em, em, em, em, em, em, em };
		row5 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em, em };

		// Present

		row6 = new String[] { pron[0], presens.get(0), em, em, pron[0], preteritum.get(0), em, em, em, em, em };
		row7 = new String[] { pron[1], presens.get(1), em, em, pron[1], preteritum.get(1), em, em, em, em, em };
		row8 = new String[] { pron[2], presens.get(2), em, em, pron[2], preteritum.get(2), em, em, em, em, em };
		row9 = new String[] { pron[3], presens.get(3), em, em, pron[3], preteritum.get(3), em, em, em, em, em };
		row10 = new String[] { pron[4], presens.get(4), em, em, pron[4], preteritum.get(4), em, em, em, em, em };
		row11 = new String[] { pron[5], presens.get(5), em, em, pron[5], preteritum.get(5), em, em, em, em, em };

		// Perfect & Past Continuous

		row12 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row13 = new String[] { headers[caseIndexLang][2], em, em, em, headers[caseIndexLang][3], em, em, em, em, em, em, em };
		row14 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row15 = new String[] { pron[0], auxIPerf[auxIndex][0], partiII, em, pron[0], auxIPlQua[auxIndex][0], partiII, em, em, em, em, em };
		row16 = new String[] { pron[1], auxIPerf[auxIndex][1], partiII, em, pron[1], auxIPlQua[auxIndex][1], partiII, em, em, em, em, em };
		row17 = new String[] { pron[2], auxIPerf[auxIndex][2], partiII, em, pron[2], auxIPlQua[auxIndex][2], partiII, em, em, em, em, em };
		row18 = new String[] { pron[3], auxIPerf[auxIndex][3], partiII, em, pron[3], auxIPlQua[auxIndex][3], partiII, em, em, em, em, em };
		row19 = new String[] { pron[4], auxIPerf[auxIndex][4], partiII, em, pron[4], auxIPlQua[auxIndex][4], partiII, em, em, em, em, em };
		row20 = new String[] { pron[5], auxIPerf[auxIndex][5], partiII, em, pron[5], auxIPlQua[auxIndex][5], partiII, em, em, em, em, em };

		// Futur tense I Futur tense II

		row21 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row22 = new String[] { headers[caseIndexLang][4], em, em, em, headers[caseIndexLang][5], em, em, em, em, em, em, em };
		row23 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row24 = new String[] { pron[0], auxFut[0], infWord, em, pron[0], auxFut[0], partiII, aux[auxIndex], em, em, em, em };
		row25 = new String[] { pron[1], auxFut[1], infWord, em, pron[1], auxFut[1], partiII, aux[auxIndex], em, em, em, em };
		row26 = new String[] { pron[2], auxFut[2], infWord, em, pron[2], auxFut[2], partiII, aux[auxIndex], em, em, em, em };
		row27 = new String[] { pron[3], auxFut[3], infWord, em, pron[3], auxFut[3], partiII, aux[auxIndex], em, em, em, em };
		row28 = new String[] { pron[4], auxFut[4], infWord, em, pron[4], auxFut[4], partiII, aux[auxIndex], em, em, em, em };
		row29 = new String[] { pron[5], auxFut[5], infWord, em, pron[5], auxFut[5], partiII, aux[auxIndex], em, em, em, em };

		// Conditional Past Perfect (Subjunctive)

		row30 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row31 = new String[] { headers[caseIndexLang][6], em, em, em, headers[caseIndexLang][7], em, em, em, em, em };
		row32 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row33 = new String[] { pron[0], condit[0], infWord, em, pron[0], PlusquKon[auxIndex][0], partiII, em, em, em, em, em };
		row34 = new String[] { pron[1], condit[1], infWord, em, pron[1], PlusquKon[auxIndex][1], partiII, em, em, em, em, em };
		row35 = new String[] { pron[2], condit[2], infWord, em, pron[2], PlusquKon[auxIndex][2], partiII, em, em, em, em, em };
		row36 = new String[] { pron[3], condit[3], infWord, em, pron[3], PlusquKon[auxIndex][3], partiII, em, em, em, em, em };
		row37 = new String[] { pron[4], condit[4], infWord, em, pron[4], PlusquKon[auxIndex][4], partiII, em, em, em, em, em };
		row38 = new String[] { pron[5], condit[5], infWord, em, pron[5], PlusquKon[auxIndex][5], partiII, em, em, em, em, em };

		row39 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row40 = new String[] { headers[caseIndexLang][8], em, em, em, headers[caseIndexLang][9], em, headers[caseIndexLang][10], em, em, em, em, em, em };
		row41 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row42 = new String[] { imperative.get(0), em, em, em, partiI, em, partiII, em, em, em, em, em, em, em };
		row43 = new String[] { imperative.get(1), em, em, em, em, em, em, em, em, em, em, em, em, em };
		row44 = new String[] { imperative.get(2) + " " + "Sie", em, em, em, em, em, em, em, em, em, em, em, em };
		row45 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
	}

	public void setSeparableInsertToExcelFile() {
//		System.out.println("Method is setSpearableInsertToExcelFile()");

		row1 = new String[] { MainWindow.input[1], em, preSyl + infWord, em, em, cases[caseIndexLang][caseIndexCase], em, aux[auxIndex], em, em, em, em, em };
		row2 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em, em };
		row3 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em, em };
		row4 = new String[] { headers[caseIndexLang][0], em, em, em, headers[caseIndexLang][1], em, em, em, em, em, em, em, em };
		row5 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		// Present

		row6 = new String[] { pron[0], presens.get(0), preSyl, em, pron[0], preteritum.get(0), preSyl, em, em, em, em, em, em };
		row7 = new String[] { pron[1], presens.get(1), preSyl, em, pron[1], preteritum.get(1), preSyl, em, em, em, em, em, em };
		row8 = new String[] { pron[2], presens.get(2), preSyl, em, pron[2], preteritum.get(2), preSyl, em, em, em, em, em, em };
		row9 = new String[] { pron[3], presens.get(3), preSyl, em, pron[3], preteritum.get(3), preSyl, em, em, em, em, em, em };
		row10 = new String[] { pron[4], presens.get(4), preSyl, em, pron[4], preteritum.get(4), preSyl, em, em, em, em, em, em };
		row11 = new String[] { pron[5], presens.get(5), preSyl, em, pron[5], preteritum.get(5), preSyl, em, em, em, em, em, em };

		// Perfect & Past Continuous

		row12 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row13 = new String[] { headers[caseIndexLang][2], em, em, em, headers[caseIndexLang][3], em, em, em, em, em, em, em, em };
		row14 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row15 = new String[] { pron[0], auxIPerf[auxIndex][0], partiII, em, pron[0], auxIPlQua[auxIndex][0], partiII, em, em, em, em, em };
		row16 = new String[] { pron[1], auxIPerf[auxIndex][1], partiII, em, pron[1], auxIPlQua[auxIndex][1], partiII, em, em, em, em, em };
		row17 = new String[] { pron[2], auxIPerf[auxIndex][2], partiII, em, pron[2], auxIPlQua[auxIndex][2], partiII, em, em, em, em, em };
		row18 = new String[] { pron[3], auxIPerf[auxIndex][3], partiII, em, pron[3], auxIPlQua[auxIndex][3], partiII, em, em, em, em, em };
		row19 = new String[] { pron[4], auxIPerf[auxIndex][4], partiII, em, pron[4], auxIPlQua[auxIndex][4], partiII, em, em, em, em, em };
		row20 = new String[] { pron[5], auxIPerf[auxIndex][5], partiII, em, pron[5], auxIPlQua[auxIndex][5], partiII, em, em, em, em, em };

		// Futur tense I Futur tense II

		row21 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row22 = new String[] { headers[caseIndexLang][4], em, em, em, headers[caseIndexLang][5], em, em, em, em, em, em, em, em };
		row23 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em };

		row24 = new String[] { pron[0], auxFut[0], preSyl + infWord, em, pron[0], auxFut[0], partiII, aux[auxIndex], em, em, em, em };
		row25 = new String[] { pron[1], auxFut[1], preSyl + infWord, em, pron[1], auxFut[1], partiII, aux[auxIndex], em, em, em, em };
		row26 = new String[] { pron[2], auxFut[2], preSyl + infWord, em, pron[2], auxFut[2], partiII, aux[auxIndex], em, em, em, em };
		row27 = new String[] { pron[3], auxFut[3], preSyl + infWord, em, pron[3], auxFut[3], partiII, aux[auxIndex], em, em, em, em };
		row28 = new String[] { pron[4], auxFut[4], preSyl + infWord, em, pron[4], auxFut[4], partiII, aux[auxIndex], em, em, em, em };
		row29 = new String[] { pron[5], auxFut[5], preSyl + infWord, em, pron[5], auxFut[5], partiII, aux[auxIndex], em, em, em, em };

		// Conditional Past Perfect (Subjunctive)

		row30 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row31 = new String[] { headers[caseIndexLang][6], em, em, em, headers[caseIndexLang][7], em, em, em, em, em, em, em, em };
		row32 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row33 = new String[] { pron[0], condit[0], preSyl + infWord, em, pron[0], PlusquKon[auxIndex][0], partiII, em, em, em, em, em, em };
		row34 = new String[] { pron[1], condit[1], preSyl + infWord, em, pron[1], PlusquKon[auxIndex][1], partiII, em, em, em, em, em, em };
		row35 = new String[] { pron[2], condit[2], preSyl + infWord, em, pron[2], PlusquKon[auxIndex][2], partiII, em, em, em, em, em, em };
		row36 = new String[] { pron[3], condit[3], preSyl + infWord, em, pron[3], PlusquKon[auxIndex][3], partiII, em, em, em, em, em, em };
		row37 = new String[] { pron[4], condit[4], preSyl + infWord, em, pron[4], PlusquKon[auxIndex][4], partiII, em, em, em, em, em, em };
		row38 = new String[] { pron[5], condit[5], preSyl + infWord, em, pron[5], PlusquKon[auxIndex][5], partiII, em, em, em, em, em, em };

		row39 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row40 = new String[] { headers[caseIndexLang][8], em, em, em, headers[caseIndexLang][9], em, headers[caseIndexLang][10], em, em, em, em, em, em, em };
		row41 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row42 = new String[] { imperative.get(0) + " " + preSyl, em, em, em, partiI, em, partiII, em, em, em, em, em, em };
		row43 = new String[] { imperative.get(1) + " " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row44 = new String[] { imperative.get(2) + " Sie " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row45 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
	}

	public void setSeparableReflexiveInsertToExcelFile() {
//		System.out.println("Method is setSpearableInsertToExcelFile()");

		row1 = new String[] { MainWindow.input[1], em, em, reflFill[2] + " " + preSyl + infWord, em, em, cases[caseIndexLang][caseIndexCase], em, em, aux[auxIndex], em, em, em,
				em };
		row2 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row3 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row4 = new String[] { headers[caseIndexLang][0], em, em, em, em, reflTab, headers[caseIndexLang][1], em, em, em, em };
		row5 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		// Present

		row6 = new String[] { pron[0], presens.get(0), reflFill[0], preSyl, em, pron[0], preteritum.get(0), reflFill[0], preSyl, em, em, em, em };
		row7 = new String[] { pron[1], presens.get(1), reflFill[1], preSyl, em, pron[1], preteritum.get(1), reflFill[1], preSyl, em, em, em, em };
		row8 = new String[] { pron[2], presens.get(2), reflFill[2], preSyl, em, pron[2], preteritum.get(2), reflFill[2], preSyl, em, em, em, em };
		row9 = new String[] { pron[3], presens.get(3), reflFill[3], preSyl, em, pron[3], preteritum.get(3), reflFill[3], preSyl, em, em, em, em };
		row10 = new String[] { pron[4], presens.get(4), reflFill[4], preSyl, em, pron[4], preteritum.get(4), reflFill[4], preSyl, em, em, em, em };
		row11 = new String[] { pron[5], presens.get(5), reflFill[5], preSyl, em, pron[5], preteritum.get(5), reflFill[5], preSyl, em, em, em, em };

		// Perfect & Past Continuous

		row12 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row13 = new String[] { headers[caseIndexLang][2], em, em, em, em, headers[caseIndexLang][3], em, em, em, em };
		row14 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row15 = new String[] { pron[0], auxIPerf[auxIndex][0], reflFill[0], partiII, em, pron[0], auxIPlQua[auxIndex][0], reflFill[0], partiII, em, em, em, em };
		row16 = new String[] { pron[1], auxIPerf[auxIndex][1], reflFill[1], partiII, em, pron[1], auxIPlQua[auxIndex][1], reflFill[1], partiII, em, em, em, em };
		row17 = new String[] { pron[2], auxIPerf[auxIndex][2], reflFill[2], partiII, em, pron[2], auxIPlQua[auxIndex][2], reflFill[2], partiII, em, em, em, em };
		row18 = new String[] { pron[3], auxIPerf[auxIndex][3], reflFill[3], partiII, em, pron[3], auxIPlQua[auxIndex][3], reflFill[3], partiII, em, em, em, em };
		row19 = new String[] { pron[4], auxIPerf[auxIndex][4], reflFill[4], partiII, em, pron[4], auxIPlQua[auxIndex][4], reflFill[4], partiII, em, em, em, em };
		row20 = new String[] { pron[5], auxIPerf[auxIndex][5], reflFill[5], partiII, em, pron[5], auxIPlQua[auxIndex][5], reflFill[5], partiII, em, em, em, em };

		// Futur tense I Futur tense II

		row21 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row22 = new String[] { headers[caseIndexLang][4], em, em, em, em, headers[caseIndexLang][5], em, em, em, em };
		row23 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row24 = new String[] { pron[0], auxFut[0], reflFill[0], preSyl + infWord, em, pron[0], auxFut[0], reflFill[0], partiII, aux[auxIndex], em, em, em, em };
		row25 = new String[] { pron[1], auxFut[1], reflFill[1], preSyl + infWord, em, pron[1], auxFut[1], reflFill[1], partiII, aux[auxIndex], em, em, em, em };
		row26 = new String[] { pron[2], auxFut[2], reflFill[2], preSyl + infWord, em, pron[2], auxFut[2], reflFill[2], partiII, aux[auxIndex], em, em, em, em };
		row27 = new String[] { pron[3], auxFut[3], reflFill[3], preSyl + infWord, em, pron[3], auxFut[3], reflFill[3], partiII, aux[auxIndex], em, em, em, em };
		row28 = new String[] { pron[4], auxFut[4], reflFill[4], preSyl + infWord, em, pron[4], auxFut[4], reflFill[4], partiII, aux[auxIndex], em, em, em, em };
		row29 = new String[] { pron[5], auxFut[5], reflFill[5], preSyl + infWord, em, pron[5], auxFut[5], reflFill[5], partiII, aux[auxIndex], em, em, em, em };

		// Conditional Past Perfect (Subjunctive)

		row30 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row31 = new String[] { headers[caseIndexLang][6], em, em, em, em, headers[caseIndexLang][7], em, em, em, em };
		row32 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row33 = new String[] { pron[0], condit[0], reflFill[0], preSyl + infWord, em, pron[0], PlusquKon[auxIndex][0], reflFill[0], partiII, em, em, em, em };
		row34 = new String[] { pron[1], condit[1], reflFill[1], preSyl + infWord, em, pron[1], PlusquKon[auxIndex][1], reflFill[1], partiII, em, em, em, em };
		row35 = new String[] { pron[2], condit[2], reflFill[2], preSyl + infWord, em, pron[2], PlusquKon[auxIndex][2], reflFill[2], partiII, em, em, em, em };
		row36 = new String[] { pron[3], condit[3], reflFill[3], preSyl + infWord, em, pron[3], PlusquKon[auxIndex][3], reflFill[3], partiII, em, em, em, em };
		row37 = new String[] { pron[4], condit[4], reflFill[4], preSyl + infWord, em, pron[4], PlusquKon[auxIndex][4], reflFill[4], partiII, em, em, em, em };
		row38 = new String[] { pron[5], condit[5], reflFill[5], preSyl + infWord, em, pron[5], PlusquKon[auxIndex][5], reflFill[5], partiII, em, em, em, em };

		row39 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row40 = new String[] { headers[caseIndexLang][8], em, em, em, em, headers[caseIndexLang][9], em, em, headers[caseIndexLang][10], em, em, em, em };
		row41 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row42 = new String[] { imperative.get(0) + " " + reflFill[1] + " " + preSyl, em, em, em, em, partiI, em, em, partiII, em, em, em, em };
		row43 = new String[] { imperative.get(1) + " " + reflFill[4] + " " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row44 = new String[] { imperative.get(2) + " Sie " + reflFill[5] + " " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row45 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
	}

	public void setReflexiveInsertToExcelFile() {
		row1 = new String[] { MainWindow.input[1], em, em, reflFill[2] + " " + infWord, em, em, cases[caseIndexLang][caseIndexCase], em, em, aux[auxIndex], em, em, em, em };

		row2 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row3 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row4 = new String[] { headers[caseIndexLang][0], em, em, em, em, headers[caseIndexLang][1], em, em, em, em, em, em, em };
		row5 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		// Present

		row6 = new String[] { pron[0], presens.get(0), reflFill[0], preSyl, em, pron[0], preteritum.get(0), reflFill[0], preSyl, em, em, em, em };
		row7 = new String[] { pron[1], presens.get(1), reflFill[1], preSyl, em, pron[1], preteritum.get(1), reflFill[1], preSyl, em, em, em, em };
		row8 = new String[] { pron[2], presens.get(2), reflFill[2], preSyl, em, pron[2], preteritum.get(2), reflFill[2], preSyl, em, em, em, em };
		row9 = new String[] { pron[3], presens.get(3), reflFill[3], preSyl, em, pron[3], preteritum.get(3), reflFill[3], preSyl, em, em, em, em };
		row10 = new String[] { pron[4], presens.get(4), reflFill[4], preSyl, em, pron[4], preteritum.get(4), reflFill[4], preSyl, em, em, em, em };
		row11 = new String[] { pron[5], presens.get(5), reflFill[5], preSyl, em, pron[5], preteritum.get(5), reflFill[5], preSyl, em, em, em, em };

		// Perfect & Past Continuous

		row12 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row13 = new String[] { headers[caseIndexLang][2], em, em, em, em, headers[caseIndexLang][3], em, em, em, em };
		row14 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row15 = new String[] { pron[0], auxIPerf[auxIndex][0], reflFill[0], partiII, em, pron[0], auxIPlQua[auxIndex][0], reflFill[0], partiII };
		row16 = new String[] { pron[1], auxIPerf[auxIndex][1], reflFill[1], partiII, em, pron[1], auxIPlQua[auxIndex][1], reflFill[1], partiII };
		row17 = new String[] { pron[2], auxIPerf[auxIndex][2], reflFill[2], partiII, em, pron[2], auxIPlQua[auxIndex][2], reflFill[2], partiII };
		row18 = new String[] { pron[3], auxIPerf[auxIndex][3], reflFill[3], partiII, em, pron[3], auxIPlQua[auxIndex][3], reflFill[3], partiII };
		row19 = new String[] { pron[4], auxIPerf[auxIndex][4], reflFill[4], partiII, em, pron[4], auxIPlQua[auxIndex][4], reflFill[4], partiII };
		row20 = new String[] { pron[5], auxIPerf[auxIndex][5], reflFill[5], partiII, em, pron[5], auxIPlQua[auxIndex][5], reflFill[5], partiII };

		// Futur tense I Futur tense II

		row21 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row22 = new String[] { headers[caseIndexLang][4], em, em, em, em, headers[caseIndexLang][5], em, em, em, em };
		row23 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row24 = new String[] { pron[0], auxFut[0], reflFill[0], infWord, em, pron[0], auxFut[0], reflFill[0], partiII, aux[auxIndex] };
		row25 = new String[] { pron[1], auxFut[1], reflFill[1], infWord, em, pron[1], auxFut[1], reflFill[1], partiII, aux[auxIndex] };
		row26 = new String[] { pron[2], auxFut[2], reflFill[2], infWord, em, pron[2], auxFut[2], reflFill[2], partiII, aux[auxIndex] };
		row27 = new String[] { pron[3], auxFut[3], reflFill[3], infWord, em, pron[3], auxFut[3], reflFill[3], partiII, aux[auxIndex] };
		row28 = new String[] { pron[4], auxFut[4], reflFill[4], infWord, em, pron[4], auxFut[4], reflFill[4], partiII, aux[auxIndex] };
		row29 = new String[] { pron[5], auxFut[5], reflFill[5], infWord, em, pron[5], auxFut[5], reflFill[5], partiII, aux[auxIndex] };

		// Conditional Past Perfect (Subjunctive)

		row30 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row31 = new String[] { headers[caseIndexLang][6], em, em, em, em, headers[caseIndexLang][7], em, em, em, em };
		row32 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };

		row33 = new String[] { pron[0], condit[0], reflFill[0], infWord, em, pron[0], PlusquKon[auxIndex][0], reflFill[0], partiII, em, em, em, em, em };
		row34 = new String[] { pron[1], condit[1], reflFill[1], infWord, em, pron[1], PlusquKon[auxIndex][1], reflFill[1], partiII, em, em, em, em, em };
		row35 = new String[] { pron[2], condit[2], reflFill[2], infWord, em, pron[2], PlusquKon[auxIndex][2], reflFill[2], partiII, em, em, em, em, em };
		row36 = new String[] { pron[3], condit[3], reflFill[3], infWord, em, pron[3], PlusquKon[auxIndex][3], reflFill[3], partiII, em, em, em, em, em };
		row37 = new String[] { pron[4], condit[4], reflFill[4], infWord, em, pron[4], PlusquKon[auxIndex][4], reflFill[4], partiII, em, em, em, em, em };
		row38 = new String[] { pron[5], condit[5], reflFill[5], infWord, em, pron[5], PlusquKon[auxIndex][5], reflFill[5], partiII, em, em, em, em, em };

		row39 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row40 = new String[] { headers[caseIndexLang][8], em, em, em, em, headers[caseIndexLang][9], em, em, headers[caseIndexLang][10], em, em, em, em };
		row41 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em };
		row42 = new String[] { imperative.get(0) + " " + reflFill[1] + " " + preSyl, em, em, em, em, partiI, em, em, partiII, em, em, em, em };
		row43 = new String[] { imperative.get(1) + " " + reflFill[4] + " " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row44 = new String[] { imperative.get(2) + " Sie " + reflFill[2] + " " + preSyl, em, em, em, em, em, em, em, em, em, em, em, em };
		row45 = new String[] { em, em, em, em, em, em, em, em, em, em, em, em, em, em };
	}

	public void setStringArrayForExcelTable() {
		LoadedVerbs.printArray.clear();
		LoadedVerbs.printArray.add(row1);
		LoadedVerbs.printArray.add(row2);
		LoadedVerbs.printArray.add(row3);
		LoadedVerbs.printArray.add(row4);
		LoadedVerbs.printArray.add(row5);
		LoadedVerbs.printArray.add(row6);
		LoadedVerbs.printArray.add(row7);
		LoadedVerbs.printArray.add(row8);
		LoadedVerbs.printArray.add(row9);
		LoadedVerbs.printArray.add(row10);
		LoadedVerbs.printArray.add(row11);
		LoadedVerbs.printArray.add(row12);
		LoadedVerbs.printArray.add(row13);
		LoadedVerbs.printArray.add(row14);
		LoadedVerbs.printArray.add(row15);
		LoadedVerbs.printArray.add(row16);
		LoadedVerbs.printArray.add(row17);
		LoadedVerbs.printArray.add(row18);
		LoadedVerbs.printArray.add(row19);
		LoadedVerbs.printArray.add(row20);
		LoadedVerbs.printArray.add(row21);
		LoadedVerbs.printArray.add(row22);
		LoadedVerbs.printArray.add(row23);
		LoadedVerbs.printArray.add(row24);
		LoadedVerbs.printArray.add(row25);
		LoadedVerbs.printArray.add(row26);
		LoadedVerbs.printArray.add(row27);
		LoadedVerbs.printArray.add(row28);
		LoadedVerbs.printArray.add(row29);
		LoadedVerbs.printArray.add(row30);
		LoadedVerbs.printArray.add(row31);
		LoadedVerbs.printArray.add(row32);
		LoadedVerbs.printArray.add(row33);
		LoadedVerbs.printArray.add(row34);
		LoadedVerbs.printArray.add(row35);
		LoadedVerbs.printArray.add(row36);
		LoadedVerbs.printArray.add(row37);
		LoadedVerbs.printArray.add(row38);
		LoadedVerbs.printArray.add(row39);
		LoadedVerbs.printArray.add(row40);
		LoadedVerbs.printArray.add(row41);
		LoadedVerbs.printArray.add(row42);
		LoadedVerbs.printArray.add(row43);
		LoadedVerbs.printArray.add(row44);
		LoadedVerbs.printArray.add(row45);
	}

	public void chooseRightTabel() {
		WriteExcelFile.substractor = 5;
		WriteExcelFile.whiteColumnIndex = 3;
		if (!MainWindow.verbIsReflexive && Filters.foundSeparableSylable) {
//			System.err.println("ExcelClass 410 I");
			setSeparableInsertToExcelFile();
		} else if (MainWindow.verbIsReflexive && !Filters.foundSeparableSylable) {
//			System.err.println("ExcelClass 410 II");
			WriteExcelFile.whiteColumnIndex = 4;
			setReflexiveInsertToExcelFile();
		} else if (MainWindow.verbIsReflexive && Filters.foundSeparableSylable) {
//			System.err.println("ExcelClass 410 III");
			WriteExcelFile.whiteColumnIndex = 4;
			setSeparableReflexiveInsertToExcelFile();
		} else if (!MainWindow.verbIsReflexive && !Filters.foundSeparableSylable) {
//			System.err.println("ExcelClass 410 IV");
//			WriteExcelFile.substractor = 3;
			WriteExcelFile.substractor = 4;
			setSimpleInsertToExcelFile();
		}
	}

	public static void setExcelFilePathForTable() {
		excelFilePath = "";
		if (!MainWindow.verbIsReflexive && Filters.foundSeparableSylable) {
			excelFilePath = ".\\src\\shemes\\VerbSchemaSep.xlsx";
		} else if (MainWindow.verbIsReflexive && !Filters.foundSeparableSylable) {
			excelFilePath = ".\\src\\shemes\\VerbSchemaRefSep.xlsx";
		} else if (MainWindow.verbIsReflexive && Filters.foundSeparableSylable) {
			excelFilePath = ".\\src\\shemes\\VerbSchemaRefSep.xlsx";
		} else if (!MainWindow.verbIsReflexive && !Filters.foundSeparableSylable) {
			excelFilePath = ".\\src\\shemes\\VerbSchemaSimple.xlsx";
		}
	}
}
