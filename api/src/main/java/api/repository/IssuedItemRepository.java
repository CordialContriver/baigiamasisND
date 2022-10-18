package api.repository;

import api.dto.IssuedItem;
import api.dto.User;
import api.entity.IssuedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IssuedItemRepository extends JpaRepository<IssuedItemEntity, Long> {

    List<IssuedItemEntity> findAllByUser(User user);

    @Query("select i from IssuedItemEntity i where i.item=:item")
    List<IssuedItem> findAllByItemId(@Param("item") UUID item_id);

//    List<IssuedItemEntity> findAllByReturnDateBefore(@Param("date")LocalDate localDate);

}
