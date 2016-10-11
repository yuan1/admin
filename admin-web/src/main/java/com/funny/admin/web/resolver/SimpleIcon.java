package com.funny.admin.web.resolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.funny.admin.common.dao.sys.IconMapper;
import com.funny.admin.common.domain.sys.entity.IconEntity;
import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fangli@autohome.com.cn on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-config.xml" })
public class SimpleIcon {
    @Autowired
    private IconMapper iconMapper;
    @Test
    public  void test() throws Exception {
        File simple = new File(
                "D:\\gitworkspace\\admin\\admin-web\\src\\main\\webapp\\assets\\plugins\\simple-line-icons\\simple-line-icons.css");

        InputStream inputStream = FileUtils.openInputStream(simple);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line= reader.readLine())!=null){
            stringBuffer.append(line);
        }
        String[] array = stringBuffer.toString().split(".icon-");
        List<String> stringList = Lists.newArrayList();
        for(String id :array){
            if(id.contains("content")){
                stringList.add(id);
            }
        }
        List<String> icons = Lists.newArrayList();
        for(String value:stringList){
            String[] names =  value.split(":");
            IconEntity iconEntity = new IconEntity();
            iconEntity.setIconType(2);
            iconEntity.setClassName("icon-" + names[0]);
            iconMapper.insertIcon(iconEntity);
        }
    }
}
