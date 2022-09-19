package lwq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
@RequestMapping("/upload")
public class uploadController {

    @ResponseBody
    @RequestMapping (value = "/fileUpload",method = RequestMethod.POST)
    @CrossOrigin
    public String handlerForUpload(@RequestParam("fileList") MultipartFile multipartFile, HttpServletRequest request) {
        //判断所上传文件是否存在
        if (multipartFile.isEmpty()) {
            return "上传错误";
        }
        //获取上传文件的原始名称
        String originalFilename = multipartFile.getOriginalFilename();
        //设置上传文件的保存地址目录
        String dirPath = request.getServletContext().getRealPath("/upload/");
        File filePath = new File(dirPath);
        //如果保存的地址不存在,就先创建目录
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        //获取当前文件的后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //使用UUID重新命名上传的文件名称(UUID(唯一识别码)+原始文件名称后缀)
        String newFileName = UUID.randomUUID() + "." + suffix;
        try {
            //创建可能会有错误,强制添加异常
            multipartFile.transferTo(new File(dirPath + newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "上传错误";
        }
        System.out.println(dirPath + newFileName);
        return "上传成功"+"文件地址="+dirPath + newFileName;
    }

}
