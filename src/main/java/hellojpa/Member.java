package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    //기간
    @Embedded
    private Period workPeriod = null;
    //주소
    @Embedded
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                            column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                            column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}









