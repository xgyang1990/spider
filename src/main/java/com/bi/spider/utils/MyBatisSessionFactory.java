package com.bi.spider.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyBatisSessionFactory {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSessionFactory() {

        if(sqlSessionFactory ==  null){
            String resource = "configuration.xml";
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sqlSessionFactory;
    }


}
