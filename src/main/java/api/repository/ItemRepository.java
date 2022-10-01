package api.repository;

import api.dto.Item;
import api.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    ItemEntity findItemById (UUID id);
    List<ItemEntity> findAllByCategory(String category);


}
