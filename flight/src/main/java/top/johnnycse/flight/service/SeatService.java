package top.johnnycse.flight.service;

import java.util.Map;

public interface SeatService {
    public Map<String,Object> seatAvailable(Integer flightId);
}
