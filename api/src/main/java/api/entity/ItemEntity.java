package api.entity;

import api.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
/*
    private File imageFile;
*/
    private int quantity;
    private String description;
    private String category;
    private boolean isDisplayed;
    private String privateComments;
    private String condition;

    public static ItemEntity convert(Item item){
        return new ItemEntity(item.getId(),
                item.getName(),
/*
                item.getImageFile(),
*/
                item.getQuantity(),
                item.getDescription(),
                item.getCategory(),
                item.isDisplayed(),
                item.getPrivateComments(),
                item.getCondition()
        );
    }


}
