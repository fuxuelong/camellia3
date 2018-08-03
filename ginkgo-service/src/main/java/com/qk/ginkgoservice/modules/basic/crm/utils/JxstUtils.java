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
        return UserUtils.getCurrentJxs();
    }
}
