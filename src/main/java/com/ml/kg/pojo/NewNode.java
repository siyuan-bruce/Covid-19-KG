//package com.ml.kg.pojo;
//
//import org.neo4j.ogm.annotation.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@NodeEntity(label = "人物")
//public class NewNode {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Property(name = "name")
//    private String name;
//
//    @Property(name = "出发日期")
//    private String depatureDate;
//
//    @Property(name = "出版日期")
//    private String publishDate;
//
//    @Property(name = "出生日期")
//    private String birthDate;
//
//    @Property(name = "发表日期")
//    private String deliverDate;
//
//
//
//    @Property(name = "奖项名次")
//    private String awards;
//
//    @Property(name = "性别")
//    private String sex;
//
//    @Property(name = "死亡日期")
//    private String deathDate;
//
//    @Property(name = "民族")
//    private String nation;
//
//    @Property(name = "籍贯")
//    private String nativePlace;
//
//    @Relationship(type = "事迹",direction = Relationship.OUTGOING)
//    private Set<NewNode> deeds = new HashSet<>();
//
//    @Relationship(type = "任职机构",direction = Relationship.OUTGOING)
//    private Set<NewNode> office = new HashSet<>();
//
//    @Relationship(type = "共同作者",direction = Relationship.OUTGOING)
//    private Set<NewNode> coauthor = new HashSet<>();
//
//    @Relationship(type = "出版",direction = Relationship.OUTGOING)
//    private Set<NewNode> publish = new HashSet<>();
//
//    @Relationship(type = "出生地",direction = Relationship.OUTGOING)
//    private Set<NewNode> birthplace = new HashSet<>();
//
//    @Relationship(type = "参与事件",direction = Relationship.OUTGOING)
//    private Set<NewNode> participateEvent = new HashSet<>();
//
//    @Relationship(type = "参与战役",direction = Relationship.OUTGOING)
//    private Set<NewNode> participateBattle = new HashSet<>();
//
//    @Relationship(type = "发生地点",direction = Relationship.OUTGOING)
//    private Set<NewNode> occurplace = new HashSet<>();
//
//
//    @Relationship(type = "发表",direction = Relationship.OUTGOING)
//    private Set<NewNode> deliver = new HashSet<>();
//
//    @Relationship(type = "同事",direction = Relationship.OUTGOING)
//    private Set<NewNode> colleauge = new HashSet<>();
//
//    @Relationship(type = "国籍",direction = Relationship.OUTGOING)
//    private Set<NewNode> country = new HashSet<>();
//
//    @Relationship(type = "导致",direction = Relationship.OUTGOING)
//    private Set<NewNode> lead = new HashSet<>();
//
//    @Relationship(type = "履历",direction = Relationship.OUTGOING)
//    private Set<NewNode> resume = new HashSet<>();
//
//    @Relationship(type = "所在城市",direction = Relationship.OUTGOING)
//    private Set<NewNode> city = new HashSet<>();
//
//    @Relationship(type = "所属救援队",direction = Relationship.OUTGOING)
//    private Set<NewNode> rescueTeam = new HashSet<>();
//
//    @Relationship(type = "支援地点",direction = Relationship.OUTGOING)
//    private Set<NewNode> rescuePlace = new HashSet<>();
//
//    @Relationship(type = "死亡原因",direction = Relationship.OUTGOING)
//    private Set<NewNode> deathReason = new HashSet<>();
//
//    @Relationship(type = "毕业院校",direction = Relationship.OUTGOING)
//    private Set<NewNode> graduateSchool = new HashSet<>();
//
//    @Relationship(type = "爆发地点",direction = Relationship.OUTGOING)
//    private Set<NewNode> outbreakpace = new HashSet<>();
//
//    @Relationship(type = "现任机构",direction = Relationship.OUTGOING)
//    private Set<NewNode> organization = new HashSet<>();
//
//    @Relationship(type = "相关奖项",direction = Relationship.OUTGOING)
//    private Set<NewNode> relatedRewards = new HashSet<>();
//
//    @Relationship(type = "相关疾病",direction = Relationship.OUTGOING)
//    private Set<NewNode> relateddisease = new HashSet<>();
//
//    @Relationship(type = "研究方向",direction = Relationship.OUTGOING)
//    private Set<NewNode> researchDirection = new HashSet<>();
//
//    @Relationship(type = "第一作者",direction = Relationship.OUTGOING)
//    private Set<NewNode> firstAuthor = new HashSet<>();
//
//    @Relationship(type = "职务",direction = Relationship.OUTGOING)
//    private Set<NewNode> post = new HashSet<>();
//
//    @Relationship(type = "职责",direction = Relationship.OUTGOING)
//    private Set<NewNode> duty = new HashSet<>();
//
//    @Relationship(type = "获奖时间",direction = Relationship.OUTGOING)
//    private Set<NewNode> rewardDate = new HashSet<>();
//
//    @Relationship(type = "获奖原因",direction = Relationship.OUTGOING)
//    private Set<NewNode> rewardReason = new HashSet<>();
//
//    @Relationship(type = "重要成果",direction = Relationship.OUTGOING)
//    private Set<NewNode> significantAchievements = new HashSet<>();
//
//    @Relationship(type = "队友",direction = Relationship.OUTGOING)
//    private Set<NewNode> partner = new HashSet<>();
//
//    @Relationship(type = "顺承",direction = Relationship.OUTGOING)
//    private Set<NewNode> follow = new HashSet<>();
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDepatureDate() {
//        return depatureDate;
//    }
//
//    public void setDepatureDate(String depatureDate) {
//        this.depatureDate = depatureDate;
//    }
//
//    public String getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(String publishDate) {
//        this.publishDate = publishDate;
//    }
//
//    public String getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getDeliverDate() {
//        return deliverDate;
//    }
//
//    public void setDeliverDate(String deliverDate) {
//        this.deliverDate = deliverDate;
//    }
//
//    public String getAwards() {
//        return awards;
//    }
//
//    public void setAwards(String awards) {
//        this.awards = awards;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getDeathDate() {
//        return deathDate;
//    }
//
//    public void setDeathDate(String deathDate) {
//        this.deathDate = deathDate;
//    }
//
//    public String getNation() {
//        return nation;
//    }
//
//    public void setNation(String nation) {
//        this.nation = nation;
//    }
//
//    public String getNativePlace() {
//        return nativePlace;
//    }
//
//    public void setNativePlace(String nativePlace) {
//        this.nativePlace = nativePlace;
//    }
//
//    public Set<NewNode> getDeeds() {
//        return deeds;
//    }
//
//    public void setDeeds(Set<NewNode> deeds) {
//        this.deeds = deeds;
//    }
//
//    public Set<NewNode> getOffice() {
//        return office;
//    }
//
//    public void setOffice(Set<NewNode> office) {
//        this.office = office;
//    }
//
//    public Set<NewNode> getCoauthor() {
//        return coauthor;
//    }
//
//    public void setCoauthor(Set<NewNode> coauthor) {
//        this.coauthor = coauthor;
//    }
//
//    public Set<NewNode> getPublish() {
//        return publish;
//    }
//
//    public void setPublish(Set<NewNode> publish) {
//        this.publish = publish;
//    }
//
//    public Set<NewNode> getColleauge() {
//        return colleauge;
//    }
//
//    public void setColleauge(Set<NewNode> colleauge) {
//        this.colleauge = colleauge;
//    }
//
//    public Set<NewNode> getCountry() {
//        return country;
//    }
//
//    public void setCountry(Set<NewNode> country) {
//        this.country = country;
//    }
//
//    public Set<NewNode> getLead() {
//        return lead;
//    }
//
//    public void setLead(Set<NewNode> lead) {
//        this.lead = lead;
//    }
//
//    public Set<NewNode> getResume() {
//        return resume;
//    }
//
//    public void setResume(Set<NewNode> resume) {
//        this.resume = resume;
//    }
//
//    public Set<NewNode> getCity() {
//        return city;
//    }
//
//    public void setCity(Set<NewNode> city) {
//        this.city = city;
//    }
//
//    public Set<NewNode> getRescueTeam() {
//        return rescueTeam;
//    }
//
//    public void setRescueTeam(Set<NewNode> rescueTeam) {
//        this.rescueTeam = rescueTeam;
//    }
//
//    public Set<NewNode> getRescuePlace() {
//        return rescuePlace;
//    }
//
//    public void setRescuePlace(Set<NewNode> rescuePlace) {
//        this.rescuePlace = rescuePlace;
//    }
//
//    public Set<NewNode> getDeathReason() {
//        return deathReason;
//    }
//
//    public void setDeathReason(Set<NewNode> deathReason) {
//        this.deathReason = deathReason;
//    }
//
//    public Set<NewNode> getGraduateSchool() {
//        return graduateSchool;
//    }
//
//    public void setGraduateSchool(Set<NewNode> graduateSchool) {
//        this.graduateSchool = graduateSchool;
//    }
//
//    public Set<NewNode> getOutbreakpace() {
//        return outbreakpace;
//    }
//
//    public void setOutbreakpace(Set<NewNode> outbreakpace) {
//        this.outbreakpace = outbreakpace;
//    }
//
//    public Set<NewNode> getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(Set<NewNode> organization) {
//        this.organization = organization;
//    }
//
//    public Set<NewNode> getRelatedRewards() {
//        return relatedRewards;
//    }
//
//    public void setRelatedRewards(Set<NewNode> relatedRewards) {
//        this.relatedRewards = relatedRewards;
//    }
//
//    public Set<NewNode> getRelateddisease() {
//        return relateddisease;
//    }
//
//    public void setRelateddisease(Set<NewNode> relateddisease) {
//        this.relateddisease = relateddisease;
//    }
//
//    public Set<NewNode> getResearchDirection() {
//        return researchDirection;
//    }
//
//    public void setResearchDirection(Set<NewNode> researchDirection) {
//        this.researchDirection = researchDirection;
//    }
//
//    public Set<NewNode> getFirstAuthor() {
//        return firstAuthor;
//    }
//
//    public void setFirstAuthor(Set<NewNode> firstAuthor) {
//        this.firstAuthor = firstAuthor;
//    }
//
//    public Set<NewNode> getPost() {
//        return post;
//    }
//
//    public void setPost(Set<NewNode> post) {
//        this.post = post;
//    }
//
//    public Set<NewNode> getDuty() {
//        return duty;
//    }
//
//    public void setDuty(Set<NewNode> duty) {
//        this.duty = duty;
//    }
//
//    public Set<NewNode> getRewardDate() {
//        return rewardDate;
//    }
//
//    public void setRewardDate(Set<NewNode> rewardDate) {
//        this.rewardDate = rewardDate;
//    }
//
//    public Set<NewNode> getRewardReason() {
//        return rewardReason;
//    }
//
//    public void setRewardReason(Set<NewNode> rewardReason) {
//        this.rewardReason = rewardReason;
//    }
//
//    public Set<NewNode> getSignificantAchievements() {
//        return significantAchievements;
//    }
//
//    public void setSignificantAchievements(Set<NewNode> significantAchievements) {
//        this.significantAchievements = significantAchievements;
//    }
//
//    public Set<NewNode> getPartner() {
//        return partner;
//    }
//
//    public void setPartner(Set<NewNode> partner) {
//        this.partner = partner;
//    }
//
//    public Set<NewNode> getFollow() {
//        return follow;
//    }
//
//    public void setFollow(Set<NewNode> follow) {
//        this.follow = follow;
//    }
//
//    public Set<NewNode> getBirthplace() {
//        return birthplace;
//    }
//
//    public void setBirthplace(Set<NewNode> birthplace) {
//        this.birthplace = birthplace;
//    }
//
//    public Set<NewNode> getParticipateEvent() {
//        return participateEvent;
//    }
//
//    public void setParticipateEvent(Set<NewNode> participateEvent) {
//        this.participateEvent = participateEvent;
//    }
//
//    public Set<NewNode> getParticipateBattle() {
//        return participateBattle;
//    }
//
//    public void setParticipateBattle(Set<NewNode> participateBattle) {
//        this.participateBattle = participateBattle;
//    }
//
//    public Set<NewNode> getOccurplace() {
//        return occurplace;
//    }
//
//    public void setOccurplace(Set<NewNode> occurplace) {
//        this.occurplace = occurplace;
//    }
//
//    public Set<NewNode> getDeliver() {
//        return deliver;
//    }
//
//    public void setDeliver(Set<NewNode> deliver) {
//        this.deliver = deliver;
//    }
//
//
//
//
//    private NewNode() {
//        // Empty constructor required as of Neo4j API 2.0.5
//    }
//    public NewNode(String name, String depatureDate, String publishDate, String birthDate, String deliverDate, String awards, String sex, String deathDate, String nation, String nativePlace) {
//        this.name = name;
//        this.depatureDate = depatureDate;
//        this.publishDate = publishDate;
//        this.birthDate = birthDate;
//        this.deliverDate = deliverDate;
//        this.awards = awards;
//        this.sex = sex;
//        this.deathDate = deathDate;
//        this.nation = nation;
//        this.nativePlace = nativePlace;
//    }
//
//
//}
