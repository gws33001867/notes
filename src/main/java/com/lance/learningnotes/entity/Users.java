package com.lance.learningnotes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;

/**
 * <p>
 * 
 * </p>
 *
 * @author lance shan
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Users implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uname;

    private String pwd;

    private String avatar;

    @Email()
    private String email;

    private Integer qq;


}
