package api.entity;

import api.dto.IssuedItem;
import api.dto.Item;
import api.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issued_items")
public class IssuedItemEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private ItemEntity item;
    private int quantity;
    private LocalDate issueDate;
    private LocalDate returnDate;
/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity signingUser;*/
    private String comments;

    public static IssuedItemEntity convert(IssuedItem issuedItem) {
        return new IssuedItemEntity(
                issuedItem.getId(),
                UserEntity.convert(issuedItem.getUser()),
                ItemEntity.convert(issuedItem.getItem()),
                issuedItem.getQuantity(),
                issuedItem.getIssueDate(),
                issuedItem.getReturnDate(),
/*
                UserEntity.convert(issuedItem.getSigningUser()),
*/
                issuedItem.getComments()
        );

    }

}
