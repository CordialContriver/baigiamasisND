package api.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends Throwable {
    private final UUID itemId;

    public ItemNotFoundException(UUID itemId) {
        this.itemId = itemId;
    }

    public UUID getItemId() {
        return itemId;
    }
}
