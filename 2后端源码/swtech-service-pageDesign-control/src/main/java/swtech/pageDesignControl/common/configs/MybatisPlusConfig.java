package swtech.pageDesignControl.common.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

//@Configuration
//@MapperScan("swtech.pageDesignControl.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
//    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}