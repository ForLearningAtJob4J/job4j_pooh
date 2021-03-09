package ru.job4j.pooh;

public class Resp {
    public static final int OK = 200;
    private final String text;
    private final int status;

    public Resp(String text, int status) {
        this.text = "\r\n" + text;
        this.status = status;
    }

    public String text() {
        return text;
    }

    public int status() {
        return status;
    }
}