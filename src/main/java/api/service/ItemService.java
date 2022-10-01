package api.service;

import api.dto.Item;
import api.entity.ItemEntity;
import api.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> getAllItemsPage(Pageable pageable) {
        return itemRepository.findAll(pageable).map(Item::convert);
    }

    public void addItem(Item item) {
        itemRepository.save(ItemEntity.convert(item));
    }

    public Item getItemById(UUID id) {
        return Item.convert(itemRepository.findItemById(id));
    }




}
