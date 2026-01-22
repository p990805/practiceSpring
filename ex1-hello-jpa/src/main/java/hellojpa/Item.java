package hellojpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
// 싱글테이블이 default 값이 여서 만약 이거를 따로 지정안한다면 상속 받은 테이블 한테이블에 생성
@Inheritance(strategy = InheritanceType.JOINED )

//default가 DTYPE이라고 컬럼이 생기고 여기서 movie인지, album인지 이런거 알려주는 역할을 함
@DiscriminatorColumn(name = "CATEGORY")
public class Item {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

}
