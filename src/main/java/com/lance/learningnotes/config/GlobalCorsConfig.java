package com.lance.learningnotes.config;


import com.lance.learningnotes.interceptors.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 */
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer{

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(authorizationInterceptor)
//                        .addPathPatterns("/*")
//                        .excludePathPatterns("/login","/register");
//            }
//
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")    //添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
//                        .allowedOriginPatterns("*")    //开放哪些ip、端口、域名的访问权限
//                        .allowCredentials(true)  //是否允许发送Cookie信息
//                        .allowedMethods("GET","POST", "PUT", "DELETE")     //开放哪些Http方法，允许跨域访问
//                        .allowedHeaders("*")     //允许HTTP请求中的携带哪些Header信息
//                        .exposedHeaders("*");   //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//            }
//        };
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                        .addPathPatterns("/**")
                        .excludePathPatterns(
                        "/swagger-resources/**",
                                "/webjars/**",
                                "/v2/**",
                                "/swagger-ui.html/**",
                                "/users/register",
                                "/users/login",
                                "/users/verify",
                                "/test");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")    //添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
                        .allowedOriginPatterns("*")    //开放哪些ip、端口、域名的访问权限
                        .allowCredentials(true)  //是否允许发送Cookie信息
                        .allowedMethods("GET","POST", "PUT", "DELETE")     //开放哪些Http方法，允许跨域访问
                        .allowedHeaders("*")     //允许HTTP请求中的携带哪些Header信息
                        .exposedHeaders("*");   //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
            }
}