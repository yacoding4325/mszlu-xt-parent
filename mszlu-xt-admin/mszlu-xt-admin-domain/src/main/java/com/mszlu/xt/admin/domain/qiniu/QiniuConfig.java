package com.mszlu.xt.admin.domain.qiniu;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class QiniuConfig {

    @Value("${qiniu.file.server.url}")
    private String fileServerUrl;

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.accessSecret}")
    private String accessSecret;

    @Value("${qiniu.bucket}")
    private String bucket;

}
