package com.css.thread.entity;

/**
 * @author chenshanshan
 * @time 2019/7/1 14:32
 */
public class Repo {
    private String resultcode;
    private String reason;
    private News[] result;
    private String error_code;

    public News[] getResult() {
        return result;
    }
}
