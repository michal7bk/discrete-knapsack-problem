package rucsack.problem;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

@Data
public class ExcelCreator {

    final static Logger logger = Logger.getLogger("ExcelCreator");
    private String filename;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private HSSFRow row;

    public ExcelCreator(String nazwa) {
        nazwa = nazwa.replace('/', '_');
        try {
            filename = nazwa + ".xls";
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("FirstSheet");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void createRow(int rowNumber) {
        row = sheet.createRow(rowNumber);
    }

    public void insertText(int columnNumber, String value) {
        row.createCell(columnNumber).setCellValue(value);
    }

    public void insertValue(int columnNumber, int value) {
        row.createCell(columnNumber).setCellValue(value);
    }

    public void generate() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            logger.info("Excel file has been generated successfullly!");
        } catch (IOException e) {
            logger.warning("Excel  encountered problems!");
            e.printStackTrace();
        }
    }
}