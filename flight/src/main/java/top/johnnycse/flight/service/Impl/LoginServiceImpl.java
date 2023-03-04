package top.johnnycse.flight.service.Impl;

import org.springframework.stereotype.Service;
import top.johnnycse.flight.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public Map<String, Object> login(String userName, String passwd) {

        return null;
    }

    @Override
    public Map<String, Object> loginOut(HttpServletRequest request) {
        return null;
    }

    @Override
    public Map<String, Object> signUp(String userName, String passwd) {
        return null;
    }
}
