package ru.job4j.pooh;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class QueueService implements Service {
    final ConcurrentHashMap<String, LinkedList<String>> queue = new ConcurrentHashMap<>();
    final Map<String, Function<Req, Resp>> processor = new HashMap<>();

    {
        processor.put("POST", (req) -> {
            queue.compute(req.getName(), (k, data) -> {
                if (data == null) {
                    data = new LinkedList<>();
                }
                data.add(req.getData());
                return data;
            });
            return new Resp(String.format("Added in %s with name %s: %s", req.mode(), req.getName(), req.getData()), Resp.OK);
        });

        processor.put("GET", (req) -> {
            String[] res = {null};
            queue.compute(req.getName(), (k, data) -> {
                if (data != null) {
                    res[0] = data.poll();
                }
                return data;
            });

            return new Resp(res[0] == null ? "There is nothing for you" : res[0], Resp.OK);
        });
    }

    @Override
    public Resp process(Req req) {
        return processor.get(req.method()).apply(req);
    }
}