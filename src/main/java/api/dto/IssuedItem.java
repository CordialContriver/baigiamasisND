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
    @NotNull
    private Long id;
    @NotNull
    private User user;
    @NotNull
    private Item item;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDate issueDate;
    private LocalDate returnDate;
   /* @NotNull
    private User signingUser;*/
    private String comments;

    public static IssuedItem convert(IssuedItemEntity entity){
        return new IssuedItem(
                entity.getId(),
                User.convert(entity.getUser()),
                Item.convert(entity.getItem()),
                entity.getQuantity(),
                entity.getIssueDate(),
                entity.getReturnDate(),
/*
                User.convert(entity.getSigningUser()),
*/
                entity.getComments()
        );
    }

}
