package com.qk.ginkgoservice.modules.basic.crm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;




/**
 * 经销商工具类
 * 
 * @author qk
 * @version 2016-12-23
 */
public class JxstUtils {




    /**
     * 获取当前QkBasicJxsinfo
     * 
     * @return 取不到返回 new QkBasicJxsinfo()
     */
    public static QkBasicJxsinfo getCurrentJxs() {
        /*
         * Principal principal = UserUtils.getPrincipal(); if (principal!=null){ User user =
         * UserUtils.get(principal.getId()); if (user != null){ QkBasicJxsinfo jxs =
         * (QkBasicJxsinfo)CacheUtils.get(JXS_CACHE, JXS_CACHE_CODE_ + user.getOffice().getCode());
         * if(jxs==null){ List<QkBasicJxsinfo> jsxInfoList=qkBasicJxsinfoService.findList(new
         * QkBasicJxsinfo(null,user.getOffice().getCode(),"2"));//经销商Info的ID
         * jxs=(jsxInfoList.size()==0?null:jsxInfoList.get(0)); if(jxs!=null){
         * jxs=(jxs.getParent()==null?jxs:qkBasicJxsinfoService.get(jxs.getParent().getId()));//
         * 若登录用户为团队账号，则返回其经销商信息；否则返回登录经销商信息 CacheUtils.put(JXS_CACHE, JXS_CACHE_CODE_ +
         * user.getOffice().getCode()); } return jxs; } } } // 如果没有登录，则返回实例化空的QkBasicJxsinfo对象。
         */ return UserUtils.getCurrentJxs();
    }




}
