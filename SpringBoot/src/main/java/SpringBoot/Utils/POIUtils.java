package SpringBoot.Utils;

import SpringBoot.entity.Person;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Header;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/9
 * @version: 1.0
 */
public class POIUtils
{

    public static ResponseEntity<byte[]> ExportExcel(List<Person> list)
    {
        //1.创建一个空的Excel表
        HSSFWorkbook workbook = new HSSFWorkbook();

        //3.开始创建sheet页
        HSSFSheet sheet = workbook.createSheet("用户信息");

        //4.创建行
        HSSFRow row = sheet.createRow(0);

        //5.根据需要创建列
        HSSFCell c0 = row.createCell(0);
        c0.setCellValue("编号");
        HSSFCell c1 = row.createCell(1);
        c1.setCellValue("名称");
        HSSFCell c2 = row.createCell(2);
        c2.setCellValue("电话");

        //6.循环遍历插入数据
        for (int i = 0; i < list.size(); i++)
        {
            Person book = list.get(i);//这里大家可以打断点调试，每个循环进来的数据都放到book对象里
            //因为我这里i=0,而第0行已经被标题给占了，所以我下面的遍历都是从1开始
            //我们可以看到，这里的逻辑可以说相当简单，我们循环创建一行，然后在那一行创建列，给每一列
            //设置对应的数据
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(book.getId());
            row1.createCell(1).setCellValue(book.getName());
            row1.createCell(2).setCellValue(book.getMobile());
        }

        //7.敲重点咯！这里可以说是最烦的地方。
        //首先，我们知道我们这里返回的数据类型是ResponseEntity<byte[]>，所以我们要在返回的时候实例化他
        //我们可以点击他的源码看，发现它里面有很多构造函数
        /**
         public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers,
         HttpStatus status) {
         super(body, headers);
         Assert.notNull(status, "HttpStatus must not be null");
         this.status = status;
         }
         */
        //我们需要一个不为空的主体对象、一个头、一个状态位
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try
        {
            /**
             * 防止文件名乱码
             headers.setContentDispositionFormData("attachment",
             new String(exportFile.getName().getBytes("utf-8"), "ISO8859-1"));
             */
            headers.setContentDispositionFormData("attachment", new String("用户信息.xls"
                    .getBytes("UTF-8"), "ISO-8859-1"));
            //response.setContentType(MIME)的作用是使客户端浏览器，区分不同种类的数据，
            // 并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //将workbook转成byte数组
            workbook.write(baos);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
    }

    public static List<Person> ImportExcel(MultipartFile file)
    {
        List<Person> list = new ArrayList<>();
        Person book = null;
        //创建表
        try
        {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //获取sheets页
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++)
            {
                //循环获取每页的数据
                HSSFSheet sheetAt = workbook.getSheetAt(i);
                //获取行数
                int ofRows = sheetAt.getPhysicalNumberOfRows();
                for (int j = 0; j < ofRows; j++)
                {
                    if (j == 0)
                    {
                        //第一行是标题，想想不跳的话，你录到数据库里不就把标题也录进去了嘛
                        continue;
                    }
                    HSSFRow row = sheetAt.getRow(j);
                    if (row == null)
                    {
                        //跳空行
                        continue;
                    }
                    //获取表单列数据
                    int cells = row.getPhysicalNumberOfCells();
                    book = new Person();
                    for (int k = 0; k < cells; k++)
                    {
                        HSSFCell cell = row.getCell(k);
                        switch (k){
                            case 1:
                                book.setName(cell.getStringCellValue());
                                break;
                            case 2:
                                book.setMobile(cell.getStringCellValue());
                                break;
                        }

                    }
                    list.add(book);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}

