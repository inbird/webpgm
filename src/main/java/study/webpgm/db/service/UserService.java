package study.webpgm.db.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<String, Object>> getUserList();

    Map<String, Object> getUser(String userId);

}
