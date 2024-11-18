package com.ll;

public class App {
    private int id = 0; // 번호
    private String mu = ""; // 명언
    private String jk = ""; // 작가

    public App(int id, String mu, String jk) {
        this.id = id;
        this.mu = mu;
        this.jk = jk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }
}
