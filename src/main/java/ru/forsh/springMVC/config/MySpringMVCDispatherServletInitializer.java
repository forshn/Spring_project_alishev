package ru.forsh.springMVC.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Здесь мы прописываем путь к загрузке конфиг.класса. То же самое мы делали в web . xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }


    // конфигурация как в контроллере установка requestmapping "/"
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
