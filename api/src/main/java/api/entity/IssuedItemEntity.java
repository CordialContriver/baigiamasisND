package api.entity;

import api.dto.IssuedItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "borrowing_user")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;
    private int quantity;
    private LocalDate issueDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "signing_user")
    private UserEntity signingUser;
    private String comment;

    public static IssuedItemEntity convert(IssuedItem issuedItem) {
        return new IssuedItemEntity(
                issuedItem.getId(),
                UserEntity.convert(issuedItem.getUser()),
                ItemEntity.convert(issuedItem.getItem()),
                issuedItem.getQuantity(),
                issuedItem.getIssueDate()   ,
                UserEntity.convert(issuedItem.getSigningUser()),
                issuedItem.getComment()
        );

    }

}
