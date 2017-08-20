package com.narij.narijsocialnetwork.model.temp;

/**
 * Created by kami on 5/7/2016.
 */
public class Relation extends NObject {

    private long relationId;
    private Member member = new Member();
    private RelationType relationType = new RelationType();



    public Relation() {
    }


    public Relation(Member member, long relationId, RelationType relationType) {
        this.member = member;
        this.relationId = relationId;
        this.relationType = relationType;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getRelationId() {
        return relationId;
    }

    public void setRelationId(long relationId) {
        this.relationId = relationId;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public String toString() {
        return "ID : " + relationId + "\n" + "Member : " + member.getMemberId() + "\n" + "RelationType : " + relationType.getRelationTypeId();
    }


}
