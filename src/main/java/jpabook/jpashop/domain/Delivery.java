package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL로 쓰면 (0,1) (1,0) 이런 식으로 들어감. 그래서 READY와 COMP사이에 새로운 것이 생기면 하나씩 밀리게 됨. 따라서 절대 쓰면 안되고 EnumType.STRING으로 무조건 쓰기
    private DeliveryStatus status; // READY, COMP
}
