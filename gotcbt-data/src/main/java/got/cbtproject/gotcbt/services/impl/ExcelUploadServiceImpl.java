package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.model.Subject;
import got.cbtproject.gotcbt.services.ExcelUploadService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    @Override
    public List<Subject> workBook(XSSFWorkbook wb) {
        XSSFSheet ws = wb.getSheetAt(0);
        Row rows;
        rows = (Row) ws.getRow(0);
        int wsCount = ws.getLastRowNum() - 1;
        //CellRangeAddress regions = (CellRangeAddress) ws.getMergedRegion(0);
        //int colNum = regions.getLastColumn();
        int colNum = ws.getRow(0).getLastCellNum();
        int rowNum = ws.getLastRowNum() + 1;
        int finalSize = colNum - 1;
        Boolean testCol = false;
        int valCount = 0;
        System.out.println("last row 1: "+ rowNum+ " last row 2: "+ws.getLastRowNum());
        List<Subject> s = new ArrayList<>();

        for (int i = 0; i <= ws.getLastRowNum(); i++) {
            rows = (Row) ws.getRow(valCount);

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
                System.out.println("i am here balls: " + cell.getStringCellValue());
            }
            valCount++;
        }
        return s;
    }
}
