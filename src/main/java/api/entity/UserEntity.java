package api.entity;

import api.dto.User;
import api.dto.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String surname;
    private File userPhoto;
    private String phone;
    private String email;
    private LocalDate feePayedOn;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRoleEntity> roles;

    public static UserEntity convert (User user){
        return new UserEntity(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getUserPhoto(),
            user.getPhone(),
            user.getEmail(),
            user.getFeePayedOn(),
            user.getPassword(),
            user.getRoles().stream().map(UserRoleEntity::convert).collect(Collectors.toSet())
        );
    }



}
