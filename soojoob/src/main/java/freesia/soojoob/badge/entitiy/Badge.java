package freesia.soojoob.badge.entitiy;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_id")
    private int id;


    @Column(name="badge_name")
    private String name;

    @Column(name="badge_detail")
    private String detail;

    @Column(name="badge_url")
    private String imgUrl;

    public Badge(int id){
        this.id = id;
    }
}

// Entity 설계 원칙

// 1. FK키가 있는 곳을 주인으로
// 2. 값 타입에는 @Embeddable 을 사용하는 필드에는 @Embedded 를 준다. --> 값을 변경하지 못하도록 하기 위해서
// 3. 가급적 Setter 를 쓰지 않는다. --> 유지보수가 어려워진다.
// 4. 모든 관계의 Fetch Type은 Lazy Loading(지연로딩)으로 설정
//      EAGER(즉시로딩) 은 예측이 어렵고 어떤 SQL 이 실행될지 추적이 어렵다.
// 5. Collection 은 필드에서 초기화
// 6. 테이블 네이밍은 snake_case가 일반적
// 7. 객체의 필드는 id 라고 만들고 @Column(name = "member_id") 이런 식으로 만드는 것이 좋다.



