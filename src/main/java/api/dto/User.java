package api.dto;

import api.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private File userPhoto;
    private String phone;
    @NotNull
    private String email;
    private LocalDate feePayedOn;
    @NotNull
    private String password;
    @NotNull
    private Set<UserRole> roles;

    public static User convert (UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getUserPhoto(),
                userEntity.getPhone(),
                userEntity.getEmail(),
                userEntity.getFeePayedOn(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(UserRole::convert).collect(Collectors.toSet())
        );
    }





}
