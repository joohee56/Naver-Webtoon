package jh.naverwebtoon.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindRoundsByWebtoon {
    private List<RoundListDto> rounds;
    private int pageCount;
    private Long totalRoundCount;
}