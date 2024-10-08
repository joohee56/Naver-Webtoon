//package jh.naverwebtoon.util;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import jh.naverwebtoon.db.domain.Member;
//import jh.naverwebtoon.db.domain.MergeManuscript;
//import jh.naverwebtoon.db.domain.ProfileImage;
//import jh.naverwebtoon.db.domain.Round;
//import jh.naverwebtoon.db.domain.RoundLike;
//import jh.naverwebtoon.db.domain.RoundThumbnail;
//import jh.naverwebtoon.db.domain.UploadImage;
//import jh.naverwebtoon.db.domain.WebtoonThumbnail;
//import jh.naverwebtoon.db.domain.Comment;
//import jh.naverwebtoon.db.domain.comment.CommentDislike;
//import jh.naverwebtoon.db.domain.comment.CommentLike;
//import jh.naverwebtoon.db.domain.enums.CountryResidence;
//import jh.naverwebtoon.db.domain.enums.Gender;
//import jh.naverwebtoon.db.domain.enums.GenreEnum;
//import jh.naverwebtoon.db.domain.enums.WebtoonCategory;
//import jh.naverwebtoon.db.domain.webtoon.Webtoon;
//import jh.naverwebtoon.db.repository.CommentRepository;
//import jh.naverwebtoon.db.repository.MemberRepository;
//import jh.naverwebtoon.db.repository.RoundRepository;
//import jh.naverwebtoon.db.repository.WebtoonRepository;
//import jh.naverwebtoon.dto.request.CreateRoundReq;
//import jh.naverwebtoon.dto.request.CreateWebtoonReq;
//import jh.naverwebtoon.dto.request.JoinMemberReq;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@Transactional
//@RequiredArgsConstructor
//public class DataLoader implements ApplicationRunner {
//    @PersistenceContext
//    private EntityManager em;
//    private final MemberRepository memberRepository;
//    private final RoundRepository roundRepository;
//    private final WebtoonRepository webtoonRepository;
//    private final CommentRepository commentRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
////        Member
//        initMember("joohee56", "1234", "joohee@naver.com", "이주희", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("author1", "1234", "author1@naver.com", "정이나", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "작가_프로필_1.png" );
//        initMember("author2", "1234", "author2@naver.com", "홍덕", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author3", "1234", "author3@naver.com", "모랑지", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "작가_프로필_2.png");
//        initMember("challenger1", "1234", "challenger1@naver.com", "딱지 간호사", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "도전만화_프로필_1.png");
//        initMember("author4", "1234", "author4@naver.com", "유유", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author5", "1234", "author5@naver.com", "자유", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author6", "1234", "author6@naver.com", "승우", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author7", "1234", "author7@naver.com", "이선", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author8", "1234", "author8@naver.com", "두부", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author9", "1234", "author9@naver.com", "남수", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author10", "1234", "author10@naver.com", "민송아", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author11", "1234", "author11@naver.com", "자까", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author12", "1234", "author12@naver.com", "조석", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author13", "1234", "author13@naver.com", "UMI", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author14", "1234", "author14@naver.com", "JP", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//        initMember("author15", "1234", "author15@naver.com", "SIU", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "default-profile-image.png");
//
//        initMember("user1", "1234", "user1@naver.com", "이헤연", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user2", "1234", "user2@naver.com", "최민준", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user3", "1234", "user3@naver.com", "이준성", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user4", "1234", "user4@naver.com", "김민규", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user5", "1234", "user5@naver.com", "도민준", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user6", "1234", "user6@naver.com", "남영", LocalDate.of(1999, 9, 19), Gender.MALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user7", "1234", "user7@naver.com", "정하윤", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user8", "1234", "user8@naver.com", "한가은", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user9", "1234", "user9@naver.com", "이시아", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//        initMember("user10", "1234", "user10@naver.com", "강이서", LocalDate.of(1999, 9, 19), Gender.FEMALE, CountryResidence.LOCAL, "010-1234-5678", "jjanggu-profile-image.png" );
//
////        Webtoon
//        List<GenreEnum> genreEnums = new ArrayList<>();
//
//        /*
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.EMOTION);
//
//        initOfficialWebtoon(Long.valueOf(3), "청춘 블라썸", WebtoonCategory.EPISODE, genreEnums, "\"푸르지 않아도 괜찮아!\"", "이제 막 청춘을 시작하고 있는 아이들.\n"
//                + "그리고 마냥 아름답지만은 않은 그 시절의 기억들.\n"
//                + "봄으로 가기 위한 그들의 성장통.\n"
//                + "봄, 여름, 가을, 겨울... 사계절의 빛깔로 담아낸\n"
//                + "풋풋하고 알싸한 아이들의 청춘 스토리.", "청춘 블라썸_커버.png", DayOfWeek.FRIDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        initOfficialWebtoon(Long.valueOf(2), "세레나", WebtoonCategory.STORY, genreEnums, "\"너는 절대로 내 세레니티의 주인이 될 수 없어.\"", "세레니티 가문의 유일한 상속자가 된 세레나.\n"
//                + "위태로워진 가문을 살리기 위해, 그녀의 할머니는 그녀를 왕국에서 가장 증오하는 남자와 결혼시켜버렸다.\n"
//                + "무너져가던 세레나를 위로할 수 있는 건 오직 그녀의 애첩 프리드릭 뿐.\n"
//                + "아름답고 찬란했던 세레니티의 그 여름날, 뜨거운 증오와 사랑으로 얽혀버린 세 사람의 이야기.", "webtoon-cover-sample.png", DayOfWeek.SATURDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.EMOTION);
//        genreEnums.add(GenreEnum.ROMANCE);
//        initOfficialWebtoon(Long.valueOf(4), "소녀의 세계", WebtoonCategory.STORY, genreEnums, "", "완벽해 보이지만 사실 외로웠던 백조들과 맘씨 착한 오리가 만나\n"
//                + "여러 갈등을 함께 겪으며 진짜 친구가 되어가는 소녀들의 찐 우정물", "소녀의 세계_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.EMOTION);
//        initOfficialWebtoon(Long.valueOf(4), "괜찮니 얘들아?", WebtoonCategory.STORY, genreEnums, "", "본 컨텐츠는 보건복지부와 중앙자살예방센터의 브랜드 웹툰으로\n"
//                + "모랑지 작가가 전하는 괜찮니? 캠페인 입니다.", "괜찮니 얘들아_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initOfficialWebtoon(Long.valueOf(2), "그냥 선생님", WebtoonCategory.EPISODE , genreEnums, "선생님 집은 학교 아니에요? 선생님도 집이 있어요?", "우리들 모두의 학창 시절, 언제나 그 자리에 있을 거만 같은 선생님들.\n"
//                + "수업이 끝난 교실, 학교 바깥. 그냥 선생님들의 평범하고 사랑스러운 일상,\n"
//                + "\n"
//                + "일상 로맨스 <그냥 선생님>", "그냥 선생님_커버.png", DayOfWeek.TUESDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.FANTASY);
//        initOfficialWebtoon(Long.valueOf(3), "베이비 폭군", WebtoonCategory.STORY, genreEnums, "", "가질 수 없었던 화목한 가정, 다정한 부모님.\n"
//                + "비참한 결말 끝에 눈을 떠 보니, 환생했다.\n"
//                + "그것도 제국의 공주로!", "베이비 폭군_커버.png", DayOfWeek.WEDNESDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        initOfficialWebtoon(Long.valueOf(4), "사내연애 사절!", WebtoonCategory.STORY , genreEnums, "", "첫사랑에서 친구로, 친구에서 동료로,\n"
//                + "역행하는 관계 속에서 솔직한 내 마음은 '사내연애 사절!'", "사내연애 사절_커버.png", DayOfWeek.THURSDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(2), "시월드가 내게 집착한다", WebtoonCategory.STORY, genreEnums, "", "사랑했던 가족들이 나를 죽였다.\n"
//                + "과거로 돌아온 나는 내 목숨과 유산을 지키기로 결심하고 라피레온 대공을 찾아갔다.\n"
//                + "그런데 이 대공가, 심상치 않다.\n"
//                + "\n"
//                + "무사히 복수를 마치고, 이혼할 수 있을까?", "시월드가 내게 집착한다_커버.png", DayOfWeek.SUNDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.COMEDY);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initOfficialWebtoon(Long.valueOf(14), "마음의소리2", WebtoonCategory.STORY, genreEnums, "", "'마음의소리' 완결 후 3년, 조석 작가의 결코 소소하지 않은 일상(?) 대공개!\n"
//                + "제목은... '너는 그냥 개그만화나 그려라'\n"
//                + "(였는데 다들 '마음의소리2'라 불러서 제목 바꿈)","마음의소리2_커버.png", DayOfWeek.MONDAY);
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.EMOTION);
//        initOfficialWebtoon(Long.valueOf(6), "같은 학교 친구", WebtoonCategory.STORY, genreEnums, "", "항상 바른 자세를 하는 같은 반 친구 겨울이.\n"
//                + "요한이는 그런 겨울이가 왠지 신경 쓰인다.\n"
//                + "그때 마침 짝이 된 두 사람. 가까워진 자리만큼 마음의 거리가 좁혀져 간다.\n"
//                + "두근대는 심장 소리.\n"
//                + "피어오르는 얼굴의 이 열기를 뭐라고 부르면 좋은 걸까?\n"
//                + "어쩔 줄 모르는 소년소녀의 첫사랑 이야기.","같은 학교 친구_커버.png", DayOfWeek.TUESDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(7), "묘약마녀", WebtoonCategory.STORY, genreEnums, "", "약제사 바나는 블레록 시에서 작은 약초 상점을 운영하고 있다.\n"
//                + "이 마을에는 밤만 되면 저주를 걸고 사라지는 ‘마녀 레이븐’이란 존재가 있어,\n"
//                + "바나는 마녀의 저주를 푸는 약을 자주 의뢰받고는 한다.\n"
//                + "그러던 어느 날, 한 경관이 바나를 찾아오는데…. 사실 마녀 레이븐의 정체는?!","묘약마녀_커버.png", DayOfWeek.WEDNESDAY);
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.EMOTION);
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(9), "개를 낳았다", WebtoonCategory.STORY, genreEnums, "", "사랑스러운 너와의 첫 만남부터 이별까지.\n"
//                + "처음으로 반려견을 키우게 된 다나와 모든것이 처음인 강아지 명동이가 만나 함께 살아가는 이야기.\n"
//                + "강아지 수명 20년. 너와 내가 함께하는 20년 동안 우린 어떤 일을 겪게 될까?","개를 낳았다_커버.png", DayOfWeek.THURSDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        genreEnums.add(GenreEnum.COMEDY);
//        initOfficialWebtoon(Long.valueOf(13), "신혼일기", WebtoonCategory.STORY, genreEnums, "", "이젠 갠플이 아니라 팀플이다!\n"
//                + "조별 과제와 차원이 다른 인생을 건 팀플이 시작된다.\n"
//                + "1인가구에서 2인가구로 성장한 자까 작가의 결혼 이야기.","신혼일기_커버.png", DayOfWeek.FRIDAY);
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        genreEnums.add(GenreEnum.ROMANCE);
//        initOfficialWebtoon(Long.valueOf(12), "나노리스트", WebtoonCategory.STORY, genreEnums, "", "내게 날아온 달콤살벌한 선물 나노\n"
//                + "안드로이드들의 비밀을 밝혀라!","나노리스트_커버.png", DayOfWeek.SATURDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        genreEnums.add(GenreEnum.ACTION);
//        initOfficialWebtoon(Long.valueOf(15), "전지적 독자 시점", WebtoonCategory.STORY, genreEnums, "", "'이건 내가 아는 그 전개다'\n"
//                + "한순간에 세계가 멸망하고, 새로운 세상이 펼쳐졌다.\n"
//                + "오직 나만이 완주했던 소설 세계에서 평범했던 독자의 새로운 삶이 시작된다.","전지적 독자 시점_커버.png", DayOfWeek.SUNDAY);
//
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(16), "재벌집 막내아들", WebtoonCategory.STORY, genreEnums, "", "화제의 드라마 원작 웹툰!]\n"
//                + "13년 동안의 수고를 배신으로 돌려받다니!\n"
//                + "머슴처럼 살다 버려진 순양그룹의 실장, 윤현우.\n"
//                + "모든 게 끝났다 싶었을 즘, 순양그룹 진 회장의 손주 진도준으로 깨어난다!\n"
//                + "하지만 상속권과는 거리가 먼 재벌집 막내아들 진도준.\n"
//                + "과연 그는 가족 정치극에서 최후의 승자가 될 수 있을 것인가!","재벌집 막내아들_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(17), "신의 탑", WebtoonCategory.STORY, genreEnums, "", "자신의 모든 것이었던 소녀를 쫓아 탑에 들어온 소년\n"
//                + "그리고 그런 소년을 시험하는 탑","신의 탑_커버.png", DayOfWeek.TUESDAY);
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(17), "뷰티풀 군바리", WebtoonCategory.STORY, genreEnums, "", "'여자도 군대에 간다면?'본격 여자도 군대 가는 만화!","뷰티풀 군바리_커버.png", DayOfWeek.MONDAY);
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ACTION);
//        initOfficialWebtoon(Long.valueOf(17), "참교육", WebtoonCategory.STORY, genreEnums, "", "무너진 교권을 지키기 위해 교권보호국 소속 나화진의 참교육이 시작된다!\n"
//                + "<부활남> 채용택 작가 X <신석기녀> 한가람 작가의 신작!","참교육_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        genreEnums.add(GenreEnum.EMOTION);
//        initOfficialWebtoon(Long.valueOf(17), "백수세끼", WebtoonCategory.STORY, genreEnums, "", "백수 시절 내 곁을 지켜줬던 그녀... 돌아와 주면 안 되겠니?\n"
//                + "음식 메뉴마다 담겨 있는 우리들의 연애 흑역사!","백수세끼_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(17), "왕과의 야행", WebtoonCategory.STORY, genreEnums, "", "젊은 왕과 아름다운 여인이 발을 사이에 두고 앉아있다.\n"
//                + "가느다란 흰 손가락으로 책장을 넘기는 여인은\n"
//                + "고혹적인 목소리로 글을 읽어 내려가는데...","왕과의 야행_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(17), "퀘스트지상주의", WebtoonCategory.STORY, genreEnums, "", "[외모지상주의], [싸움독학], [인생존망]과 세계관을 공유하는 작품!\n"
//                + "공부, 싸움, 외모.\n"
//                + "뭐 하나 잘난 것 없는 평범한 고등학생 ‘김수현’의 눈앞에 갑자기 퀘스트창이 나타났다!\n"
//                + "첫 번째 퀘스트, [엄마한테 사과하기]를 완료한 수현은 보상으로 키가 3cm 커지게 되는데!\n"
//                + "퀘스트 엄청 쉽잖아?! 어떤 퀘스트든 완료해주마! 그런데 다음 퀘스트가?\n"
//                + "[system] 학교 일진녀와 키스하십시오","퀘스트지상주의_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.SPORTS);
//        initOfficialWebtoon(Long.valueOf(17), "윈드브레이커", WebtoonCategory.STORY, genreEnums, "", "혼자서 자전거를 즐겨타던 모범생 조자현.\n"
//                + "원치 않게 자전거 크루의 일에 자꾸 휘말리게 되는데...\n"
//                + "자유를 꿈꾸는 청춘들의 스트릿라이딩 드라마!","윈드브레이커_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        initOfficialWebtoon(Long.valueOf(17), "신화급 귀속 아이템을 손에 넣었다", WebtoonCategory.STORY, genreEnums, "", "D급 무투계 레이더로 마법계 레이더들의 고기방패나 하며 별 볼 일 없이 살던 재현.\n"
//                + "그러던 어느 날, 던전에서 우연히 \"오딘의 눈\" 이라는 최강의 귀속 아이템을 얻게 됐다.\n"
//                + "신의 눈을 가진 자, 세계를 구할 신의 대적자의 운명을 개척하라!","신화급 귀속 아이템을 손에 넣었다_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        initOfficialWebtoon(Long.valueOf(17), "버림받은 왕녀의 은밀한 침실", WebtoonCategory.STORY, genreEnums, "", "한때는 추앙받았지만 지금은 비참하게 버림받은 왕녀 르웰린. 아무도 보호해 주지 않는 그녀에게 추악한 저주가 내려진다.\n"
//                + "그것은 바로 남자를 욕망하게 되는 저주.\n"
//                + "르웰린은 저주의 폭주를 막기 위해 결국 자신의 침실을 열게 되는데...\n"
//                + "버림받은 왕녀와 얽히고 설키는 네명의 남자들.\n"
//                + "저주의 진실은 밝혀질 것인가? 그리고 그녀와 함께 할 사내는 과연 누가 될 것인가?","버림받은 왕녀의 은밀한 침실_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.DRAMA);
//        initOfficialWebtoon(Long.valueOf(17), "팔이피플", WebtoonCategory.STORY, genreEnums, "", "<마스크걸>, <위대한 방옥숙> 매미/희세 작가의 신작!\n"
//                + "SNS에서 육아용품 파는 평범한 유부녀 박주연, 그녀의 고등학교 동창인 김예희는 팔로워 70만의 셀럽으로 엄청난 부와 명성을 누리는 중이다.\n"
//                + "박주연은 김예희를 미워하는 동시에 집착하고 있는데, 과연 그녀는 김예희의 과거를 폭로하고 셀럽으로 올라설 수 있을까?","팔이피플_커버.png", DayOfWeek.MONDAY);
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.MARTIAL_ARTS_AND_HISTORICAL);
//        initOfficialWebtoon(Long.valueOf(17), "절대 검감", WebtoonCategory.STORY, genreEnums, "", "단전이 부숴졌다는 이유로 집에서는 내놓은 자식 취급을 받던 소운휘는 혈교에 납치되어서도 삼류 첩자로 살아왔다.\n"
//                + "어느 날, 전설로만 알려진 검선비록을 찾는데 이용당하다 죽은 운휘는 10년 전, 혈교에 납치되던 그 날로 돌아가게 되고 검의 목소리를 듣는 신비한 능력을 얻는다.","절대검감_커버.png", DayOfWeek.MONDAY);
//
//        */
//
//
//        //Challenge Webtoon
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.EMOTION);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(5), "오직 나의 이름으로", WebtoonCategory.EPISODE, genreEnums, "", "내 이름은 딱지다. 내 왼쪽 가슴의 휘장 때문이다. "
//                + "‘RN: Registered Nurse (공인 등록 간호사)’ 간호사 국가고시에 합격한 정식 간호사를 상징하는 휘장. "
//                + "‘RN’마크가 달린 휘장은 스스로에게 자부심과 자긍심을 느끼게도 하지만 때론, 그 휘장이 주홍글씨처럼 왼쪽 가슴에 박혀 딱지로 느껴질 때가 있다. "
//                + "무조건적인 헌신과 희생을 바라는 사람들. 그리고 내가 아닌 다른 무언가로 불려지는 순간들. "
//                + "‘RN'휘장과 'RN'딱지의 경계를 넘나드는 '정신병원’ 신규시절 딱지 간호사의 일상은 과연 어떨까?", "오직 나의 이름으로_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.EMOTION);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(2), "태권 반갑습니다!", WebtoonCategory.EPISODE, genreEnums, "", "우당탕탕 오늘도 평화로운 태권도장 이야기", "태권 반갑습니다_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(2), "외계에서 온 지구인", WebtoonCategory.EPISODE, genreEnums, "", "평범하디 평범한 고등학생 이은조. 딱 하나 특별한 점이 있다면.....집에 돌아가면 밥을 차려주는 부모님, 아니 외계인이 있다는 점이다!", "외계에서 온 지구인_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.COMEDY);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(2), "고고고", WebtoonCategory.EPISODE, genreEnums, "", "\"너, 내 집사가 되어라!\" 어느 날 갑자기 고양이 세 마리의 간택을 받게 된 집사! 겉모습만큼 성격도 가지각색인 고양이 세 마리와 집사의 털 날리는 일상 이야기. 주 1회 자유연재 / 인스타 @kkyul_jmt / 메일 ehowlgldus@naver.com", "고고고_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.FANTASY);
//        genreEnums.add(GenreEnum.MARTIAL_ARTS_AND_HISTORICAL);
//        initWebtoon(Long.valueOf(5), "화온의 세계에 내려와", WebtoonCategory.EPISODE, genreEnums, "", "\"만물을 창조하신 당신의 이름을 붙여, 우리들은 이곳을... '화온의 세계'라 부르겠나이다!\" . . . 건국 신화 속 신 '화온'을 모시는 세상에서, 감히 그를 모욕한 왕이 있었으니 그는 곧 쿠데타를 일으킨 이에게 쫓기는 신세가 된다. 하지만 도망자 신분이 된 백유신은 멈추지 않고 하늘의 신 화온을 찾아 죽이려 하는데... 신의 발자취를 쫓으며 괴이한 일들을 마주치는 유신 일행은 과연 화온을 찾을 수 있을까?", "화온의 세계에 내려와_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.COMEDY);
//        initWebtoon(Long.valueOf(5), "조금 수상한 연애시뮬레이션", WebtoonCategory.EPISODE, genreEnums, "", "미연시의 주인공이 되었는데 축복이 아니라 저주같다 (자유연재)", "조금 수상한 연애시뮬레이션_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.SPORTS);
//        initWebtoon(Long.valueOf(5), "클리너", WebtoonCategory.EPISODE, genreEnums, "", "중학교시절 부터 각광받던 인재였던 백 수. 약팀인 바다고에 입학한 그는 엄청난 활약으로 바다고를 강팀으로 이끌어낸다. 그러다 돌연, 백 수는 '어떤 사건'으로 인해 선수를 그만두게 되는데... 과연 그는 다시 농구부에 복귀하여 목표를 이뤄낼 수 있을것인가?!", "클리너_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.THRILLER);
//        initWebtoon(Long.valueOf(5), "요람에서 무덤까지", WebtoonCategory.EPISODE, genreEnums, "", "이 곳은 거대한 교육시설 요람. 이 시대의 모든 아이는 50층에서 태어나 상층을 목표로 나아간다. 그리고 오직 100층에 도달한 완벽한 아이만이 완벽한 어른이 된다. <완벽한 아이를 만들어내는 수수께끼의 기관 요람의 비밀을 파헤치는 이야기>", "요람에서 무덤까지_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.COMEDY);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(5), "어시스턴트입니다", WebtoonCategory.EPISODE, genreEnums, "", "존경하는 작가님의 어시스턴트로 들어왔으나, 내가 생각한 것과는 많이 다른 작가님의 모습...? 웹툰 작가와 어시스턴트의 일상 러브 코미디! *1인 제작이라 업로드가 늦습니다.*", "어시스턴트입니다_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.COMEDY);
//        initWebtoon(Long.valueOf(5), "청춘은 바로 지금!", WebtoonCategory.EPISODE, genreEnums, "", "특출난 미모로 인기를 한 몸에 받아온 정유아. 근데... 인기가 많아도 너무 많잖아?! 언제나 끊임없이 떠받드는 사람들에게 이리 치이고 저리 치여 지쳐갈 때쯤, 험악한 분위기 때문에 아무도 다가가지 않는 강우주를 만난다. 그래, 이거다!! 누구에게나 사랑받는 정유아와 그 누구도 다가가려하지 않는 강우주의 우당탕탕 학원 로맨스 코미디!", "청춘은 바로 지금_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DRAMA);
//        initWebtoon(Long.valueOf(5), "너나들이", WebtoonCategory.EPISODE, genreEnums, "", "연애보다는 자기 일이 가장 좋은 남녀. 자기 실력을 인정받고 자기 일이 가장 좋은 아트디렉터 \\'유봄\\', 실력있고 인정받는 아이돌가수에서 홀로서기를 하며 일 좋아하고 사람좋아하는 가수 \\'김태식\\' 자기 일이 가장 중요하고 자기 생활이 가장 중요한 남녀의 연애 이야기", "너나들이_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DRAMA);
//        initWebtoon(Long.valueOf(5), "사지선다", WebtoonCategory.EPISODE, genreEnums, "", "리메이크 연재 시작합니다. 도전만화 [사지선다]에서 감상하실 수 있습니다!0", "사지전다_커버.png");
//
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.MARTIAL_ARTS_AND_HISTORICAL);
//        initWebtoon(Long.valueOf(5), "만월에 핀 연꽃", WebtoonCategory.EPISODE, genreEnums, "", "고려 16대 황제 예종과 제 2비 순덕황후의 사랑이야기", "만월에 핀 연꽃_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(5), "그림그리기 좋은날", WebtoonCategory.EPISODE, genreEnums, "", "학원 성장물을 빙자한 학원 연애물", "그림그리기 좋은날_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DAILY_LIFE);
//        initWebtoon(Long.valueOf(5), "별의별", WebtoonCategory.EPISODE, genreEnums, "", "잘생긴 외모로 인기가 많지만 연애는 해본 적 없는 모태솔로 김준혁, 상냥하고 바른 성격으로 모두가 좋아하지만 연애를 꺼리는 인서은. 서로에게 호감을 느낀 둘은 어떻게 가까워질 수 있을까? 서툴지만 결코 얕지 않은 10대 청소년들의 성장스토리를 다룬 이야기.", "별의별_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DRAMA);
//        initWebtoon(Long.valueOf(5), "솔의 일기", WebtoonCategory.EPISODE, genreEnums, "", "이 험한 세상에서 내 편이 되어주어야 할 가족이 가장 위험한 존재라면... 어린 시절부터 남들과는 조금 다른 경험을 해온 솔이. 출구가 없는 어두운 터널을 지나는 솔이는 과연 터널을 무사히 빠져나갈 수 있을까? (자유연재)", "솔의 일기_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.DRAMA);
//        initWebtoon(Long.valueOf(5), "이상적인 관계", WebtoonCategory.EPISODE, genreEnums, "", "훈훈한 남사친들과 한지붕에서 동거시작! 그러나 첫날부터 충격적인 장면을 보게 되는데.. 이상한 관계의 우리들! 고백팔찌의 진실은?", "이상적인 관계_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.MARTIAL_ARTS_AND_HISTORICAL);
//        initWebtoon(Long.valueOf(5), "발자국이 녹기 전에", WebtoonCategory.EPISODE, genreEnums, "", "세상에 의한 아픔을 가진 옛 사람들의 사랑이야기", "발자국이 녹기 전에_커버.png");
//
//        genreEnums = new ArrayList<>();
//        genreEnums.add(GenreEnum.ROMANCE);
//        genreEnums.add(GenreEnum.EMOTION);
//        initWebtoon(Long.valueOf(5), "잘가, 좋은 아침이야", WebtoonCategory.EPISODE, genreEnums, "", "어릴 적에 살던 고향으로 돌아와 옛 친구들을 다시 만나며 펼쳐지는 초호화! 순정! 학원물! 로맨스!(자유연재)", "잘가 좋은 아침이야_커버.png");
//
//
//
////        Round
//        initRound(Long.valueOf(2), "세레나_1화_썸네일.png", "세레나_1화_원고.png", "세레니티의 소녀", ".");
//        initRound(Long.valueOf(2), "세레나_2화_썸네일.png", "세레나_2화_원고.png", "두 주인",".");
//        initRound(Long.valueOf(2), "세레나_3화_썸네일.png", "세레나_3화_원고.png", "이안사",".");
//        initRound(Long.valueOf(2), "세레나_4화_썸네일.png", "세레나_4화_원고.png", "늙은 경영자와 어린 소녀",".");
//        initRound(Long.valueOf(2), "세레나_5화_썸네일.png", "세레나_5화_원고.png", "유리 화원(1)",".");
//        initRound(Long.valueOf(2), "세레나_6화_썸네일.png", "세레나_6화_원고.png", "유리 화원(2)",".");
//        initRound(Long.valueOf(2), "세레나_7화_썸네일.png", "세레나_7화_원고.png", "유리 화원(3)",".");
//        initRound(Long.valueOf(2), "세레나_8화_썸네일.png", "세레나_8화_원고.png", "나쁜 놈","이제부터 본 이야기 시작!");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "키스해 주세요", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "이거 완전 공주님이네", "작중 '마리안느 드생'의 그림은 5화에서 살짝 등장했었답니다:)");
//
////        11~20
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "버려진 새끼 고양이", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "별관", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "배신할 타이밍", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "호텔", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "각자의 계획", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "오늘 못 참겠어", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "너와 나의 진짜 관계", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "사랑을 논할 사이", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "둘이서만 잠시", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "너 그거 못 마셔", ".");
//
////        21~30
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "익사하는 밤", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "시인의 유작(1)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "시인의 유작(2)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "초록빛 술", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "호수와 바다", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "예쁘지 않은 것도, 있는데", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "단추가 13개", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "벽 짚고 똑바로 서", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "예쁜 복숭아", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "이건, 예정에 없던 건데", ".");
//
////        31~40
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "안 되겠다. 벗어", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "우리 약속 하나 할까?", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "후회할 텐데", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "못된 짓", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "너도 나를 책임져야지", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "다정한 오답", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "잠식의 색", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "데이트(1)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "데이트(2)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "데이트(3)", ".");
//
////        41~50
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "과호흡", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "위험한", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "빨간 입술", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "발레리나 오르골(1)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "발레리나 오르골(2)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "호텔 설립 기념일", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "안녕, 자기야", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "내 남편", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "밤새 단둘이", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "짐승과 중독자", ".");
//
////        51~60
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "잔인한 확신", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "은밀한 스킨십", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "초록색 여름비", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "무지개와 보조개", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "할 말이 있어서", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "내 이름 불러봐", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "난 널 사랑했을 뿐이야", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "두려워도 맞서든가", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "딸기맛 술버릇", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "그렇게 더", ".");
//
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "필요에 의한 관계", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "두 개의 그림(1)", ".");
//        initRound(Long.valueOf(2), "세레나_9화_썸네일.png", "세레나_9화_원고.png", "두 개의 그림(2)", ".");
//
//        //청춘 블라썸
//        initRound(Long.valueOf(1), "청춘 블라썸_1화_썸네일.png", "청춘 블라썸_1화_원고.png", "EP.1보미의 꽃(1)", ".");
//
//        //소녀의 세계
//        initRound(Long.valueOf(3), "소녀의 세계_1화_썸네일.png", "소녀의 세계_1화_원고.png", "입학식", ".");
//
//        //괜찮니 얘들아
//        initRound(Long.valueOf(4), "괜찮니 얘들아_1화_썸네일.png", "괜찮니 얘들아_1화_원고.png", "초대합니다 무지개 치료센터로", ".");
//
//        //그냥 선생님
//        initRound(Long.valueOf(5), "그냥 선생님_1화_썸네일.png", "그냥 선생님_1화_원고.png", "공주로 태어났다!", ".");
//
//        //베이비 폭군
//        initRound(Long.valueOf(6), "베이비 폭군_1화_썸네일.png", "베이비 폭군_1화_원고.png", "", ".");
//
//        //사내연애 사절!
//        initRound(Long.valueOf(7), "사내연애 사절_1화_썸네일.png", "사내연애 사절_1화_원고.png", "", ".");
//
//        //시월드가 내게 집착한다
//        initRound(Long.valueOf(8), "시월드가 내게 집착한다_1화_썸네일.png", "시월드가 내게 집착한다_1화_원고.png", "", ".");
//
//        //마음의소리2
//        initRound(Long.valueOf(9), "마음의소리2_1화_썸네일.png", "마음의소리2_1화_원고.png", "뭐하고 지냈냐면...", ".");
//
//        //같은 학교 친구
//        initRound(Long.valueOf(10), "같은 학교 친구_1화_썸네일.png", "같은 학교 친구_1화_원고.png", "", ".");
//
//        //묘약마녀
//        initRound(Long.valueOf(11), "묘약마녀_1화_썸네일.png", "묘약마녀_1화_원고.png", "어떤 사고", ".");
//
//        //개를 낳았다
//        initRound(Long.valueOf(12), "개를 낳았다_1화_썸네일.png", "개를 낳았다_1화_원고.png", "", ".");
//
//        //신혼일기
//        initRound(Long.valueOf(13), "신혼일기_1화_썸네일.png", "신혼일기_1화_원고.png", "첫만남", ".");
//
//        //나노리스트
//        initRound(Long.valueOf(14), "나노리스트_1화_썸네일.png", "나노리스트_1화_원고.png", "", ".");
//
//        //전지적 독자 시점
//        initRound(Long.valueOf(15), "전지적 독자 시점_1화_썸네일.png", "전지적 독자 시점_1화_원고.png", "Prologue 멸망한 세계에서 살아남는 세 가지 방법", ".");
//
//        //재벌집 막내아들
//        initRound(Long.valueOf(16), "재벌집 막내아들_1화_썸네일.png", "재벌집 막내아들_1화_원고.png", "", ".");
//
//        //신의 탑
//        initRound(Long.valueOf(17), "신의 탑_1화_썸네일.png", "신의 탑_1화_원고.png", "", ".");
//
////        도전만화 회차
//        initRound(Long.valueOf(28), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(29), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(30), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(31), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(32), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(33), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(34), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(35), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(36), "default-thumbnail.png", "원고_샘플.png", "", ".");
//        initRound(Long.valueOf(37), "default-thumbnail.png", "원고_샘플.png", "", ".");
//
//
////        RoundLike
//        for(int i=18; i<=25; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(63));  //세레나
//        }
//        for(int i=26; i<=27; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(62));  //세레나
//        }
//        initRoundLike(Long.valueOf(1), Long.valueOf(1));
//
//        for(int i=18; i<=26; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(79));  //신의탑
//        }
//
//        for(int i=18; i<=25; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(69));  //사내연애 사절
//        }
//
//        for(int i=18; i<=24; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(77));  //전지적 독자 시점
//        }
//
//        for(int i=18; i<=23; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(72));  //같은 학교 친구
//        }
//
////        5위~10위
//        for(int i=18; i<=22; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(75));  //신혼일기
//        }
//
//        for(int i=18; i<=21; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(76));  //나노리스트
//        }
//
//        for(int i=18; i<=20; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(65));  //소녀의 세계
//        }
//
//        for(int i=18; i<=19; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(68));  //베이비 폭군
//        }
//
//        for(int i=18; i<=18; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(71)); //마음의 소리2
//        }
//
////      도전만화 좋아요
//        for(int i=18; i<=25; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(81));  //태권 반갑습니다
//        }
//        for(int i=26; i<=27; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(81));
//        }
//        initRoundLike(Long.valueOf(1), Long.valueOf(81));
//
//        for(int i=18; i<=26; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(82));
//        }
//
//        for(int i=18; i<=25; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(83));
//        }
//
//        for(int i=18; i<=24; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(84));
//        }
//
//        for(int i=18; i<=23; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(85));
//        }
//
////        5위~10위
//        for(int i=18; i<=22; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(86));
//        }
//
//        for(int i=18; i<=21; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(87));
//        }
//
//        for(int i=18; i<=20; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(88));
//        }
//
//        for(int i=18; i<=19; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(89));
//        }
//
//        for(int i=18; i<=18; i++) {
//            initRoundLike(Long.valueOf(i), Long.valueOf(80));
//        }
//
//
////        Comment
//        initComment(Long.valueOf(1), Long.valueOf(63), "근데 솔직히 세레나가 쓸데없는 자존심부리는건 맞지 않음? 경영권 상속이 원래 세레나한테 가야하는게 맞지만 세레나는 능력이 없고 오히려 사고만 쳤다는데 아이저가 저만큼 키우고 이제 가르쳐 주겠다는데 세레나는 진짜 너무 생각없이 행동함" );
//        initComment(Long.valueOf(3), Long.valueOf(63), "..저정도면 남주가 세레니티 더 아끼는거 같은데");
//        initComment(Long.valueOf(4), Long.valueOf(63), "남주 말 다 맞다고 본다~~");
//        initComment(Long.valueOf(5), Long.valueOf(63), "와 보통 저런 상황 오면 공주님 안기하지 않나 냅다 의자를 걍 번쩍 들어버려서 개놀랬네");
//        initComment(Long.valueOf(1), Long.valueOf(63), "다음화..!!!");
//        initComment(Long.valueOf(3), Long.valueOf(63), "네 지금 알려주세요!!");
//        initComment(Long.valueOf(4), Long.valueOf(63), "ㄱㅇㅇ");
//        initComment(Long.valueOf(5), Long.valueOf(63), "다음화를 위해 나 처음으로 쿠키 구웠다...");
//        initComment(Long.valueOf(1), Long.valueOf(63), "작가님 처음에 도입부 그림 너무 예뻐요!");
//        initComment(Long.valueOf(3), Long.valueOf(63), "왜 여기서 끊기는 거야.. 오븐 불켜라");
//
////        reply
//        initReply(Long.valueOf(1), Long.valueOf(63), "나만 그런거 아니었어", Long.valueOf(3) );
//        initReply(Long.valueOf(2), Long.valueOf(63), "어케알았지...", Long.valueOf(3));
//
////        CommentLike
//        initCommentLike(Long.valueOf(1), Long.valueOf(2));
//        initCommentLike(Long.valueOf(3), Long.valueOf(2));
//        initCommentLike(Long.valueOf(4), Long.valueOf(2));
//        initCommentLike(Long.valueOf(1), Long.valueOf(3));
//        initCommentLike(Long.valueOf(2), Long.valueOf(3));
//
////        CommentDisLike
//        initCommentDislike(Long.valueOf(5), Long.valueOf(2));
//        initCommentDislike(Long.valueOf(3), Long.valueOf(3));
//        initCommentLike(Long.valueOf(5), Long.valueOf(3));
//
////        WebtoonRanking
////        em.persist(WebtoonRanking.create(webtoonRepository.findOne(Long.valueOf(2)), 1, RankingStatus.UP, Long.valueOf(10)));
////        em.persist(WebtoonRanking.create(webtoonRepository.findOne(Long.valueOf(17)), 2, RankingStatus.UP, Long.valueOf(8)));
////        em.persist(WebtoonRanking.create(webtoonRepository.findOne(Long.valueOf(7)), 2, RankingStatus.UP, Long.valueOf(5)));
////        em.persist(WebtoonRanking.create(webtoonRepository.findOne(Long.valueOf(15)), 2, RankingStatus.UP, Long.valueOf(3)));
////        em.persist(WebtoonRanking.create(webtoonRepository.findOne(Long.valueOf(10)), 2, RankingStatus.UP, Long.valueOf(2)));
//    }
//
//    public void initMember(String loginId, String password, String emailAddress, String name, LocalDate birthDate, Gender gender, CountryResidence countryResidence, String phoneNumber, String storeFileName) {
//        JoinMemberReq joinMemberReq = new JoinMemberReq();
//        joinMemberReq.setLoginId(loginId);
//        joinMemberReq.setPassword(password);
//        joinMemberReq.setEmailAddress(emailAddress);
//        joinMemberReq.setName(name);
//        joinMemberReq.setBirthDate(birthDate);
//        joinMemberReq.setGender(gender);
//        joinMemberReq.setCountryResidence(countryResidence);
//        joinMemberReq.setPhoneNumber(phoneNumber);
//        Member member = Member.createMember(joinMemberReq);
//
//        ProfileImage profileImage = ProfileImage.createProfileImage(new UploadImage(storeFileName, storeFileName), false);
//        member.changeProfileImage(profileImage);
//        em.persist(member);
//    }
//
////    public void initOfficialWebtoon(Long memberId, String name, WebtoonCategory webtoonCategory, List<GenreEnum> genreEnums, String oneLineSummary, String summary, String storeFileName, DayOfWeek dayOfWeek) {
////        Member member = memberRepository.findOne(memberId);
////        CreateWebtoonReq createWebtoonReq = new CreateWebtoonReq(name, webtoonCategory, genreEnums, new ArrayList<>(), oneLineSummary, summary, null, null);
////        WebtoonThumbnail webtoonThumbnail = WebtoonThumbnail.create(new UploadImage(storeFileName, storeFileName), new UploadImage(storeFileName, storeFileName));
////        OfficialWebtoon officialWebtoon = new OfficialWebtoon(member, createWebtoonReq, webtoonThumbnail, dayOfWeek);
////        em.persist(officialWebtoon);
////    }
//
//    public void initWebtoon(Long memberId, String name, WebtoonCategory webtoonCategory, List<GenreEnum> genreEnums, String oneLineSummary, String summary, String storeFileName) {
//        Member member = memberRepository.findOne(memberId);
//        CreateWebtoonReq createWebtoonReq = new CreateWebtoonReq(name, webtoonCategory, genreEnums, new ArrayList<>(), oneLineSummary, summary, null, null);
//        WebtoonThumbnail webtoonThumbnail = WebtoonThumbnail.create(new UploadImage(storeFileName, storeFileName), new UploadImage(storeFileName, storeFileName));
//        Webtoon webtoon = Webtoon.create(member, createWebtoonReq, webtoonThumbnail);
//        em.persist(webtoon);
//    }
//
//    public void initRound(Long webtoonId, String thumbnail, String manuscript, String title, String authorNote) {
//        Webtoon webtoon = webtoonRepository.findOneWithMember(webtoonId);
//        RoundThumbnail roundThumbnail = RoundThumbnail.create(new UploadImage(thumbnail,thumbnail));
//        MergeManuscript mergeManuscript = MergeManuscript.create(new UploadImage(manuscript, manuscript));
//        CreateRoundReq roundReq = new CreateRoundReq();
//        roundReq.setRoundTitle(title);
//        roundReq.setAuthorNote(authorNote);
//
//        Round round = Round.create(roundReq, webtoon, roundThumbnail, new ArrayList<>(), mergeManuscript);
//        em.persist(round);
//    }
//
//    public void initRoundLike(Long memberId, Long roundId) {
//        Member member = memberRepository.findOne(memberId);
//        Round round = roundRepository.findOne(roundId);
//        RoundLike roundLike = RoundLike.create(member, round);
//        em.persist(roundLike);
//    }
//
//    public void initComment(Long memberId, Long roundId, String content) {
//        Member member = memberRepository.findOne(memberId);
//        Round round = roundRepository.findOne(roundId);
//        Comment comment = Comment.createOrdinary(member, round, content);
//        em.persist(comment);
//    }
//
//    public void initReply(Long memberId, Long roundId, String content, Long commentId) {
//        Member member = memberRepository.findOne(memberId);
//        Round round = roundRepository.findOne(roundId);
//        Comment parentComment = commentRepository.findOne(commentId);
//        Comment comment = Comment.createReply(member, round, content, parentComment);
//        em.persist(comment);
//    }
//
//    public void initCommentLike(Long memberId, Long commentId) {
//        Member member = memberRepository.findOne(memberId);
//        Comment comment = commentRepository.findOne(commentId);
//        CommentLike commentLike = CommentLike.create(member, comment);
//        em.persist(commentLike);
//    }
//
//    public void initCommentDislike(Long memberId, Long commentId) {
//        Member member = memberRepository.findOne(memberId);
//        Comment comment = commentRepository.findOne(commentId);
//        CommentDislike commentDislike = CommentDislike.create(member, comment);
//        em.persist(commentDislike);
//    }
//}
