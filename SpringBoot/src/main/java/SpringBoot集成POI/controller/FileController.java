package SpringBoot集成POI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/9
 * @version: 1.0
 */
@Controller
@RequestMapping("/view/for")
public class FileController
{
    @GetMapping("/")
    public String fileUpLoad(){
        return "SpringBoot集成POI/上传文件";
    }
}

