package api.dto;

import api.entity.IssuedItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssuedItem {
    private Long id;
    @NotNull
    private User user;
    @NotNull
    private Item item;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDate issueDate;
    @NotNull
    private User signingUser;
    private String comment;

    public IssuedItem(User user, Item item, Integer integer, LocalDate now) {
    }

    public static IssuedItem convert(IssuedItemEntity entity) {
        return new IssuedItem(
                entity.getId(),
                User.convert(entity.getUser()),
                Item.convert(entity.getItem()),
                entity.getQuantity(),
                entity.getIssueDate()   ,
                User.convert(entity.getSigningUser()),
                entity.getComment()
        );
    }

}
