package conjugate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.jena.ext.com.google.common.io.Files;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mainWindow.MainWindow;
import strings.LoadedVerbs;

public class WriteExcelFile {

	public static String tableName = "";
	public static String folderName = "Conjugations";
	private static String folderDate;
	public static int substractor = 6;
	public static int whiteColumnIndex;
	public static XSSFWorkbook workbook;
	public static File fileDestination;
	public static float[] numberOfCells;
	public static float[] cellWidths;
	public static String filePath;

	public static void setFolderNameForConjugatedTables() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm");
		LocalDateTime now = LocalDateTime.now();
		folderDate = dtf.format(now);
	}

	public static void writeToExcelTable() {

		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					if (MainWindow.fileNameGermanFirst) {
						WriteExcelFile.tableName = MainWindow.refPron + " " + ConjugateRegularVerbs.preSyl + MainWindow.input[0] + " - " + MainWindow.input[1];
					} else {
						WriteExcelFile.tableName = MainWindow.input[1] + " - " + MainWindow.refPron + " " + ConjugateRegularVerbs.preSyl + MainWindow.input[0];
					}

//					System.out.println(ExcelClass.excelFilePath);
					File fileSource = new File(ExcelClass.excelFilePath);
					String filePath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + folderName + File.separator + tableName;
					new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + folderName).mkdir();
					File fileDestinationEXCEL = new File(filePath + ".xlsx");
					Files.copy(fileSource, fileDestinationEXCEL);
					FileInputStream inputStream = new FileInputStream(fileDestinationEXCEL);
					XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
					XSSFSheet sheet = workbook.getSheetAt(0);
					int rows = LoadedVerbs.printArray.size();
					int cells = LoadedVerbs.printArray.get(0).length - substractor;
					float[] columnWidths = new float[cells];
					for (int i = 0; i < rows; i++) {
						Row row = sheet.getRow(i);
						for (int n = 0; n < cells; n++) {
							Cell cell = row.getCell(n);
							cell.setCellValue(LoadedVerbs.printArray.get(i)[n]);
//							System.out.println(i + "  " + n + "   " + cell);
						}
					}
					for (int n = 0; n < cells; n++) {
						columnWidths[n] = sheet.getColumnWidth(n);
					}

					FileOutputStream outputStream = new FileOutputStream(fileDestinationEXCEL);
					workbook.write(outputStream);
					outputStream.close();
					workbook.close();

					// We will create output PDF document objects at this point
					if (MainWindow.storeAsPDF) {
						FileInputStream document = new FileInputStream(fileDestinationEXCEL);
						Document pdf = new Document(PageSize.A4, 10, 10, 50, 10);
						PdfWriter.getInstance(pdf, new FileOutputStream(filePath + ".pdf"));
						pdf.open();
						int n = 0;
						PdfPTable table = new PdfPTable(columnWidths);
						PdfPCell pdfCell;
						for (int i = 0; i < rows - 1; i++) {
							for (n = 0; n < cells; n++) {
								Cell cell = sheet.getRow(i).getCell(n);
								FontFactory.defaultEmbedding = true;
								Font fontH1 = null;
								boolean header = false;
								boolean ge = false;
								boolean ru = false;
								boolean lt = false;
								URL urlI = null;
								URL urlII = null;
								if (i == 0 || i == 3 || i == 12 || i == 21 || i == 30 || i == 39) {
									header = true;
								}


								if (header) {
									if (FixedStrings.caseIndexLang == 2) {
										ru = true;
									}
									if (FixedStrings.caseIndexLang == 3) {
										ge = true;
									} else if (!ge && !ru) {
										lt = true;
									}
									if (ge) {
										urlII = MainWindow.class.getResource("/fonts/bpg_glaho_sylfaen.ttf");
										String fontPathII = Paths.get(urlII.toURI()).toString().replace("file:/C:", "");
										BaseFont bfII = BaseFont.createFont(fontPathII, BaseFont.IDENTITY_H, true);
										fontH1 = new Font(bfII, 9, Font.BOLD);
									}
									if (ru || lt) {
										urlI = MainWindow.class.getResource("/fonts/ClearSans-Bold.ttf");
										String fontPathII = Paths.get(urlI.toURI()).toString().replace("file:/C:", "");
										BaseFont bfII = BaseFont.createFont(fontPathII, BaseFont.IDENTITY_H, true);
										fontH1 = new Font(bfII, 9, Font.BOLD);
									}
								}

								if (!header) {
									urlI = MainWindow.class.getResource("/fonts/ClearSans-Medium.ttf");
									String fontPathI = Paths.get(urlI.toURI()).toString().replace("file:/C:", "");
									BaseFont bfI = BaseFont.createFont(fontPathI, BaseFont.IDENTITY_H, true);
									fontH1 = new Font(bfI, 9, Font.NORMAL);
								}

								try {

									pdfCell = new PdfPCell(new Phrase(cell.getStringCellValue(), fontH1));
									pdfCell.setNoWrap(true);
									pdfCell.setBorder(0);
									pdfCell.setPaddingLeft(10);
									pdfCell.setPaddingBottom(2);
									if (i == 0 || i == 1) {
										pdfCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
									}
									if (n != whiteColumnIndex) {
										if (i != 2 && i != 11 && i != 20 && i != 29 && i != 38) {
											pdfCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
										}
									}
									table.addCell(pdfCell);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}
						pdf.add(table);
						pdf.close();
						document.close();
					}

					if (MainWindow.storeAsTEXT) {
						FileWriter wrt = new FileWriter(filePath + ".txt");
						BufferedWriter bf = new BufferedWriter(wrt);
						bf.write(FixedStrings.completeText);
						bf.close();
					}
					if (!MainWindow.storeAsEXCEL) {
						fileDestinationEXCEL.delete();
					}

				} catch (IOException | DocumentException | URISyntaxException e) {
					e.printStackTrace();
				}
				LoadedVerbs.printArray.clear();
			}
		};
		thread.setDaemon(true);
		thread.start();

	}

}
