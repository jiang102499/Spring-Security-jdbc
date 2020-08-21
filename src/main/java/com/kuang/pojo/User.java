package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author ht
 * @Date 2020/8/20 10:23
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private  int id;

  private String username;

  private String password;

  private  String limit;


}
