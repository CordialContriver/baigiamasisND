package api.repository;

import api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findFirstById(UUID id);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    @Query("select distinct u from UserEntity u join IssuedItemEntity i on u.id = i.user")
    List<UserEntity> findAllWithItems();
}
