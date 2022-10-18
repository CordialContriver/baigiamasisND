package api.repository;

import api.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    ItemEntity findItemById (UUID id);
    List<ItemEntity> findAllByCategory(String category);

    @Query("select i from ItemEntity i where i.name like %:text% or i.description like %:text%")
    List<ItemEntity> searchByText(String text);
}
