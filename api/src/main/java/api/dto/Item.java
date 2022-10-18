package api.dto;

import api.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    @NotNull
    @Positive
    private int quantity;
    private String description;
    @NotNull
    private String category;
    private boolean isDisplayed;
    private String privateComments;
    @NotNull
    private String condition;

    public static Item convert(ItemEntity itemEntity){
        return new Item(itemEntity.getId(),
                itemEntity.getName(),
    /*  itemEntity.getImageFile(),  */
                itemEntity.getQuantity(),
                itemEntity.getDescription(),
                itemEntity.getCategory(),
                itemEntity.isDisplayed(),
                itemEntity.getPrivateComments(),
                itemEntity.getCondition()
        );
    }
}
