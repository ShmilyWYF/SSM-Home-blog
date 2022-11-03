package com.peak.ssm.uiltr;

import org.junit.jupiter.api.Test;

public class REg {

    @Test
    public void ok(){
        String str="{'title':'第一篇文章','desc':'<p>@[TOC]</p><h4 id=\"引言：安装\">引言：安装</h4>','name':'peak','isTop':true,'isHot':true,'banner':'https://www.yulumi.cn/gl/uploads/allimg/201125/10523T0F-2.jpg','summary':'第一篇文章发布','viewsCount':0}";
        str.replace("\\\\","");
    }
}
