package com.didikee.weplay.framework.contact;

import java.util.List;

/**
 * Created by didik on 2016/11/12.
 */

public class SimpleContact {

    private String name;
    private List<String> phone;
    private List<String> email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}
