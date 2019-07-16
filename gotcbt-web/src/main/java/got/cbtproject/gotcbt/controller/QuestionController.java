package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.services.ExcelUploadService;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class QuestionController {
    private final ExcelUploadService excelUploadService;
    private String fileLocation;

    public QuestionController(ExcelUploadService excelUploadService) {
        this.excelUploadService = excelUploadService;
    }

    @PostMapping("/admin/question/save")
    public String uploadFile(Model model, MultipartFile file,final RedirectAttributes redirectAttributes) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        InputStream in = file.getInputStream();
        File currDir = new File(file.getOriginalFilename());
        OPCPackage pkg = OPCPackage.open(in);
        XSSFWorkbook wb = new XSSFWorkbook(pkg);

        excelUploadService.workBook(wb);
        pkg.close();
        redirectAttributes.addFlashAttribute("msg", "active");
        redirectAttributes.addFlashAttribute("msgText","update Successful!!" +  file.getOriginalFilename());
        System.out.println("hello: " +file.getOriginalFilename());
//        model.addAttribute("message", "File: " + file.getOriginalFilename()
//                + " has been uploaded successfully!");
        return "redirect:/admin/question";
    }
}
