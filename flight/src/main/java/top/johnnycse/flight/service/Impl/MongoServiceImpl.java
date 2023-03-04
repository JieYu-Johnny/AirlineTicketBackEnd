package top.johnnycse.flight.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.johnnycse.flight.pojo.Seat;
import top.johnnycse.flight.service.MongoService;

import java.util.Map;

@Service

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /*
    创建对象
     */
    @Override
    public void save(Seat seat) {
        mongoTemplate.save(seat);
    }

    @Override
    public Map<String, Object> find(String query, Class<Seat> classs) {

        return null;
    }
}
