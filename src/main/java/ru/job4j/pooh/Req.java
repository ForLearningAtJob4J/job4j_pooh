package ru.job4j.pooh;

public class Req {
    private final String text;

    public Req(String text) {
        this.text = text;
    }

    private String getRoutePart(int i) {
        return text.lines().findFirst().get().split(" ")[1].split("/")[i];
    }

    public String valueOf(String key) {
        return null;
    }

    public String mode() {
        return getRoutePart(1);
    }

    public String method() {
        return text.lines().findFirst().get().split(" ")[0];
    }

    public String getName() {
        return getRoutePart(2);
    }

    public String getData() {
        return text.lines().dropWhile(s -> !s.isEmpty()).skip(1).findFirst().orElse("");
    }
}