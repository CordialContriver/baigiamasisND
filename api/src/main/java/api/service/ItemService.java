package api.service;

import api.dto.IssuedItem;
import api.dto.Item;
import api.dto.User;
import api.entity.IssuedItemEntity;
import api.entity.ItemEntity;
import api.repository.IssuedItemRepository;
import api.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final IssuedItemRepository issuedItemRepository;

    public ItemService(ItemRepository itemRepository, IssuedItemRepository issuedItemRepository) {
        this.itemRepository = itemRepository;
        this.issuedItemRepository = issuedItemRepository;
    }

    public Page<Item> getAllItemsPage(Pageable pageable) {
        return itemRepository.findAll(pageable).map(Item::convert);
    }

    public void createItem(Item item) {
        itemRepository.save(ItemEntity.convert(item));
    }

    public Item getItemById(UUID id) {
        return Item.convert(itemRepository.findItemById(id));
    }

    public HashSet<String> getItemCategorySet(){
        HashSet<String> categorySet = new HashSet<>();
        for (ItemEntity s : itemRepository.findAll()) {
            categorySet.add(s.getCategory());
        }
        return categorySet;
    }

    public void saveIssuedItem(IssuedItem issuedItem) {
        issuedItemRepository.save(IssuedItemEntity.convert(issuedItem));
    }
    public List<IssuedItem> getIssuedItemsByUser(User user){
        return issuedItemRepository.findAllByUser(user).stream().map(IssuedItem::convert).toList();
    }

    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }

    public List<IssuedItem> getIssuedItemsById(UUID id) {
        return issuedItemRepository.findAllByItemId(id);
    }

    public List<Item> getItemList() {
        return itemRepository.findAll().stream().map(Item::convert).toList();
    }

    public List<Item> searchByText(String text) {
        return  itemRepository.searchByText(text).stream().map(Item::convert).toList();
    }
}
