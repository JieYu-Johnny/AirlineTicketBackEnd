package top.johnnycse.flight.service;

import top.johnnycse.flight.pojo.Seat;

import java.util.Map;

public interface MongoService {
    public void save(Seat seat);

    public Map<String,Object> find(String query, Class<Seat> classs);
}
