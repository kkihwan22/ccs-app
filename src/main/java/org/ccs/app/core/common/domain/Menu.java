package org.ccs.app.core.common.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin_menu")
@DynamicInsert
@DynamicUpdate
@Getter
@ToString
public class Menu extends BaseCreatedAndUpdatedDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "parent_id")
//    private List<Menu> menus;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "target")
    private String target;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "last_child_index")
    private Integer lastChildIndex;

    @Column(name = "item_order")
    private Integer itemOrder;

    @Column(name = "disabled")
    private Boolean disabled;

    public void changeItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }
}
