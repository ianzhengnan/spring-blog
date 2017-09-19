package com.ian.sblog.x4.chapter8.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableLiaoshangAspect {

    @DeclareParents(value = "com.ian.sblog.x4.chapter8.aspectj.NormalGongfu", defaultImpl = NormalLiaoShang.class)
    public LiaoShang liaoShang; // 要实现的目标接口


}
