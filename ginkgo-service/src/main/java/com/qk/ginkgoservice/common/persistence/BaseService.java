/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.common.persistence;

import com.google.common.collect.Lists;
import com.qk.ginkgoservice.common.utils.StringUtils;
import com.qk.ginkgoservice.modules.basic.crm.utils.JxstUtils;
import com.qk.ginkgoservice.modules.sys.entity.Role;
import com.qk.ginkgoservice.modules.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class BaseService {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 数据范围过滤
     * 
     * @param user 当前用户对象，通过“entity.getCurrentUser()”获取
     * @param officeAlias 机构表别名，多个用“,”逗号隔开。
     * @param userAlias 用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
     * @return 标准连接条件对象
     */
    public static String dataScopeFilter(User user, String officeAlias, String userAlias) {

        StringBuilder sqlString = new StringBuilder();

        // 进行权限过滤，多个角色权限范围之间为或者关系。
        List<String> dataScope = Lists.newArrayList();

        // 超级管理员，跳过权限过滤
        if (!user.isAdmin()) {
            boolean isDataScopeAll = false;
            for (Role r : user.getRoleList()) {
                for (String oa : StringUtils.split(officeAlias, ",")) {
                    if (!dataScope.contains(r.getDataScope()) && StringUtils.isNotBlank(oa)) {
                        if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())) {
                            isDataScopeAll = true;
                        } else if (Role.DATA_SCOPE_COMPANY_AND_CHILD.equals(r.getDataScope())) {
                            sqlString.append(
                                    " OR " + oa + ".id = '" + user.getCompany().getId() + "'");
                            sqlString.append(" OR " + oa + ".parent_ids LIKE '"
                                    + user.getCompany().getParentIds() + user.getCompany().getId()
                                    + ",%'");
                        } else if (Role.DATA_SCOPE_COMPANY.equals(r.getDataScope())) {
                            sqlString.append(
                                    " OR " + oa + ".id = '" + user.getCompany().getId() + "'");
                            // 包括本公司下的部门 （type=1:公司；type=2：部门）
                            sqlString.append(" OR (" + oa + ".parent_id = '"
                                    + user.getCompany().getId() + "' AND " + oa + ".type = '2')");
                        } else if (Role.DATA_SCOPE_OFFICE_AND_CHILD.equals(r.getDataScope())) {
                            sqlString.append(
                                    " OR " + oa + ".id = '" + user.getOffice().getId() + "'");
                            sqlString.append(" OR " + oa + ".parent_ids LIKE '"
                                    + user.getOffice().getParentIds() + user.getOffice().getId()
                                    + ",%'");
                        } else if (Role.DATA_SCOPE_OFFICE.equals(r.getDataScope())) {
                            sqlString.append(
                                    " OR " + oa + ".id = '" + user.getOffice().getId() + "'");
                        } else if (Role.DATA_SCOPE_CUSTOM.equals(r.getDataScope())) {
                            // String officeIds = StringUtils.join(r.getOfficeIdList(), "','");
                            // if (StringUtils.isNotEmpty(officeIds)){
                            // sqlString.append(" OR " + oa + ".id IN ('" + officeIds + "')");
                            // }
                            sqlString
                                    .append(" OR EXISTS (SELECT 1 FROM sys_role_office WHERE role_id = '"
                                            + r.getId() + "'");
                            sqlString.append(" AND office_id = " + oa + ".id)");
                        }
                        // else if (Role.DATA_SCOPE_SELF.equals(r.getDataScope())){
                        // dataScope.add(r.getDataScope());20170716因需要判断多个office涉及的数据权限而注释
                    }
                }
            }
            // 如果没有全部数据权限，并设置了用户别名，则当前权限为本人；如果未设置别名，当前无权限为已植入权限
            // 20170930暂不使用
            // 20171026 测试权限出现问题
            if (!isDataScopeAll) {

                if (StringUtils.isNotBlank(userAlias)) {
                    for (String ua : StringUtils.split(userAlias, ",")) {
                        // 20171026
                        if (JxstUtils.getCurrentJxs() != null) {
                            for (String oa : StringUtils.split(officeAlias, ",")) {
                                sqlString.append(" or " + "(" + ua + ".id = '" + user.getId()
                                        + "' and " + oa + ".id = '"
                                        + JxstUtils.getCurrentJxs().getOfficejxs().getId() + "') ");
                            }

                        } else {
                            for (String oa : StringUtils.split(officeAlias, ",")) {
                                sqlString.append(
                                        " or " + "(" + ua + ".id = '" + user.getId() + "' and " + oa
                                                + ".id = '" + user.getOffice().getId() + "') ");
                            }
                        }
                        /* sqlString.append(" or " + ua + ".id = '" + user.getId() + "'"); */
                    }
                } else {
                    for (String oa : StringUtils.split(officeAlias, ",")) {
                        // sqlString.append(" OR " + oa + ".id = " + user.getOffice().getId());
                        sqlString.append(" OR " + oa + ".id IS NULL");
                    }
                }
            } else {
                // 如果包含全部权限，则去掉之前添加的所有条件，并跳出循环。
                sqlString = new StringBuilder();
            }

        }
        if (StringUtils.isNotBlank(sqlString.toString())) {
            return " AND (" + sqlString.substring(4) + ")";
        }

        return "";
    }


    /**
     * 数据范围过滤
     * 
     * @param user 当前用户对象，通过“entity.getCurrentUser()”获取
     * @param officeAlias 机构表别名，多个用“,”逗号隔开。
     * @param userAlias 用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
     * @return 标准连接条件对象
     */


    /**
     * 数据范围过滤（符合业务表字段不同的时候使用，采用exists方法）
     * 
     * @param entity 当前过滤的实体类
     * @param sqlMapKey sqlMap的键值，例如设置“dsf”时，调用方法：${sqlMap.sdf}
     * @param officeWheres office表条件，组成：部门表字段=业务表的部门字段
     * @param userWheres user表条件，组成：用户表字段=业务表的用户字段
     * @example dataScopeFilter(user, "dsf", "id=a.office_id", "id=a.create_by");
     *          dataScopeFilter(entity, "dsf", "code=a.jgdm", "no=a.cjr"); //
     *          适应于业务表关联不同字段时使用，如果关联的不是机构id是code。
     */


}
