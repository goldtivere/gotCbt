package got.cbtproject.gotcbt.services;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface ExcelUploadService {
    public List<?> workBook(XSSFWorkbook cell);
}
