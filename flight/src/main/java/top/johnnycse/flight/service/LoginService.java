package top.johnnycse.flight.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {
    public Map<String,Object> login(String userName,String passwd);
    public Map<String,Object> loginOut(HttpServletRequest request);
    public Map<String,Object> signUp(String userName,String passwd);
}
