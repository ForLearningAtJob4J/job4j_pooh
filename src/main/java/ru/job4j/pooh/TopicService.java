package ru.job4j.pooh;

public class TopicService implements Service {
    @Override
    public Resp process(Req req) {
        return new Resp(req.text, 200);
    }
}