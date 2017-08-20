package com.narij.narijsocialnetwork.model.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 5/7/2016.
 */
public class Group extends NObject {

    private long groupId;
    private String title;
    private Member creator = new Member();
    private List<Member> members = new ArrayList<>();


    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.groupId + " " + this.title;
    }
}
