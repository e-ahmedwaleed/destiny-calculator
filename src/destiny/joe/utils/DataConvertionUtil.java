package destiny.joe.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Using Java API read Comma Separated Values(.csv) file and convert into XLS
 * file with Apache POI API.
 * 
 * <pre>
 * DataConvertionUtil.csvToxls(excelFileName, csvFileName);
 * </pre>
 * 
 * @version 1.0, 13/July/2012
 * @author Stephen Babu.P
 * 
 * @see https://gist.github.com/robertchong/11071949
 * @see http://stephenbabu-p.blogspot.com/2012/07/convert-excel-file-to-csv-using-apache.html
 */
public class DataConvertionUtil {
    /**
     * Comma separated characters
     */
    private static final String CVS_SEPERATOR_CHAR = ",";

    /**
     * Convert CSV file to Excel file
     * 
     * @param analysisCSV
     * @param excelfile
     */
    public static void csvToExcel(List<String> analysisCSV, String excelfile) {
        try (HSSFWorkbook myWorkBook = new HSSFWorkbook();
                FileOutputStream writer = new FileOutputStream(new File(excelfile));) {

            for (String inputFile : analysisCSV) {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputFile)))) {

                    HSSFSheet mySheet = myWorkBook.createSheet(extractFileName(inputFile));
                    String line = "";
                    int rowNo = 0;
                    while ((line = reader.readLine()) != null) {
                        String[] columns = line.split(CVS_SEPERATOR_CHAR);
                        HSSFRow myRow = mySheet.createRow(rowNo);
                        for (int i = 0; i < columns.length; i++) {
                            creatCell(columns, myRow, i);
                        }
                        rowNo++;
                    }
                }
            }
            myWorkBook.write(writer);

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private static String extractFileName(String inputFile) {
        int index = inputFile.lastIndexOf('\\');
        if (index < 0)
            index = inputFile.lastIndexOf('/');
        StringBuilder fileName = new StringBuilder();
        fileName.append(inputFile.substring(index + 1).replace(".csv", ""));
        fileName.setCharAt(0, Character.toUpperCase(fileName.charAt(0)));
        return fileName.toString();
    }

    private static void creatCell(String[] columns, HSSFRow myRow, int i) {
        HSSFCell myCell = myRow.createCell(i);
        try {
            myCell.setCellValue(Integer.parseInt(columns[i]));
        } catch (Exception e) {
            myCell.setCellValue(columns[i]);
        }
    }

}