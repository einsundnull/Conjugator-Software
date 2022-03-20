package conjugate;

import static conjugate.ConjugateRegularVerbs.imperative;
import static conjugate.ConjugateRegularVerbs.infWord;
import static conjugate.ConjugateRegularVerbs.partiI;
import static conjugate.ConjugateRegularVerbs.partiII;
import static conjugate.ConjugateRegularVerbs.preSyl;
import static conjugate.ConjugateRegularVerbs.presens;
import static conjugate.ConjugateRegularVerbs.preteritum;

import java.awt.datatransfer.StringSelection;

import mainWindow.MainWindow;

public class FixedStrings {

	public static String t = "\t";
	public static String n = "\n";
	public static int caseIndexLang = 1; // Akkusative / Dative
	public static int caseIndexCase = 0; // Headers in different Languages
	public static int auxIndex = 0; // haben sein
	public static int auxConjugationIndex = 0;
	public static String reflTab = " ";
	public static String reflSpace = " ";
	public static String nonRefSpace = " ";
	public static String nonreflTab = t;

	public static String completeText;

	public static String[][] cases = new String[][] { {"", "Akkusativ", "Dativ", "Dativ/Akkusativ" }, { "","Accusative", "Dative", "Dative/Accusative" },{ "","Винительный", "Дательный", "Дательный/Винительный" }, { "", "აკუზატივი", "დატივი", "დატივი/აკუზატივი" } };

	public static String[][] headers = new String[][] {
			{ "Gegenwart", "Präteritum", "Perfekt", "Plusquamperfekt", "Futur I", "Futur II", "Konjunktiv", "Perfekt (Konjunktiv)", "Imperativ", "Partizip I", "Partizip Perfekt" },

			{ "Present", "Past Tense", "Perfect", "Past Continuous", "Future Tense I", "Future Tense II", "Conditional", "Past Perfect (subjunctive)", "Imperative", "Participle I",
					"Past Participle" },

			{ "Настоящее", "Прошедшее", "Совершенное", "Прошедшее непрерывное", "Будущее I", "Будущее II", "Условное", "Прошедшее совершенное",
					"Императив", "Причастие I", "Причастие II" },

			{ "აწმყო", "Წარსული დრო", "სრულყოფილი", "Წარსული განგრძობითი", "მომავალი დრო I", "მომავალი დრო II", "პირობითი", "წარსული სრულყოფილი", "იმპერატივი",
					"მონაწილე I", "წარსული მონაწილე" }, };

	public static String[][] uiText = new String[][] {
			{ "Deutsches Verb", "Übersetzung", "Welchen Fall verlangt das Verb?", "Akkusativ", "Dativ", "Dativ/Akkusativ", "Ist das Verb reflexiv?", "Reflexive (sich)",
					"Wie wird die Vergangenheit gebildet?", "mit haben", "mit sein", "Welche Sprache sprechen Sie?", "Datei speichern als", "PDF (*.pdf)", "Excel (*.xlsx)",
					"Text (*.txt)", "Dateiname", "Deutsch zuerst", "Übersetzung zuerst", "Starte Konjugation" },

			{ "German verb", "translation", "Which case does the verb require?", "Accusative", "Dative", "Dative/Accusative", "Is the verb reflexive?", "reflexive (sich)",
					"How is the past formed?", "with to have/haben", "with to be/sein", "What language do you speak?", "Save file as", "PDF (*.pdf)", "Excel (*.xlsx)",
					"Text (*.txt)", "File name", "German first", "translation first", "Start conjugation" },

			{ "немецкий глагол", "перевод", "Какой падеж нужен глаголу?", "Винительный", "дательный", "Дательный/Винительный", "Является ли глагол возвратным?",
					"отражающий (sich)", "Как формируется прошлое?", "с иметь/haben", "с быть/sein", "На каком языке Вы говорите?", "Сохранить файл как", "ПДФ (*.pdf)",
					"Эксель (*.xlsx)", "Текст (*.txt)", "имя файла", "немецкий первый", "перевод первый", "Начать спряжение" },

			{ "გერმანული ზმნა", "თარგმანი", "რომელ შემთხვევას მოითხოვს ზმნა?", "ბრალდებული", "დატივი", "დატივი/აკუზატივი", "არის ზმნა რეფლექსური?", "ამრეკლავი (sich)",
					"როგორ ყალიბდება წარსული?", "ქონასთან ერთად/haben", "ერთად იყოს/sein", "რა ენაზე ლაპარაკობ?", "ფაილის შენახვა როგორც", "პდფ (*.pdf)", "ექსელი (*.xlsx)",
					"ტექსტი (*.txt)", "ფაილის სახელი", "ჯერ გერმანული", "ჯერ თარგმანი", "დაიწყეთ კონიუგაცია" } };

	public static String[][] auxIPerf = new String[][] { { "habe", "hast", "hat", "haben", "habt", "haben" }, { "bin", "bist", "ist", "sind", "seid", "sind" } };

	public static String[][] auxIPlQua = new String[][] { { "hatte", "hattest", "hatte", "hatten", "hattet", "hatten" }, { "war", "warst", "war", "waren", "wart", "waren" } };

	static String[] aux = new String[] { "haben", "sein" };

	static final String[] reflFillEMPTY = new String[] { "", "", "", "", "", "" };
	static String[] reflFill = new String[] { "", "", "", "", "", "" };
	static String[] pron = new String[] { "Ich", "Du", "Er/Sie/Es", "Wir", "Ihr", "Sie/sie" };
	static String[] pronounsReflexDat = new String[] { "mir", "dir", "sich", "uns", "euch", "sich" };
	public static String[] pronounsReflexAkk = new String[] { "mich", "dich", "sich", "uns", "euch", "sich" };
	static String[] auxFut = new String[] { "werde", "wirst", "wird", "werden", "werdet", "werden" };
	static String[] passiv = new String[] { "wurde", "wurdest", "wurde", "wurden", "wurdet", "wurden" };
	static String[] condit = new String[] { "würde", "würdest", "würde", "würden", "würdet", "würden" };
	static String[][] PlusquKon = new String[][] { { "hätte", "hättest", "hätte", "hätten", "hättet", "hätten" }, { "wäre", "wärst", "wäre", "wären", "wärt", "wären" } };
	public static String wordStemTowSG;
	public static String wordStemPrät;
	public static String wordStemPerf;
	public static String wordStemPartII;


	String partizipI = pron[5] + reflSpace + reflFill[0] + reflSpace + nonRefSpace + preSyl;

	String[] konjugPresens = { pron[0] + t + presens.get(0) + t + reflFill[0] + reflTab + preSyl, pron[1] + t + presens.get(1) + t + reflFill[1] + reflTab + preSyl,
			pron[2] + t + presens.get(2) + t + reflFill[2] + reflTab + preSyl, pron[3] + t + presens.get(3) + t + reflFill[3] + reflTab + preSyl,
			pron[4] + t + presens.get(4) + t + reflFill[4] + reflTab + preSyl, pron[5] + t + presens.get(5) + t + reflFill[5] + reflTab + preSyl };

	String[] konjugPreteritum = { pron[0] + t + preteritum.get(0) + t + reflFill[0] + reflTab + preSyl, pron[1] + t + preteritum.get(1) + t + reflFill[1] + reflTab + preSyl,
			pron[2] + t + preteritum.get(2) + t + reflFill[2] + reflTab + preSyl, pron[3] + t + preteritum.get(3) + t + reflFill[3] + reflTab + preSyl,
			pron[4] + t + preteritum.get(4) + t + reflFill[4] + reflTab + preSyl, pron[5] + t + preteritum.get(5) + t + reflFill[5] + reflTab + preSyl };

	String[] konjugPerfect = { pron[0] + t + auxIPerf[auxIndex][0] + t + reflFill[0] + reflTab + partiII, pron[1] + t + auxIPerf[auxIndex][1] + t + reflFill[1] + reflTab + partiII,
			pron[2] + t + auxIPerf[auxIndex][2] + t + reflFill[2] + reflTab + partiII, pron[3] + t + auxIPerf[auxIndex][3] + t + reflFill[3] + reflTab + partiII,
			pron[4] + t + auxIPerf[auxIndex][4] + t + reflFill[4] + reflTab + partiII, pron[5] + t + auxIPerf[auxIndex][5] + t + reflFill[5] + reflTab + partiII };

	String[] konjugPlusQuamp = { pron[0] + t + auxIPlQua[auxIndex][0] + t + reflFill[0] + reflTab + partiII,
			pron[1] + t + auxIPlQua[auxIndex][1] + t + reflFill[1] + reflTab + partiII, pron[2] + t + auxIPlQua[auxIndex][2] + t + reflFill[2] + reflTab + partiII,
			pron[3] + t + auxIPlQua[auxIndex][3] + t + reflFill[3] + reflTab + partiII, pron[4] + t + auxIPlQua[auxIndex][4] + t + reflFill[4] + reflTab + partiII,
			pron[5] + t + auxIPlQua[auxIndex][5] + t + reflFill[5] + reflTab + partiII };

	String[] konjugFutI = { pron[0] + t + auxFut[0] + t + reflFill[0] + reflTab + preSyl + infWord, pron[1] + t + auxFut[1] + t + reflFill[1] + reflTab + preSyl + infWord,
			pron[2] + t + auxFut[2] + t + reflFill[2] + reflTab + preSyl + infWord, pron[3] + t + auxFut[3] + t + reflFill[3] + reflTab + preSyl + infWord,
			pron[4] + t + auxFut[4] + t + reflFill[4] + reflTab + preSyl + infWord, pron[5] + t + auxFut[5] + t + reflFill[5] + reflTab + preSyl + infWord };

	String[] konjugFutII = { pron[0] + t + auxFut[0] + t + reflFill[0] + reflTab + partiII + t + aux[auxIndex],
			pron[1] + t + auxFut[1] + t + reflFill[1] + reflTab + partiII + t + aux[auxIndex], pron[2] + t + auxFut[2] + t + reflFill[2] + reflTab + partiII + t + aux[auxIndex],
			pron[3] + t + auxFut[3] + t + reflFill[3] + reflTab + partiII + t + aux[auxIndex], pron[4] + t + auxFut[4] + t + reflFill[4] + reflTab + partiII + t + aux[auxIndex],
			pron[5] + t + auxFut[5] + t + reflFill[5] + reflTab + partiII + t + aux[auxIndex], };

	String[] konjugConditional = { pron[0] + t + condit[0] + t + reflFill[0] + reflTab + preSyl + infWord, pron[1] + t + condit[1] + t + reflFill[1] + reflTab + preSyl + infWord,
			pron[2] + t + condit[2] + t + reflFill[2] + reflTab + preSyl + infWord, pron[3] + t + condit[3] + t + reflFill[3] + reflTab + preSyl + infWord,
			pron[4] + t + condit[4] + t + reflFill[4] + reflTab + preSyl + infWord, pron[5] + t + condit[5] + t + reflFill[5] + reflTab + preSyl + infWord };

	String[] konjugPastPerfect = { pron[0] + t + PlusquKon[auxIndex][0] + t + reflFill[0] + reflTab + partiII,
			pron[1] + t + PlusquKon[auxIndex][1] + t + reflFill[1] + reflTab + partiII, pron[2] + t + PlusquKon[auxIndex][2] + t + reflFill[2] + reflTab + partiII,
			pron[3] + t + PlusquKon[auxIndex][3] + t + reflFill[3] + reflTab + partiII, pron[4] + t + PlusquKon[auxIndex][4] + t + reflFill[4] + reflTab + partiII,
			pron[5] + t + PlusquKon[auxIndex][5] + t + reflFill[5] + reflTab + partiII };

	String[] konjugImperative = { imperative.get(0) + reflSpace + reflFill[1] + reflSpace + nonRefSpace + preSyl,
			imperative.get(1) + reflSpace + reflFill[4] + reflSpace + nonRefSpace + preSyl,
			imperative.get(2) + " " + "Sie" + reflSpace + reflFill[2] + reflSpace + nonRefSpace + preSyl

	};

	String[] row1 = new String[] { MainWindow.input[1], t, t, preSyl + ConjugateRegularVerbs.infWord, t, t, cases[caseIndexLang][caseIndexCase], t, t, aux[auxIndex], n };

	String[] row2 = new String[] { n };
	String[] row3 = new String[] { n };
	String[] row4 = new String[] { headers[caseIndexLang][0], t, t, t, t, reflTab, headers[caseIndexLang][1], n };
	String[] row5 = new String[] { n };

	// Present

	String[] row6 = new String[] { konjugPresens[0], reflTab, t, nonreflTab, konjugPreteritum[0], n };
	String[] row7 = new String[] { konjugPresens[1], reflTab, t, nonreflTab, konjugPreteritum[1], n };
	String[] row8 = new String[] { konjugPresens[2], reflTab, t, nonreflTab, konjugPreteritum[2], n };
	String[] row9 = new String[] { konjugPresens[3], reflTab, t, nonreflTab, konjugPreteritum[3], n };
	String[] row10 = new String[] { konjugPresens[4], reflTab, t, nonreflTab, konjugPreteritum[4], n };
	String[] row11 = new String[] { konjugPresens[5], reflTab, t, nonreflTab, konjugPreteritum[5], n };

	// Perfect & Past Continuous

	String[] row12 = new String[] { n };
	String[] row13 = new String[] { headers[caseIndexLang][2], t, t, t, t, reflTab, headers[caseIndexLang][3], n };
	String[] row14 = new String[] { n };

	String[] row15 = new String[] { konjugPerfect[0], reflTab, t, nonreflTab, konjugPlusQuamp[0], n };
	String[] row16 = new String[] { konjugPerfect[1], reflTab, t, nonreflTab, konjugPlusQuamp[1], n };
	String[] row17 = new String[] { konjugPerfect[2], reflTab, t, nonreflTab, konjugPlusQuamp[2], n };
	String[] row18 = new String[] { konjugPerfect[3], reflTab, t, nonreflTab, konjugPlusQuamp[3], n };
	String[] row19 = new String[] { konjugPerfect[4], reflTab, t, nonreflTab, konjugPlusQuamp[4], n };
	String[] row20 = new String[] { konjugPerfect[5], reflTab, t, nonreflTab, konjugPlusQuamp[5], n };

	// Futur tense I Futur tense II

	String[] row21 = new String[] { n };
	String[] row22 = new String[] { headers[caseIndexLang][4], t, t, t, t, reflTab, headers[caseIndexLang][5], n };
	String[] row23 = new String[] { n };

	String[] row24 = new String[] { konjugFutI[0], t, t, konjugFutII[0], n };
	String[] row25 = new String[] { konjugFutI[1], t, t, konjugFutII[1], n };
	String[] row26 = new String[] { konjugFutI[2], t, t, konjugFutII[2], n };
	String[] row27 = new String[] { konjugFutI[3], t, t, konjugFutII[3], n };
	String[] row28 = new String[] { konjugFutI[4], t, t, konjugFutII[4], n };
	String[] row29 = new String[] { konjugFutI[5], t, t, konjugFutII[5], n };

	// Conditional Past Perfect (Subjunctive)

	String[] row30 = new String[] { n };
	String[] row31 = new String[] { headers[caseIndexLang][6], t, t, t, t, reflTab, headers[caseIndexLang][7], n };
	String[] row32 = new String[] { n };

	String[] row33 = new String[] { konjugConditional[0], t, t, konjugPastPerfect[0], n };
	String[] row34 = new String[] { konjugConditional[1], t, t, konjugPastPerfect[0], n };
	String[] row35 = new String[] { konjugConditional[2], t, t, konjugPastPerfect[0], n };
	String[] row36 = new String[] { konjugConditional[3], t, t, konjugPastPerfect[0], n };
	String[] row37 = new String[] { konjugConditional[4], t, t, konjugPastPerfect[0], n };
	String[] row38 = new String[] { konjugConditional[5], t, t, konjugPastPerfect[0], n };

	String[] row39 = new String[] { n };
	String[] row40 = new String[] { headers[caseIndexLang][8], t, t, t, t, reflTab, headers[caseIndexLang][9], t, t, headers[caseIndexLang][10], n };
	String[] row41 = new String[] { n };
	String[] row42 = new String[] { konjugImperative[0], t, t, t, t, reflTab, partiI, t, t, partiII, n };
	String[] row43 = new String[] { konjugImperative[1], n };
	String[] row44 = new String[] { konjugImperative[2] };

	public String turnArrayToString(String[] array) {
		String string = "";
		for (String i : array) {
			string = string + i;
		}
		return string;
	}

	public static void setReflexive() {
//		if (verbIsReflexiveDative) {
//			reflFill = pronounsReflexDat;
//			reflTab = t;
//			reflSpace = "";
//			nonreflTab = "";
//			nonRefSpace = "";
//		} else if (verbIsReflexiveAccusative) {
//			reflFill = pronounsReflexAkk;
//			reflTab = t;
//			reflSpace = "";
//			nonreflTab = "";
//			nonRefSpace = "";
//		} 
		if (MainWindow.verbIsReflexive) {
			reflFill = pronounsReflexAkk;
			reflTab = t;
			reflSpace = "";
			nonreflTab = "";
			nonRefSpace = "";
		} else if (!MainWindow.verbIsReflexive) {
			reflFill = reflFillEMPTY;
			reflTab = "";
			reflSpace = "";
			nonreflTab = "";
			nonRefSpace = "";
		}
	}

	public void completeTextForConjugationTableTextFile() {
		completeText = turnArrayToString(row1) + turnArrayToString(row2) + turnArrayToString(row3) + turnArrayToString(row4) + turnArrayToString(row5) + turnArrayToString(row6)
				+ turnArrayToString(row7) + turnArrayToString(row8) + turnArrayToString(row9) + turnArrayToString(row10) + turnArrayToString(row11) + turnArrayToString(row12)
				+ turnArrayToString(row13) + turnArrayToString(row14) + turnArrayToString(row15) + turnArrayToString(row16) + turnArrayToString(row17) + turnArrayToString(row18)
				+ turnArrayToString(row19) + turnArrayToString(row20) + turnArrayToString(row21) + turnArrayToString(row22) + turnArrayToString(row23) + turnArrayToString(row24)
				+ turnArrayToString(row25) + turnArrayToString(row26) + turnArrayToString(row27) + turnArrayToString(row28) + turnArrayToString(row29) + turnArrayToString(row30)
				+ turnArrayToString(row31) + turnArrayToString(row32) + turnArrayToString(row33) + turnArrayToString(row34) + turnArrayToString(row35) + turnArrayToString(row36)
				+ turnArrayToString(row37) + turnArrayToString(row38) + turnArrayToString(row39) + turnArrayToString(row40) + turnArrayToString(row41) + turnArrayToString(row42)
				+ turnArrayToString(row43) + turnArrayToString(row44);
//		System.out.println("\n\n\n#####################################\n" + completeText);
	}

	public void copyTextToClipboard(String text) {
		ConjugateRegularVerbs.clip.setContents(new StringSelection(text), null);
	}
}
