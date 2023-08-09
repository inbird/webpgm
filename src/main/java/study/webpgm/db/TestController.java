package study.webpgm.db;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.db.dto.portfolio;
import study.webpgm.db.service.TestService;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class TestController {
    private final TestService testService;

    @GetMapping("/db/test")
    public List<portfolio> test() {

        return testService.getAllDataList();
    }
}
