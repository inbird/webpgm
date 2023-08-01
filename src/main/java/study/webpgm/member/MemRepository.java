package study.webpgm.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemRepository {
    private static Map<String, Member> mems = new HashMap<>();
    private static final MemRepository instance = new MemRepository();

    //싱글톤 패턴을 통한 공유
    public static MemRepository getInstance() {
        return instance;
    }
    //신규 회원정보 등록
    public Member insMem(Member member) {
        mems.put(member.getUserId(), member);
        return member;
    }

    //전체 회원 목록
    public List<Member> selAllMem() {
        return new ArrayList<>(mems.values());
    }
}
