package SpringBoot集成POI.controller;

import SpringBoot集成POI.Utils.POIUtils;
import SpringBoot集成POI.entity.Book;
import SpringBoot集成POI.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/9
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/excel")
public class ToolExcelController
{
    @Autowired
    ExcelService excelService;
    @GetMapping("/")
    public List<Book> getAllBooks(){
        return excelService.getAllBooks();
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> excelExport(){
        List<Book> list=excelService.getAllBooks();
        return POIUtils.ExportExcel(list);
    }
    @PostMapping("/import")
    public String excelImport(MultipartFile file){
        List<Book> list= POIUtils.ImportExcel(file);
        if(excelService.addBook(list)){
            return "上传成功！";
        }
        return "上传失败！";
    }
}

