package com.java.oauth2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
@ConfigurationProperties(prefix="roles.authorization")
public class RoleMapping {


    private Map<String, List<String>> groupToAuthorities = new HashMap<>();

    public Map<String, List<String>> getGroupToAuthorities() {
        return groupToAuthorities;
    }

    public void setGroupToAuthorities(Map<String, List<String>> groupToAuthorities) {
        this.groupToAuthorities = groupToAuthorities;
    }

    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .flatMap(auth -> {
                    if (auth instanceof OidcUserAuthority oidcAuth) {
                        Object groupsClaim = oidcAuth.getAttributes().get("groups");
                        if (groupsClaim instanceof List<?> groupsList) {
                            return groupsList.stream()
                                    .map(Object::toString)
                                    .flatMap(groupId -> groupToAuthorities.getOrDefault(groupId, List.of()).stream())
                                    .map(SimpleGrantedAuthority::new);
                        }
                    }
                    return Stream.empty();
                })
                .distinct()
                .toList();
    }

}