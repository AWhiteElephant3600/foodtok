package com.cbx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Fooddata extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //图片名字
    private String foodname;

    // 介绍
    private String introduce;

    private String origin;

    private String makingmethod;

    private String area;

    private String tag;

    // 图片链接
    private String foodsamllimg;

    // 点赞数
    private int likenum;

    // 是否点赞
    private int islike;

    // 是否收藏
    private int iscollect;

    private String foodbigimg;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userid;



}
