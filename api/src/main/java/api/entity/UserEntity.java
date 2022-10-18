package api.entity;

import api.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    //    private File userPhoto;
    private String phone;
    private String email;

    private LocalDate feePaidOn;

    private String username;
    private String password;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRoleEntity> roles;

    public UserEntity(UUID id, String name, String surname, String phone, String email,
                      LocalDate feePaidOn,
                      String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.feePaidOn = feePaidOn;
        this.username = username;
        this.password = password;
    }

    public static UserEntity convert(User user) {
        Set<UserRoleEntity> roles = user.getRoles().stream()
                .map(UserRoleEntity::convert)
                .collect(Collectors.toSet());

        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getSurname(),
//            user.getUserPhoto(),
                user.getPhone(),
                user.getEmail(),
                user.getFeePaidOn(),
                user.getUsername(),
                user.getPassword(),
                roles
        );
    }

}
