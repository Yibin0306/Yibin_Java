package Reggie.controller;

import Reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.invoke.MutableCallSite;

/**
 * 主要进行，文件上传和文件下载的相关处理
 */

@Slf4j
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public R<String> upload(MultipartFile file){
        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        log.info(file.toString());
        return null;
    }

}
