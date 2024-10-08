package jh.naverwebtoon.web.controller;

import jakarta.validation.Valid;
import java.time.DayOfWeek;
import java.util.List;
import jh.naverwebtoon.db.domain.enums.GenreEnum;
import jh.naverwebtoon.db.domain.enums.SortingEnum;
import jh.naverwebtoon.db.repository.OfficialWebtoonRepository;
import jh.naverwebtoon.dto.request.CreateOfficialWebtoonReq;
import jh.naverwebtoon.dto.response.FindOfficialWebtoonsRes;
import jh.naverwebtoon.dto.response.FindWebtoonsByCondition;
import jh.naverwebtoon.service.OfficialWebtoonService;
import jh.naverwebtoon.service.WebtoonGenreService;
import jh.naverwebtoon.web.Auth;
import jh.naverwebtoon.web.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/webtoon/official")
@RequiredArgsConstructor
public class OfficialWebtoonController {
    private final OfficialWebtoonService officialWebtoonService;
    private final OfficialWebtoonRepository officialWebtoonRepository;
    private final WebtoonGenreService webtoonGenreService;

    /**
     *  정식 연재 웹툰 등록
     */
    @Auth
    @PostMapping(path = "/new",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long createWebtoon(@Login Long id, @Valid @ModelAttribute CreateOfficialWebtoonReq createOfficialWebtoonReq) {
        return officialWebtoonService.createOfficialWebtoon(id, createOfficialWebtoonReq);
    }

    /**
     * 웹툰 리스트 조회(전체), 장르별 조회
     * 인기순 / 업데이트순 정렬
     */
    @PostMapping()
    public List<FindOfficialWebtoonsRes> findAll(@RequestBody List<GenreEnum> genres, @RequestParam(name = "sorting") SortingEnum sorting) {
        if (genres == null || genres.get(0) == GenreEnum.ALL) {
            return officialWebtoonService.findAll(sorting);
        } else {
            return webtoonGenreService.findOfficialWebtoonsByGenre(sorting, genres);
        }
    }

    /**
     * 요일별 웹툰 조회
     */
    @GetMapping()
    public List<FindWebtoonsByCondition> findAllByDayOfWeek(@RequestParam("dayOfWeek") DayOfWeek dayOfWeek, @RequestParam(name = "sorting") SortingEnum sorting) {
        return officialWebtoonRepository.findAllByDayOfWeek(dayOfWeek, sorting);
    }


}
