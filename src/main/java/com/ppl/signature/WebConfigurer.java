package com.ppl.signature;

/**
 * Created by GIOPPL
 * on 2022/3/24 22:37
 * TODO:
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 自定义资源映射
 * <p>
 *     设置虚拟路径，访问绝对路径下资源
 * </p>
 */
@ComponentScan
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    PreReadUploadConfig uploadConfig;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:"+uploadConfig.getUploadPath()+"/");
        super.addResourceHandlers(registry);
    }
}
