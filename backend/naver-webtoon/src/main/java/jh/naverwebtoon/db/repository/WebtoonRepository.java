package jh.naverwebtoon.db.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import jh.naverwebtoon.db.domain.webtoon.Webtoon;
import jh.naverwebtoon.dto.response.FindWebtoonsByMemberRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WebtoonRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Webtoon webtoon) {
        em.persist(webtoon);
        return webtoon.getId();
    }

    public Webtoon findOne(Long id) {
        return em.find(Webtoon.class, id);
    }

    public Webtoon findOneWithThumbnail(Long webtoonId) {
        return em.createQuery("select w from Webtoon w"
                + " join fetch w.webtoonThumbnail wt"
                + " where w.id = :webtoonId", Webtoon.class)
                .setParameter("webtoonId", webtoonId)
                .getSingleResult();
    }

    /**
     * 작품관리 페이지에서 웹툰 조회
     */
    public List<FindWebtoonsByMemberRes> findAllByMemberWithThumbnail(Long memberId) {
        return em.createQuery("select new FindWebtoonsByMemberRes(w.id, w.name, w.webtoonThumbnail.posterImage.storeFileName, w.webtoonType, (select count(c) from Comment c where c.round.webtoon=w)) from Webtoon w"
                        + " where w.member.id = :memberId", FindWebtoonsByMemberRes.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    /**
     * 회차 등록 시 전체 웹툰 조회
     */
    public List<Object[]> findAllByMemberWithMaxRoundNumber(Long memberId) {
        return em.createQuery(
                        "select distinct w.id, w.name, (select max(r.roundNumber) from Round r where r.webtoon = w)"
                                + " from Webtoon w"
                                + " cross join Round r"
                                + " where w.member.id = :memberId")
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public Webtoon findOneWithThumbnailAndGenre(Long webtoonId) {
        return em.createQuery("select distinct w from Webtoon w"
                + " join fetch w.webtoonThumbnail"
                + " join fetch w.genres g"
                + " join fetch g.genre"
                + " where w.id = :webtoonId", Webtoon.class)
                .setParameter("webtoonId", webtoonId)
                .getSingleResult();
    }
}
