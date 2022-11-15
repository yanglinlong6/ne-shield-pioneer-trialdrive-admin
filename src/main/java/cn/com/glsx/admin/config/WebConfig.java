package cn.com.glsx.admin.config;

import cn.com.glsx.auth.interceptor.WebRequestAuthorizeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author payu
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WebRequestAuthorizeInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //1.加入的顺序就是拦截器执行的顺序，
        //2.按顺序执行所有拦截器的preHandle
        //3.所有的preHandle 执行完再执行全部postHandle 最后是postHandle
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("swagger-ui.html")
                .excludePathPatterns("/actuator/**")
                .excludePathPatterns("/api/**")
                .excludePathPatterns("/vehicle/drivevehicle/syncVehicleInfo")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/importVehicle.xlsx");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/importVehicleInfo.xlsx");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/importWriteListSn.xlsx");
    }

}