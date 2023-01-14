package com.mszlu.xt.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerUtils {

    public static void main(String[] args) throws IOException, TemplateException {

        Configuration configuration = new Configuration(new Version("2.3.0"));
        configuration.setDirectoryForTemplateLoading(new File("G:\\mszlu-xt-parent\\mszlu-xt-common\\src\\main\\resources\\"));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("index.ftl");
        Map<String, Object> map = new HashMap<>();
        map.put("name","freemarker");
        FileWriter fileWriter = new FileWriter(new File("G:\\mszlu-xt-parent\\mszlu-xt-common\\src\\main\\resources\\index.html"));
        template.process(map,fileWriter);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","other freemarker");
        FileWriter fileWriter1 = new FileWriter(new File("G:\\mszlu-xt-parent\\mszlu-xt-common\\src\\main\\resources\\index1.html"));
        template.process(map1,fileWriter1);

        fileWriter.close();
        fileWriter1.close();

    }
}
