package study.webpgm.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.webpgm.db.dao.TestMapper;
import study.webpgm.db.dto.portfolio;

import java.util.List;

@Service

public class TestServiceImpl implements TestService {
    private final TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public List<portfolio> getAllDataList() {
        return testMapper.getAllDataList();
    }
}
