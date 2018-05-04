package com.zst;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * �޸������࣬�̳� SpringBootServletInitializer ����д configure ����
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // ע������Ҫָ��ԭ����main����ִ�е�Application������
        return builder.sources(Application.class);
    }
}
