package com.ppl.signature;

/**
 * Created by GIOPPL
 * on 2022/3/24 22:38
 * TODO:
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix="preread")
public class PreReadUploadConfig {

    //上传路径
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}