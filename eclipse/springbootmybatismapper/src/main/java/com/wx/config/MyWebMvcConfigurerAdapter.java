package com.wx.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wx.interceptor.MyInterceptor;


/**
 * 自定义配置拦截器
 *
 * @author wx
 * <p>
 * Dec 2, 2018
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {
    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 自定义项目内目录(感觉无效的代码)
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 指向外部目录
        // registry.addResourceHandler("/my/**").addResourceLocations("file:E:/my/");
        super.addResourceHandlers(registry);
    }

    /**
     * 以前要访问一个页面需要先创建个Controller控制类，在写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.html页面了
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/toLogin").setViewName("login");
//		super.addViewControllers(registry);
    }

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // registry.addInterceptor(new
        // MyInterceptor()).excludePathPatterns(Arrays.asList("/assets/**", "/js/**"));
        // 需要配置静态资源路径，更新了好扯，上面的方法静态资源路径定义无效
        registry.addInterceptor(new MyInterceptor()).
                addPathPatterns("/**").excludePathPatterns("/toLogin", "/login",
                "/assets/**", "/js/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置fastJson
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
        super.configureMessageConverters(converters);
    }
}
