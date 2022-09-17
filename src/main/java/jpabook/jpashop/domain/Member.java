package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    // @Embedded : 내장 타입임을 명시
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Member에 있어 order는 여러 개가 있을 수 있으므로 1 대 다의 관계
    private List<Order> orders = new ArrayList<>();
}
