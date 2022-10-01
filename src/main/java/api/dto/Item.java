package api.dto;

import api.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.File;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private UUID id;
    @NotNull
    private String name;
/*
    private File imageFile;
*/
    private int quantity;
    private String description;
    private String category;
    @NotNull
    private boolean isDisplayed;
    private String privateComments;
    private String condition;

    public static Item convert(ItemEntity itemEntity){
        return new Item(itemEntity.getId(),
                itemEntity.getName(),
/*
                itemEntity.getImageFile(),
*/
                itemEntity.getQuantity(),
                itemEntity.getDescription(),
                itemEntity.getCategory(),
                itemEntity.isDisplayed(),
                itemEntity.getPrivateComments(),
                itemEntity.getCondition()
        );
    }
}
