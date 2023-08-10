package study.webpgm.db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.webpgm.db.mapper.UserMapper;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    @Override
    public List<Map<String, Object>> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public Map<String, Object> getUser(String userId) {
        return userMapper.getUser(userId);
    }
}
