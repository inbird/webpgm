package study.webpgm.json;


import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.member.Member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
public class JsonSubwayTest {

    @RequestMapping("/json/test1")
    public Member jsonTest1() {
        Member member = new Member("ID1", "NAME1", 10);
        log.info("Member={}", member);
        return member;
    }

    @RequestMapping("/json/test2")
    public Map<String, Object> jsonTest2() {
        Map<String, Object> map = new HashMap<>();

        Member member1 = new Member("ID1", "NAME1", 10);
        Member member2 = new Member("ID2", "NAME2", 20);
        Member member3 = new Member("ID3", "NAME3", 30);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        map.put("strResult", "SUCCESS");
        map.put("totalCnt", 5);
        map.put("memberList", memberList);

        return map;
    }

    @RequestMapping("/json/test3")
    public List<Member> jsonTest3() {
        Member member1 = new Member("ID1", "NAME1", 10);
        Member member2 = new Member("ID2", "NAME2", 20);
        Member member3 = new Member("ID3", "NAME3", 30);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        return memberList;
    }

    @RequestMapping("/json/findSubway")
    public Map<String, Object> findSubway(String stnText) throws IOException, ParseException {

        log.info("stnText={}", stnText);

        String urlStr = "http://swopenAPI.seoul.go.kr/api/subway/4d6641664c70726f3132384a7a414957/json/realtimeStationArrival/0/15/";
        urlStr += URLEncoder.encode(stnText, StandardCharsets.UTF_8);

        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;

        rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line).append("\n\r");
        }

        rd.close();
        urlConnection.disconnect();

        JsonUtil jsonUtil = new JsonUtil();
        Map<String, Object> resultMap = jsonUtil.dtoMapping(result.toString());

        return resultMap;
    }

    @RequestMapping("/json/findSubway2")
    public List<SubwayDTO> findSubway(String stnText, String subwayId) throws IOException, ParseException {
        List<SubwayDTO> resultList = new ArrayList<>();

        Map<String, Object> tmpMap = findSubway(stnText);
        List<SubwayDTO> subwayDTOList = (List<SubwayDTO>) tmpMap.get("subwayDTOList");

        for( SubwayDTO subway : subwayDTOList) {
            if( subwayId.equals(subway.getSubwayId()) ){
                resultList.add(subway);
            }
        }
        return resultList;
    }

}
