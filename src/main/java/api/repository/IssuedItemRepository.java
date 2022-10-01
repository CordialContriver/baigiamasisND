package api.repository;

import api.dto.IssuedItem;
import api.dto.User;
import api.entity.IssuedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssuedItemRepository extends JpaRepository<IssuedItemEntity, Long> {
    List<IssuedItemEntity> findAllByUser(User user);

    List<IssuedItemEntity> findAllByReturnDateBefore(@Param("date")LocalDate localDate);

}
