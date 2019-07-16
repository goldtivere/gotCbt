package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.services.ExcelUploadService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    @Override
    public String workBook(XSSFWorkbook wb) {
        XSSFSheet ws = wb.getSheetAt(0);
        Row rows;
        rows = (Row) ws.getRow(0);
        int wsCount = ws.getLastRowNum() - 1;
        CellRangeAddress regions = (CellRangeAddress) ws.getMergedRegion(0);
        //int colNum = regions.getLastColumn();
        int colNum = ws.getRow(0).getLastCellNum();
        int rowNum = ws.getLastRowNum() + 1;
        int finalSize = colNum - 1;
        Boolean testCol = false;


        for (int i = 0; i < 1; i++) {
            rows = (Row) ws.getRow(0);

            for (Cell cell : rows) {
//                if (cell.getCellType() == CellType.BLANK) {
//
//                } else if (cell.getCellType() == CellType.STRING) {
//
//                    if (cell.getStringCellValue().equalsIgnoreCase("regnumber")) {
//
//                    } else {
//                        lst.add(cell.getStringCellValue());
//                    }
//                }
                System.out.println("i am here balls: "+ cell.getStringCellValue());
            }

        }
        return "done";
    }
}
