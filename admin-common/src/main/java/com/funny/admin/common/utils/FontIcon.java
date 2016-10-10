package com.funny.admin.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * Created by fangli@autohome.com.cn on 2016/10/10.
 */
public class FontIcon {
    public static void main(String[] args) throws Exception {
        File awesome = new File(
                "D:\\gitworkspace\\admin\\admin-web\\src\\main\\webapp\\assets\\plugins\\font-awesome\\css\\font-awesome.css");

        InputStream inputStream = FileUtils.openInputStream(awesome);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line= reader.readLine())!=null){
            stringBuffer.append(line);
        }
        String[] array = stringBuffer.toString().split(".fa-");
        List<String> stringList = Lists.newArrayList();
        for(String id :array){
            if(id.contains("content")){
                stringList.add(id);
            }
        }
        List<String> icons = Lists.newArrayList();
        for(String value:stringList){
            String[] names =  value.split(":");
            icons.add("fa-"+names[0]);
        }
        System.out.println(JSON.toJSONString(icons));
    }
}
