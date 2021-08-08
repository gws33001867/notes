package com.lance.learningnotes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lance shan
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Words implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String theme;

    private String keywords;

    private String content;

    private Integer categoryId;


}
