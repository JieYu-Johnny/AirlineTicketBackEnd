package top.johnnycse.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.johnnycse.flight.pojo.Seat;
import top.johnnycse.flight.service.Impl.SeatServiceImpl;
import top.johnnycse.flight.service.SeatService;

import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SeatServiceImpl service;


    @GetMapping("/seat")
    public Map<String,Object> seat(){
        return service.seatAvailable(1);
    }
}
