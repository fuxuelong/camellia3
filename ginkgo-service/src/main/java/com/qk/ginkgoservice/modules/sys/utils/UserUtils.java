package com.qk.ginkgoservice.modules.sys.utils;


import com.qk.ginkgoservice.common.constant.Constant;
import com.qk.ginkgoservice.common.utils.SpringContextHolder;
import com.qk.ginkgoservice.modules.basic.crm.dao.QkBasicJxsinfoDao;
import com.qk.ginkgoservice.modules.basic.crm.entity.QkBasicJxsinfo;
import com.qk.ginkgoservice.modules.basic.crm.service.QkBasicJxsinfoService;
import com.qk.ginkgoservice.modules.sys.dao.UserDao;
import com.qk.ginkgoservice.modules.sys.entity.User;
import com.qk.ginkgoservice.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 *
 * @author fuxuelong 2018-07-18
 */

public  class UserUtils {

    public static UserService userService = SpringContextHolder.getBean(UserService.class);
    public static QkBasicJxsinfoService qkBasicJxsinfoService = SpringContextHolder.getBean(QkBasicJxsinfoService.class);
    public static QkBasicJxsinfoDao qkBasicJxsinfoDao = SpringContextHolder.getBean(QkBasicJxsinfoDao.class);
    @Autowired
    private static RedisTemplate<Object,Object> redisTemplate;
//
    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";
    public static final String CACHE_AREA_LIST = "areaList";
    public static final String CACHE_OFFICE_LIST = "officeList";
    public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
    public static final String CACHE_PP_LIST = "ppList";
    public static final String CACHE_PP_ALL_LIST = "ppAllList";

    public static final String JXS_CACHE = "jxsCache";
    public static final String JXS_CACHE_CODE_ = "jxscode_";
    public static final String JXSGL_CACHE = "jxsglCache";
    public static final String JXSGL_CACHE_CODE_ = "jxsglcode_";

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    private static final String AUTHORIZATION = "authorization";

    public static User getUser(){
        String userName = getCurrentPrinciple();
        return userService.getUserByUserName(userName);
    }
    /**
     * 获取当前请求的token
     * @return
     */
    public static String getCurrentToken() {
        return HttpUtils.getHeaders(HttpUtils.getHttpServletRequest()).get(AUTHORIZATION);
    }

    /**
     * 获取当前请求的用户Id
     * @return
     */
    public static String getCurrentPrinciple() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 判读当前token用户是否为接口所需的参数username
     *
     * @param username
     * @return
     */
    public static boolean isMyself(String username) {
        return username.equals(getCurrentPrinciple());
    }

    /**
     * 获取当前请求Authentication
     *
     * @return
     */
    public static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前请求的权限信息
     * @return
     */
    public static List<SimpleGrantedAuthority> getCurrentAuthorities() {
        return (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * @param role
     * @return
     */
    public static boolean hasRole(String role) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        boolean hasRole = false;
        List<SimpleGrantedAuthority> list = getCurrentAuthorities();
        for (SimpleGrantedAuthority s : list) {
            if (role.equals(s.getAuthority())) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }
    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }
    /**获取当前经销商*/
    public static QkBasicJxsinfo getCurrentJxs() {
        String userName = getCurrentPrinciple();
        System.out.println(userService.getUserByUserName(userName).getOffice().getCode()+"+++++++");
        if (userName != null) {
            User user = userService.getUserByUserName(userName);
            if (user != null) {
                //通过经销商编码从redis缓存中获取，如果没有就从数据库查询然后放到缓存中
                QkBasicJxsinfo jxs = qkBasicJxsinfoService.getJxsByCode(user.getOffice().getCode());
//                if (jxs == null) {
//                    //如果缓存中没有改经销商信息，office与当前登录用户一致，并且已经需要已经审批通过
//                    List<QkBasicJxsinfo> jsxInfoList = qkBasicJxsinfoDao
//                            .findList(new QkBasicJxsinfo(null, null, user.getOffice(), "2"));// 经销商Info的ID
//                    jxs = (jsxInfoList.size() == 0 ? null : jsxInfoList.get(0));
//                    if (jxs != null) {
//                        jxs = (jxs.getParent() == null ? jxs
//                                : qkBasicJxsinfoDao.get(jxs.getParent().getId()));// 若登录用户为团队账号，则返回其经销商信息；否则返回登录经销商信息
////                        CacheUtils.put(JXS_CACHE, JXS_CACHE_CODE_ + user.getOffice().getCode(),
//////                                jxs);
//                        redisTemplate.opsForValue().set(Constant.GINKGO_JXS_REDISTEMP_PREFIX+user.getOffice().getCode(),jxs);
//                    }
//                }
                return jxs == null ? null
                        : (jxs.getParent() == null ? jxs
                        : qkBasicJxsinfoDao.get(jxs.getParent().getId()));
            }
        }
        // 如果没有登录，则返回实例化空的QkBasicJxsinfo对象。
        return null;
    }

}
