package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.util.Date;

@Entity
// 만약 테이블 이름이 달라야 한다면 이렇게 설정
//거의 그냥 그대로 사용하는 것을 추천
//@Table(name="MBR")

public class Member {

    @Id
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 10, columnDefinition = "varchar(10) default 'EMPTY'")
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 이제는 그냥 LocalDateTime 쓰기만 하면 된다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private LocalDate createDate2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // DB에 넣지 않고 그냥 캐시상으로 사용하고만 싶을 때 하는 것 -> 하지만 결국 거의 사용 x
    @Transient
    private Integer temp;

    public Member(){

    }

    public Member(String userName, Integer age, RoleType roleType, String description) {
        this.userName = userName;
        this.age = age;
        this.roleType = roleType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreateDate2() {
        return createDate2;
    }

    public void setCreateDate2(LocalDate createDate2) {
        this.createDate2 = createDate2;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
