package jh.naverwebtoon.db.repository;

import java.util.List;
import jh.naverwebtoon.dto.response.FindWebtoonsByMemberRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class WebtoonRepositoryTest {
    @Autowired
    private WebtoonRepository webtoonRepository;

    @Test
    void 내_웹툰_조회() {
        List<FindWebtoonsByMemberRes> webtoons = webtoonRepository.findAllByMemberWithThumbnail(
                Long.valueOf(2));
        for (FindWebtoonsByMemberRes webtoon : webtoons) {
            System.out.println(webtoon);
        }
    }
}