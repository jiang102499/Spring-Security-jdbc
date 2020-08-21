package com.kuang.config;


import com.kuang.serviceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author ht
 * @Date 2020/8/12 16:57
 * @Version 1.0
 **/
@EnableWebSecurity
//WebSecurityConfigurerAdapter自定义的security策略
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  //链式编程
  @Override
  //授权
  protected void configure(HttpSecurity http) throws Exception {
    //super.configure(http);
    //请求授权规则
    http.authorizeRequests()
      //permitAll()都可以访问
      .antMatchers("/").permitAll()
      .antMatchers("/user").hasRole("USER")
      .antMatchers("/root").hasRole("ROOT");

    //没有权限自动跳转到登陆页（自带登录页）
    //默认是username，password
    //usernameParameter("user").passwordParameter("pwd").loginPage("/login");设置字段名以及跳转的接口
    http.formLogin();
  }

   /*
    认证规则
     */

  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //在这里完成获得数据库中的用户信息
  //密码一定要加密
  //认证
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
}



