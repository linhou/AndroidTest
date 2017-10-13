package com.example.linhou.testdome.mvp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin.Hou on 2017/9/13.
 */

public class Integration {

    /**
     * message : Not Found
     * documentation_url : https://developer.github.com/v3
     */

    private String message;
    private String documentation_url;

    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }

    public void setDocumentation_url(String documentation_url) {
        this.documentation_url = documentation_url;
    }
}
