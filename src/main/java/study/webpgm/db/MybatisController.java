package study.webpgm.db;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.db.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MybatisController {

    private final UserService userService;

    @GetMapping("/db/user")
    public Map<String, Object>  getUser(String userId){
        return userService.getUser(userId);
    }

    @GetMapping("/db/user_list")
    public List<Map<String, Object>>  getUserList(){
        return userService.getUserList();
    }
}
