package top.johnnycse.flight.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import top.johnnycse.flight.pojo.Seat;
import top.johnnycse.flight.service.SeatService;
import top.johnnycse.flight.utils.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Map<String,Object> seatAvailable(Integer flightId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("flightId").is(flightId));
        List<Seat> all = mongoTemplate.find(query,Seat.class);
        if(all.isEmpty()) return api.error("没有航班信息");

        //处理二维数组
        ArrayList<String> objects = new ArrayList<>();
        Seat seat = all.get(0);//拿第一个
        Map<String, List<Integer>> map = seat.getSeat();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            objects.add(entry.getValue().toString());
        }
        //将二维数组字符串转为前端可以读取的JSON
        if(StringUtils.isNotBlank(objects.toString())){
            JSONArray objects1 = JSON.parseArray(objects.toString());
            return api.success(objects1);
        }
        return api.error("内部错误，SeatService第42行");

    }
}
