/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.qk.ginkgoservice.modules.sys.utils;

import java.util.List;
import java.util.Map;

import com.qk.ginkgoservice.common.utils.SpringContextHolder;
import com.qk.ginkgoservice.modules.sys.dao.DictDao;
import com.qk.ginkgoservice.modules.sys.entity.Dict;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典工具类
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
public class DictUtils {

    /*private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

    public static final String CACHE_DICT_MAP = "dictMap";

    public static String getDictLabel(String value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    public static String getDictLabels(String values, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")) {
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    public static String getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    public static List<Dict> getDictList(String type) {
        @SuppressWarnings("unchecked")
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            for (Dict dict : dictDao.findAllList(new Dict())) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = dictMap.get(type);
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    // 模糊取类别
    public static List<Dict> getDictListLike(String type, String likeTypes, String notLikeTypes) {
        @SuppressWarnings("unchecked")
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            for (Dict dict : dictDao.findAllList(new Dict())) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = Lists.newArrayList();
        String[] notLikeTypeArray = notLikeTypes.split(",");
        String[] likeTypeArray = likeTypes.split(",");
        for (Dict dict : dictMap.get(type)) {
            int count = 0;
            for (int i = 0; i < notLikeTypeArray.length; i++) {
                String notLikeType = notLikeTypeArray[i];
                *//*
                 * if(dict.getLabel().indexOf(notLikeType)>-1 && !notLikeType.equals("")){ count+=1;
                 * }
                 *//*
                if (dict.getValue().equals(notLikeType) && !notLikeType.equals("")) {
                    count += 1;
                }
            }
            if (count == 0) {
                if (likeTypeArray.length > 0 && !likeTypeArray[0].equals("")) {
                    for (int i = 0; i < likeTypeArray.length; i++) {
                        String likeType = likeTypeArray[i];
                        if (dict.getLabel().indexOf(likeType) > -1 && !likeType.equals("")) {
                            dictList.add(dict);
                        }
                    }
                } else {
                    dictList.add(dict);
                }

            }
            *//*
             * if((!likeType.equals("") && dict.getLabel().indexOf(likeType)>-1) &&
             * (!notLikeType.equals("") && dict.getLabel().indexOf(notLikeType)<0)){
             * dictList.add(dict); }else if(notLikeType.equals("") && !likeType.equals("") &&
             * dict.getLabel().indexOf(likeType)>-1){ dictList.add(dict); }else
             * if(likeType.equals("") && !notLikeType.equals("") &&
             * dict.getLabel().indexOf(notLikeType)<0){ dictList.add(dict); }
             *//*
        }
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    // value取类别
    public static List<Dict> getDictListEqual(String type, String eqValues, String neValues) {
        @SuppressWarnings("unchecked")
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            for (Dict dict : dictDao.findAllList(new Dict())) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = Lists.newArrayList();
        String[] neValueArray = neValues.split(",");
        String[] eqValueArray = eqValues.split(",");
        for (Dict dict : dictMap.get(type)) {
            int count = 0;

            for (int i = 0; i < neValueArray.length; i++) {
                String neValue = neValueArray[i];
                if (dict.getValue().equals(neValue) && !neValue.equals("")) {
                    count += 1;
                }
            }
            if (count == 0) {
                for (int i = 0; i < eqValueArray.length; i++) {
                    String eqValue = eqValueArray[i];

                    if (dict.getValue().equals(eqValue) && !eqValue.equals("")) {
                        dictList.add(dict);
                    }
                }
            }
            *//*
             * if((!likeType.equals("") && dict.getLabel().indexOf(likeType)>-1) &&
             * (!notLikeType.equals("") && dict.getLabel().indexOf(notLikeType)<0)){
             * dictList.add(dict); }else if(notLikeType.equals("") && !likeType.equals("") &&
             * dict.getLabel().indexOf(likeType)>-1){ dictList.add(dict); }else
             * if(likeType.equals("") && !notLikeType.equals("") &&
             * dict.getLabel().indexOf(notLikeType)<0){ dictList.add(dict); }
             *//*
        }
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    // 模糊排除类别
    public static List<Dict> getDictListNotLike(String type, String notLikeType) {
        @SuppressWarnings("unchecked")
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            for (Dict dict : dictDao.findAllList(new Dict())) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = Lists.newArrayList();
        for (Dict dict : dictMap.get(type)) {
            if (dict.getType().indexOf(notLikeType) < 0) {
                dictList.add(dict);
            }
        }
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    *//**
     * 返回字典列表（JSON）
     * 
     * @param type
     * @return
     *//*
    public static String getDictListJson(String type) {
        return JsonMapper.toJsonString(getDictList(type));
    }
*/
}
