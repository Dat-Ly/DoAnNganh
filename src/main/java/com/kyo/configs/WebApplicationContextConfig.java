/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kyo.formatter.BillFormatter;
import com.kyo.formatter.CustomerFormatter;
import com.kyo.formatter.RoomFormatter;
import com.kyo.formatter.TienNuocFormatter;
import com.kyo.formatter.TongTienFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Kyoya
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.kyo.controllers",
    "com.kyo.repositories",
    "com.kyo.services"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public Validator getValidator() {
       return validator();
    }
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new RoomFormatter());
        registry.addFormatter(new BillFormatter());
        registry.addFormatter(new TienNuocFormatter());
        registry.addFormatter(new TongTienFormatter());
        registry.addFormatter(new CustomerFormatter());
    }
 
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean v=new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source= new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        
        return resolver;
    }
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c=new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "lydat",
                "api_key", "824145351166584",
                "api_secret", "F7eArnY1UehrIbsqLBg541sHWVk",
                "secure", true
        ));
        return c;
    }

}
