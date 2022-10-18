package api.dto;


import api.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements GrantedAuthority {
    private static final String ROLE_PREFIX = "ROLE_";

    private UUID id;
    private String name;

    @Override
    public String getAuthority() {
        return ROLE_PREFIX + name;
    }
    public static UserRole convert(UserRoleEntity entity) {
        return new UserRole(entity.getId(), entity.getName());
    }
}