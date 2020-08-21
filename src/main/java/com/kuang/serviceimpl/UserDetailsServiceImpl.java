package com.kuang.serviceimpl;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ht
 * @Date 2020/8/20 10:39
 * @Version 1.0
 **/
@Service
//重写UserDetailsService的loadUserByUsername方法
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserMapper mapper;

  @Autowired
  PasswordEncoder passwordEncoder;


  @Override

  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
      User user =mapper.selectlimit(name);
      if (user==null){
        return null;
      }else {
        //创建一个权限的集合
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //添加获取权限
        authorities.add(new SimpleGrantedAuthority(user.getLimit()));
        //把对象信息（用户名，密码，权限）存入对象，返回该对象，controller层直接调用
        org.springframework.security.core.userdetails.User user2 =new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
        System.out.println("管理员信息："+user.getUsername()+"   "+passwordEncoder.encode(user.getPassword())+"  "+user2.getAuthorities());
        return user2;
      }

  }
}
