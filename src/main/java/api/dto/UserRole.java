package api.dto;

import api.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    private UUID id;
    private String name;

    public static UserRole convert(UserRoleEntity entity){
        return new UserRole(
                entity.getId(),
                entity.getName()
        );
    }

}
