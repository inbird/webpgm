package study.webpgm.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
        List<Map<String, Object>> getUserList();

        Map<String, Object> getUser(String userId);
}
