package study.webpgm.db.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import study.webpgm.db.dto.portfolio;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    List<portfolio> getAllDataList();
}
