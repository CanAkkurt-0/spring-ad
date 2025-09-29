package com.java.azurestarterad;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

@Component
@ConfigurationProperties(prefix="roles.authorization")
public class RoleMapping {

    private static final String ROLE_PREFIX = "ROLE_";

    private Map<String, List<String>> groupToAuthorities = new HashMap<>();

    public Map<String, List<String>> getGroupToAuthorities() {
        return groupToAuthorities;
    }

    public void setGroupToAuthorities(Map<String, List<String>> groupToAuthorities) {
        this.groupToAuthorities = groupToAuthorities;
    }

    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().flatMap(authority -> groupToAuthorities.getOrDefault(stripRolePrefix(authority.getAuthority()), emptyList())
                        .stream())
                .distinct()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    private String stripRolePrefix(String authority) {
        return authority.replaceFirst(ROLE_PREFIX, "");
    }
}