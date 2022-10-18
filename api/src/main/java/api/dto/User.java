package api.dto;

import api.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
//    private File userPhoto;
    private String phone;
    @NotNull
    private String email;
    private LocalDate feePaidOn;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private Set<UserRole> roles;

    public static User convert (UserEntity userEntity){
        Set<UserRole> roles = userEntity.getRoles().stream()
                .map(UserRole::convert)
                .collect(Collectors.toSet());

        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
//                userEntity.getUserPhoto(),
                userEntity.getPhone(),
                userEntity.getEmail(),
                userEntity.getFeePaidOn(),
//                LocalDate.parse(userEntity.getFeePaidOn()),
                userEntity.getUsername(),
                userEntity.getPassword(),
                roles
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
}
