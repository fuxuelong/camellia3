package com.qk.uaaserver.entity;

import com.qk.commonservice.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Data
@NoArgsConstructor
public class Role extends DataEntity<Role> implements GrantedAuthority {

    private String name;


    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Role(String name){
        this.name = name;
    }


}
