package com.peak.ssm.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FetchList {
    private int     id          ;
    public boolean isTop        ;       //是否置顶
    private String banner       ;      //背景图片
    public boolean isHot        ;       //是否火爆
    private Date   pubTime      ;       //建立时间
    private String title        ;       //标题
    private String summary      ;     //概括
    private int    viewsCount   ;     //观看次数
}
