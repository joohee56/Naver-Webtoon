package jh.naverwebtoon.service;

import java.util.List;
import jh.naverwebtoon.db.domain.enums.WebtoonType;
import jh.naverwebtoon.dto.response.WebtoonRankingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class WebtoonRankingServiceTest {

    @Autowired
    private WebtoonRankingService service;

//    @Test
//    void 최신_웹툰_랭킹_조회() {
//        int offset=0, limit = 5;
//        WebtoonType webtoonType = WebtoonType.OFFICIAL;
//        List<WebtoonRankingDto> rankings = service.findRanking(offset, limit, webtoonType);
//        for (WebtoonRankingDto ranking : rankings) {
//            System.out.println(ranking.toString());
//        }
//    }
    @Test
    void 웹툰_랭킹_갱신_및_조회() {
        int offset=0, limit = 14;
        WebtoonType webtoonType = WebtoonType.OFFICIAL;
        System.out.println("첫 번째 갱신");
        List<WebtoonRankingDto> webtoons = service.updateRanking(offset, limit, webtoonType);
        for (WebtoonRankingDto webtoon : webtoons) {
            System.out.println(webtoon.toString());
        }

        System.out.println("두 번째 갱신");
        List<WebtoonRankingDto> webtoons2 = service.updateRanking(offset, limit, webtoonType);
        for (WebtoonRankingDto webtoon : webtoons2) {
            System.out.println(webtoon.toString());
        }
    }

}