package com.ppl.signature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;


/**
 * Created by GIOPPL
 * on 2022/3/9 15:23
 * TODO:nohup java -jar signature2-1.0.0.jar >xxx.log 2>&1 &
 */
@RestController
@Slf4j
public class FileController {

    @PostMapping("/sign/main/efort")
    public R SingleFileUpLoad(@RequestParam("myfile") MultipartFile file) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        System.out.println("正在上传");
        //判断文件是否为空
        if (file.isEmpty()) {
            return R.error().message("文件为空");
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
//            String path = "D:/JavaProject22/signature2/src/main/resources/upload/SIGN_UPLOAD.jpg";
//            String path = req.getSession().getServletContext().getRealPath("/SIGN_UPLOAD");
            String path = "/media/image/SIGN_UPLOAD.jpg";
            System.out.println(path);
            log.info("文件路径："+path);
            log.info("文件名："+file.getName());
            //获取文件的输入流
            inputStream = file.getInputStream();
            //注意是路径+文件名
            File targetFile = new File(path);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);

            //告诉页面上传成功了
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return R.ok().message("上传成功");
    }

    @GetMapping("/sign/main/a")
    public R test(@RequestParam("param") String param) {
        System.out.println("success：" + param);
        return R.ok().message("success：" + param);
    }
}
