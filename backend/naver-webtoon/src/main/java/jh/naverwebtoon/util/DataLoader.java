package jh.naverwebtoon.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jh.naverwebtoon.db.domain.Comment;
import jh.naverwebtoon.db.domain.Genre;
import jh.naverwebtoon.db.domain.Member;
import jh.naverwebtoon.db.domain.MergeManuscript;
import jh.naverwebtoon.db.domain.ProfileImage;
import jh.naverwebtoon.db.domain.Round;
import jh.naverwebtoon.db.domain.RoundThumbnail;
import jh.naverwebtoon.db.domain.UploadImage;
import jh.naverwebtoon.db.domain.WebtoonThumbnail;
import jh.naverwebtoon.db.domain.enums.CountryResidence;
import jh.naverwebtoon.db.domain.enums.Gender;
import jh.naverwebtoon.db.domain.enums.GenreEnum;
import jh.naverwebtoon.db.domain.enums.WebtoonType;
import jh.naverwebtoon.db.domain.webtoon.OfficialWebtoon;
import jh.naverwebtoon.db.domain.webtoon.Webtoon;
import jh.naverwebtoon.db.repository.GenreRepository;
import jh.naverwebtoon.db.repository.MemberRepository;
import jh.naverwebtoon.db.repository.RoundRepository;
import jh.naverwebtoon.db.repository.WebtoonRepository;
import jh.naverwebtoon.dto.request.CreateRoundReq;
import jh.naverwebtoon.dto.request.CreateWebtoonReq;
import jh.naverwebtoon.dto.request.JoinMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    @PersistenceContext
    private EntityManager em;
    private final MemberRepository memberRepository;
    private final RoundRepository roundRepository;
    private final GenreRepository genreRepository;
    private final WebtoonRepository webtoonRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Member
        initMember("joohee56", "1234", "joohee@naver.com", "이주희", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
        initMember("author1", "1234", "author1@naver.com", "정이나", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "작가_프로필_1.png" );
        initMember("author2", "1234", "author2@naver.com", "홍덕", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
        initMember("author3", "1234", "author3@naver.com", "모랑지", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "작가_프로필_2.png");
        initMember("challenger1", "1234", "challenger1@naver.com", "딱지 간호사", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "도전만화_프로필_1.png");

//        Genre
        initGenre();

//        Webtoon
        List<GenreEnum> genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.ROMANCE);
        genreEnums.add(GenreEnum.EMOTION);

        initOfficialWebtoon(Long.valueOf(3), "청춘 블라썸", WebtoonType.EPISODE, genreEnums, "\"푸르지 않아도 괜찮아!\"", "이제 막 청춘을 시작하고 있는 아이들.\n"
                + "그리고 마냥 아름답지만은 않은 그 시절의 기억들.\n"
                + "봄으로 가기 위한 그들의 성장통.\n"
                + "봄, 여름, 가을, 겨울... 사계절의 빛깔로 담아낸\n"
                + "풋풋하고 알싸한 아이들의 청춘 스토리.", "청춘 블라썸_커버.png", DayOfWeek.FRIDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.ROMANCE);
        initOfficialWebtoon(Long.valueOf(2), "세레나", WebtoonType.STORY, genreEnums, "\"너는 절대로 내 세레니티의 주인이 될 수 없어.\"", "세레니티 가문의 유일한 상속자가 된 세레나.\n"
                + "위태로워진 가문을 살리기 위해, 그녀의 할머니는 그녀를 왕국에서 가장 증오하는 남자와 결혼시켜버렸다.\n"
                + "무너져가던 세레나를 위로할 수 있는 건 오직 그녀의 애첩 프리드릭 뿐.\n"
                + "아름답고 찬란했던 세레니티의 그 여름날, 뜨거운 증오와 사랑으로 얽혀버린 세 사람의 이야기.", "webtoon-cover-sample.png", DayOfWeek.SATURDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.EMOTION);
        genreEnums.add(GenreEnum.ROMANCE);
        initOfficialWebtoon(Long.valueOf(4), "소녀의 세계", WebtoonType.STORY, genreEnums, null, "완벽해 보이지만 사실 외로웠던 백조들과 맘씨 착한 오리가 만나\n"
                + "여러 갈등을 함께 겪으며 진짜 친구가 되어가는 소녀들의 찐 우정물", "소녀의 세계_커버.png", DayOfWeek.MONDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.EMOTION);
        initOfficialWebtoon(Long.valueOf(4), "괜찮니 얘들아?", WebtoonType.STORY, genreEnums, null, "본 컨텐츠는 보건복지부와 중앙자살예방센터의 브랜드 웹툰으로\n"
                + "모랑지 작가가 전하는 괜찮니? 캠페인 입니다.", "괜찮니 얘들아_커버.png", DayOfWeek.MONDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.DAILY_LIFE);
        initOfficialWebtoon(Long.valueOf(2), "그냥 선생님", WebtoonType.EPISODE , genreEnums, "선생님 집은 학교 아니에요? 선생님도 집이 있어요?", "우리들 모두의 학창 시절, 언제나 그 자리에 있을 거만 같은 선생님들.\n"
                + "수업이 끝난 교실, 학교 바깥. 그냥 선생님들의 평범하고 사랑스러운 일상,\n"
                + "\n"
                + "일상 로맨스 <그냥 선생님>", "그냥 선생님_커버.png", DayOfWeek.TUESDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.ROMANCE);
        genreEnums.add(GenreEnum.FANTASY);
        initOfficialWebtoon(Long.valueOf(3), "베이비 폭군", WebtoonType.STORY, genreEnums, null, "가질 수 없었던 화목한 가정, 다정한 부모님.\n"
                + "비참한 결말 끝에 눈을 떠 보니, 환생했다.\n"
                + "그것도 제국의 공주로!", "베이비 폭군_커버.png", DayOfWeek.WEDNESDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.ROMANCE);
        initOfficialWebtoon(Long.valueOf(4), "사내연애 사절!", WebtoonType.STORY , genreEnums, null, "첫사랑에서 친구로, 친구에서 동료로,\n"
                + "역행하는 관계 속에서 솔직한 내 마음은 '사내연애 사절!'", "사내연애 사절_커버.png", DayOfWeek.THURSDAY);

        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.ROMANCE);
        genreEnums.add(GenreEnum.DRAMA);
        initOfficialWebtoon(Long.valueOf(2), "시월드가 내게 집착한다", WebtoonType.STORY, genreEnums, null, "사랑했던 가족들이 나를 죽였다.\n"
                + "과거로 돌아온 나는 내 목숨과 유산을 지키기로 결심하고 라피레온 대공을 찾아갔다.\n"
                + "그런데 이 대공가, 심상치 않다.\n"
                + "\n"
                + "무사히 복수를 마치고, 이혼할 수 있을까?", "시월드가 내게 집착한다_커버.png", DayOfWeek.SUNDAY);

        //도전만화 등록
        genreEnums = new ArrayList<>();
        genreEnums.add(GenreEnum.EMOTION);
        genreEnums.add(GenreEnum.DAILY_LIFE);
        initWebtoon(Long.valueOf(5), "오직 나의 이름으로", WebtoonType.EPISODE, genreEnums, "", "내 이름은 딱지다. 내 왼쪽 가슴의 휘장 때문이다. "
                + "‘RN: Registered Nurse (공인 등록 간호사)’ 간호사 국가고시에 합격한 정식 간호사를 상징하는 휘장. "
                + "‘RN’마크가 달린 휘장은 스스로에게 자부심과 자긍심을 느끼게도 하지만 때론, 그 휘장이 주홍글씨처럼 왼쪽 가슴에 박혀 딱지로 느껴질 때가 있다. "
                + "무조건적인 헌신과 희생을 바라는 사람들. 그리고 내가 아닌 다른 무언가로 불려지는 순간들. "
                + "‘RN'휘장과 'RN'딱지의 경계를 넘나드는 '정신병원’ 신규시절 딱지 간호사의 일상은 과연 어떨까?", "오직 나의 이름으로_커버.png");

//        Round
        initRound(Long.valueOf(2), "세레나_1화_썸네일.png", "세레나_1화_원고.png", "세레니티의 소녀", ".");
        initRound(Long.valueOf(2), "세레나_2화_썸네일.png", "세레나_2화_원고.png", "두 주인",".");
        initRound(Long.valueOf(2), "세레나_3화_썸네일.png", "세레나_3화_원고.png", "이안사",".");
        initRound(Long.valueOf(2), "세레나_4화_썸네일.png", "세레나_4화_원고.png", "늙은 경영자와 어린 소녀",".");
        initRound(Long.valueOf(2), "세레나_5화_썸네일.png", "세레나_5화_원고.png", "유리 화원(1)",".");
        initRound(Long.valueOf(2), "세레나_6화_썸네일.png", "세레나_6화_원고.png", "유리 화원(2)",".");
        initRound(Long.valueOf(2), "세레나_7화_썸네일.png", "세레나_7화_원고.png", "유리 화원(3)",".");
        initRound(Long.valueOf(2), "세레나_8화_썸네일.png", "세레나_8화_원고.png", "나쁜 놈","이제부터 본 이야기 시작!");
        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "이거 완전 공주님이네", "작중 '마리안느 드생'의 그림은 5화에서 살짝 등장했었답니다:)");

//        Comment
        initComment(Long.valueOf(1), Long.valueOf(9), "근데 솔직히 세레나가 쓸데없는 자존심부리는건 맞지 않음? 경영권 상속이 원래 세레나한테 가야하는게 맞지만 세레나는 능력이 없고 오히려 사고만 쳤다는데 아이저가 저만큼 키우고 이제 가르쳐 주겠다는데 세레나는 진짜 너무 생각없이 행동함" );
        initComment(Long.valueOf(3), Long.valueOf(9), "..저정도면 남주가 세레니티 더 아끼는거 같은데");
        initComment(Long.valueOf(4), Long.valueOf(9), "남주 말 다 맞다고 본다~~");
        initComment(Long.valueOf(5), Long.valueOf(9), "와 보통 저런 상황 오면 공주님 안기하지 않나 냅다 의자를 걍 번쩍 들어버려서 개놀랬네");
        initComment(Long.valueOf(1), Long.valueOf(9), "다음화..!!!");
        initComment(Long.valueOf(3), Long.valueOf(9), "드라마로 제작되면 좋겠다");
    }



    public void initMember(String loginId, String password, String emailAddress, String name, LocalDate birthDate, Gender gender, CountryResidence countryResidence, String phoneNumber, String storeFileName) {
        JoinMemberReq joinMemberReq = new JoinMemberReq();
        joinMemberReq.setLoginId(loginId);
        joinMemberReq.setPassword(password);
        joinMemberReq.setEmailAddress(emailAddress);
        joinMemberReq.setName(name);
        joinMemberReq.setBirthDate(birthDate);
        joinMemberReq.setGender(gender);
        joinMemberReq.setCountryResidence(countryResidence);
        joinMemberReq.setPhoneNumber(phoneNumber);
        Member member = Member.createMember(joinMemberReq);

        ProfileImage profileImage = ProfileImage.createProfileImage(new UploadImage(storeFileName, storeFileName));
        member.changeProfileImage(profileImage);
        em.persist(member);
    }

    public void initGenre() {
        for (GenreEnum genreEnum : GenreEnum.values()) {
            Genre genre = Genre.create(genreEnum);
            em.persist(genre);
        }
    }

    public void initOfficialWebtoon(Long memberId, String name, WebtoonType webtoonType, List<GenreEnum> genreEnums, String oneLineSummary, String summary, String storeFileName, DayOfWeek dayOfWeek)
            throws IOException {
        Member member = memberRepository.findOne(memberId);
        CreateWebtoonReq createWebtoonReq = new CreateWebtoonReq(name, webtoonType, new ArrayList<>(), genreEnums, oneLineSummary, summary, null, null);
        List<Genre> genres = createWebtoonReq.getGenres().stream()
                .map(genreEnum -> genreRepository.findByGenreEnum(genreEnum))
                .collect(Collectors.toList());
        WebtoonThumbnail webtoonThumbnail = WebtoonThumbnail.create(new UploadImage(storeFileName, storeFileName), new UploadImage(storeFileName, storeFileName));
        OfficialWebtoon officialWebtoon = new OfficialWebtoon(member, createWebtoonReq, genres, webtoonThumbnail, dayOfWeek);
        em.persist(officialWebtoon);
    }

    public void initWebtoon(Long memberId, String name, WebtoonType webtoonType, List<GenreEnum> genreEnums, String oneLineSummary, String summary, String storeFileName) throws IOException {
        Member member = memberRepository.findOne(memberId);
        CreateWebtoonReq createWebtoonReq = new CreateWebtoonReq(name, webtoonType, new ArrayList<>(), genreEnums, oneLineSummary, summary, null, null);
        List<Genre> genres = createWebtoonReq.getGenres().stream()
                .map(genreEnum -> genreRepository.findByGenreEnum(genreEnum))
                .collect(Collectors.toList());
        WebtoonThumbnail webtoonThumbnail = WebtoonThumbnail.create(new UploadImage(storeFileName, storeFileName), new UploadImage(storeFileName, storeFileName));
        Webtoon webtoon = Webtoon.create(member, createWebtoonReq, genres, webtoonThumbnail);
        em.persist(webtoon);
    }

    public void initRound(Long webtoonId, String thumbnail, String manuscript, String title, String authorNote) {
        Webtoon webtoon = webtoonRepository.findOne(webtoonId);
        RoundThumbnail roundThumbnail = RoundThumbnail.create(new UploadImage(thumbnail,thumbnail));
        MergeManuscript mergeManuscript = MergeManuscript.create(new UploadImage(manuscript, manuscript));
        CreateRoundReq roundReq = new CreateRoundReq();
        roundReq.setRoundTitle(title);
        roundReq.setAuthorNote(authorNote);

        Round round = Round.create(roundReq, webtoon, roundThumbnail, new ArrayList<>(), mergeManuscript);
        em.persist(round);
    }

    public void initComment(Long memberId, Long roundId, String content) {
        Member member = memberRepository.findOne(memberId);
        Round round = roundRepository.findOne(roundId);
        Comment comment = Comment.create(member, round, content);
        em.persist(comment);
    }
}