package ru.job4j.pooh;

public class QueueService implements Service {
    @Override
    public Resp process(Req req) {
        return new Resp(req.text, 200);
    }
}