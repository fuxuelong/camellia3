package com.qk.uaaginkgoappserver.entity;

import com.qk.commonservice.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements  Serializable, UserDetails {

    private String id;

    private String username;

    private String password;

    private List<Role> authorities;

    public User(String username,String password,List<Role> authorities){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





 /*   private List<Role> authorities;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
*/



}
