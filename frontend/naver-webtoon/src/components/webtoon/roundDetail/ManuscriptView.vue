<template lang="ko">
	<div class="container">

		<!-- 상단 메뉴바 -->
    <div class="menubar-wrap">
      <div class="menu-bar">
        <router-link :to="{name: webtoonType+'RoundList', params: {webtoonId : this.webtoonId}}"><i class="fa-solid fa-angle-left"></i></router-link>
        <router-link :to="{name: webtoonType+'RoundList', params: {webtoonId : this.webtoonId}}">{{roundDetail.webtoonName}}</router-link>
        <span class="separator"></span>
        <span>{{roundDetail.roundTitle}}</span>
        <span @click="moveBeforeRound" class="before-round">
          <i class="fa-solid fa-caret-left"></i>
          <span> 이전화</span>
        </span>
        <span class="separator"></span>
        <router-link :to="{name: webtoonType+'RoundList', params: {webtoonId : this.webtoonId}}">
          <i class="fa-solid fa-list-ul"></i>
          <span> 목록</span>
        </router-link>
        <span class="separator"></span>
        <span @click="moveNextRound" class="next-round">
          <span>다음화 </span>
          <i class="fa-solid fa-caret-right"></i>
        </span>
      </div>
    </div>

		<!-- 원고 -->
		<div class="manusript-wrap" ref="manuscript">
			<img v-if="roundDetail.mergeManuscript !== ''" class="manuscript" :src="require(`@/assets/image/${roundDetail.mergeManuscript}`)">
		</div>

    <!-- 반응 버튼 -->
    <div class="reaction-btn-wrap">
      <!-- 관심웹툰 -->
      <div @click="clickWebtoonOfInterest">
        <div class="icon circle-check"><i class="fa-solid fa-circle-check"></i></div>
        <div class="title">관심웹툰</div>
        <div class="count">0</div>
      </div>
      <!-- 좋아요 -->
      <div @click="clickRoundLike">
        <div class="icon" style="color: #ff5151;" v-if="this.roundDetail.isUserLike">
          <i class="fa-solid fa-heart"></i>
        </div>
        <div class="icon" v-else>
          <i class="fa-regular fa-heart"></i>
        </div>
        <div class="title">좋아요</div>
        <div class="count">{{this.roundDetail.totalLikeCnt}}</div>
      </div>
    </div>

    <!-- 목록 -->
    <div class="round-list">
      <button @click="lessRange" :disabled="isPreviewLeftBtnDisabled"><i class="fa-solid fa-angle-left"></i></button>
      <div class="preview-round-wrap">
        <div v-for="round in previewRounds" class="preview-round-item">
          <router-link :to="{name: webtoonType+'RoundDetail', params: {weboonId: `${roundDetail.weboonId}`, roundId: `${round.roundId}`}}" :class={active:isNowRound(round.roundNumber)}>
            <img class="round-thumbnail" :src="require(`@/assets/image/${round.thumbnail}`)">
            <p class="round-title overflow-hidden">{{round.title}}</p>
          </router-link>
        </div>
      </div>
      <button class="right-btn" @click="rightRange" :disabled="isPreviewRightBtnDisabled"><i class="fa-solid fa-angle-right"></i></button>
    </div>

    <!-- 작가의 말 -->
    <div class="author-note-wrap">
      <div class="author-profile">	
        <img class="author-profile-image" :src="require(`@/assets/image/${roundDetail.authorProfileImage}`)">
        <span>{{roundDetail.authorName}}</span>
        <span style="color: #999">· 글/그림</span>
      </div>
      <div class="author-note">
        <div v-html="roundDetail.authorNote"></div>
      </div>
    </div>

    <!-- 위아래 이동 버튼 -->
    <div class="move-control-btn">
      <button class="up" @click="moveToTop"><i class="fa-solid fa-angle-up"></i></button>
      <button @click="moveToBottom"><i class="fa-solid fa-angle-down"></i></button>
    </div>

	</div>
</template>

<script>
import { getRoundDetail, getRounds, postRoundLike } from "@/api/round";
import { mapMutations } from "vuex";

export default {
  data() {
    return {
      webtoonId: this.$route.params.webtoonId,
      roundId: this.$route.params.roundId,
      roundDetail: {
        webtoonId: "",
        webtoonName: "",
        roundNumber: "",
        roundTitle: "",
        mergeManuscript: "",
        authorProfileImage: "default-thumbnail.png",
        authorName: "",
        authorNote: "",
        totalLikeCnt: "",
        isUserLike: "",
      },
      rounds: [], //전체 회차
      previewRounds: [], //미리보기 회차
      previewCount: 7,
      previewRangeStart: "",
      isPreviewLeftBtnDisabled: "false",
      isPreviewRightBtnDisabled: "false",
      showMenuBar: true,
    };
  },
  props: ["webtoonType"],
  watch: {
    "$route.params.roundId": function () {
      location.reload();
      this.moveToTop();
    },
    previewRangeStart() {
      this.previewRounds = [];

      const previewRangeEnd = Math.min(
        this.rounds.length,
        this.previewRangeStart + this.previewCount
      );
      for (let i = this.previewRangeStart; i < previewRangeEnd; i++) {
        this.previewRounds.push(this.rounds[i]);
      }

      this.setPreviewBtnDisable();
    },
  },
  async mounted() {
    await this.fetchRoundDetail();
    await this.fetchRounds();
    this.setNavActive();
    this.setEventLister();
  },
  beforeDestroy() {
    // 컴포넌트가 파괴될 때 이벤트 리스너를 제거
    document.removeEventListener("click", this.handleClickShowMenubar);
    document.removeEventListener("scroll", this.handleScrollShowMenubar);
  },
  methods: {
    ...mapMutations("navStore", ["SET_CATEGORY_ACTIVE"]),
    async fetchRoundDetail() {
      try {
        const response = await getRoundDetail(this.roundId);
        console.log(response);
        if (response.status === 200) {
          this.roundDetail = response.data;
          this.roundDetail.authorNote = this.roundDetail.authorNote.replaceAll(
            "\n",
            "<br/>"
          );
        }
      } catch (error) {
        console.log(error);
      }
    },
    async fetchRounds() {
      try {
        const response = await getRounds(this.webtoonId);
        if (response.status === 200) {
          this.rounds = response.data;
          this.setPreviewRange();
        }
      } catch (error) {
        console.log(error);
      }
    },
    setPreviewRange() {
      const now = this.roundDetail.roundNumber - 1;
      let start = Math.max(0, now - 3);
      this.previewRangeStart = start;
    },
    setPreviewBtnDisable() {
      if (this.previewRangeStart === 0) {
        this.isPreviewLeftBtnDisabled = true;
      } else {
        this.isPreviewLeftBtnDisabled = false;
      }

      if (this.previewRangeStart + this.previewCount >= this.rounds.length) {
        this.isPreviewRightBtnDisabled = true;
      } else {
        this.isPreviewRightBtnDisabled = false;
      }
    },
    isNowRound(roundNumber) {
      return this.roundDetail.roundNumber == roundNumber;
    },
    lessRange() {
      this.previewRangeStart = Math.max(
        0,
        this.previewRangeStart - this.previewCount
      );
    },
    rightRange() {
      this.previewRangeStart = Math.min(
        this.rounds.length - 1,
        this.previewRangeStart + this.previewCount
      );
    },
    async clickRoundLike() {
      try {
        const response = await postRoundLike(this.roundId);
        if (response.status === 200) {
          this.roundDetail.totalLikeCnt = response.data.totalLikeCnt;
          this.roundDetail.isUserLike = response.data.isUserLike;
        }
      } catch (error) {
        console.log(error);
      }
    },
    clickWebtoonOfInterest() {
      alert("개발 진행 중인 기능입니다.");
    },
    moveBeforeRound() {
      if (this.roundDetail.roundNumber === 1) {
        alert("첫화입니다.");
      } else {
        this.$router.push({
          name: this.webtoonType + "RoundDetail",
          params: {
            webtoonId: this.roundDetail.webtoonId,
            roundId: this.roundId - 1,
          },
        });
      }
    },
    moveNextRound() {
      if (this.roundDetail.roundNumber === this.rounds.length) {
        alert("마지막화입니다.");
      } else {
        this.$router.push({
          name: this.webtoonType + "RoundDetail",
          params: {
            webtoonId: this.roundDetail.webtoonId,
            roundId: parseInt(this.roundId, 10) + 1,
          },
        });
      }
    },
    setNavActive() {
      if (this.webtoonType == "official") {
        this.SET_CATEGORY_ACTIVE(0);
      } else {
        this.SET_CATEGORY_ACTIVE(1);
      }
    },
    moveToTop() {
      window.scrollTo({
        top: 0,
      });
    },
    moveToBottom() {
      window.scrollTo({
        top: this.$refs.manuscript.scrollHeight,
      });
    },
    setEventLister() {
      document.addEventListener("click", this.handleClickShowMenubar);
      document.addEventListener("scroll", this.handleScrollShowMenubar);
    },
    handleClickShowMenubar(e) {
      const menubar = document.querySelector(".menubar-wrap");
      const manuscript = document.querySelector(".manusript-wrap");
      const scollY = window.scrollY;

      if (
        menubar &&
        manuscript &&
        scollY >= manuscript.offsetTop &&
        e.target.contains(manuscript)
      ) {
        if (this.showMenuBar) {
          menubar.style.transition = "opacity 0.5s ease";
          menubar.style.opacity = 0;
          this.showMenuBar = false;
        } else {
          menubar.style.transition = "opacity 0.5s ease";
          menubar.style.opacity = 1;
          this.showMenuBar = true;
        }
      }
    },
    handleScrollShowMenubar() {
      const menubar = document.querySelector(".menubar-wrap");
      const manuscript = document.querySelector(".manusript-wrap");
      const scollY = window.scrollY;

      if (menubar && manuscript) {
        if (
          this.showMenuBar &&
          scollY >= manuscript.offsetTop &&
          scollY < manuscript.offsetTop + manuscript.offsetHeight
        ) {
          //원고 내부 진입
          menubar.style.transition = "opacity 0.5s ease";
          menubar.style.opacity = 0;
          this.showMenuBar = false;
        }
        if (
          !this.showMenuBar &&
          (scollY < manuscript.offsetTop ||
            scollY >= manuscript.offsetTop + manuscript.offsetHeight)
        ) {
          //원고 외부
          menubar.style.transition = "opacity 0.5s ease";
          menubar.style.opacity = 1;
          this.showMenuBar = true;
        }
      }
    },
  },
};
</script>

<style scoped>
.container > * {
  margin: 0 auto;
}
.container .round-list,
.container .author-note-wrap {
  width: 85rem;
}

/* 상단 메뉴바 */
.menubar-wrap {
  background-color: #383b45;
  position: sticky;
  top: 0;
}
.menu-bar {
  height: 70px;
  display: flex;
  align-items: center;
  font-size: 18px;
  width: 85rem;
  z-index: 1000;
  margin: 0 auto;
}
.menu-bar :first-child {
  margin-left: 20px;
}
.menu-bar :last-child {
  margin-right: 20px;
}
.menu-bar * {
  color: white;
}
.menu-bar > * {
  margin-right: 15px;
}
.menu-bar *:not(i) {
  font-family: AppleSDGothicNeoB;
}
.separator {
  content: "";
  top: 3px;
  left: 12px;
  width: 1px;
  height: 13px;
  border-radius: 0.5px;
  background-color: #e3e2e2;
}
.before-round {
  margin-left: auto;
  cursor: pointer;
}
.next-round {
  cursor: pointer;
}

/* 원고 */
.manusript-wrap {
  width: 100%;
  justify-content: center;
  display: flex;
}
.manuscript {
  width: 690px;
}

/* 좋아요 */
.reaction-btn-wrap {
  display: table;
  border-collapse: collapse;
  margin-top: 150px;
  margin-bottom: 150px;
  text-align: center;
}
.reaction-btn-wrap > div {
  background-color: white;
  display: table-cell;
  border: 1px solid #efefef;
  padding: 22px 65px;
  cursor: pointer;
}
.reaction-btn-wrap .icon {
  font-size: 25px;
}
.reaction-btn-wrap .circle-check i {
  color: #00dc64;
}
.reaction-btn-wrap .title {
  font-family: AppleSDGothicNeoM;
  font-size: 18px;
  margin-top: 8px;
}
.reaction-btn-wrap .count {
  color: #999;
}
/* 목록 */
.round-list {
  border: 1px solid #efefef;
  height: 200px;
  margin: 30px auto 60px;
  display: flex;
  width: 100%;
}
.preview-round-wrap {
  display: flex;
  align-items: center;
  grid-gap: 35px;
}
.preview-round-item {
  width: 147px;
}
.round-thumbnail {
  width: 100%;
  border: 1px solid #efefef;
  border-radius: 4px;
  aspect-ratio: 540 / 340;
}
.round-title {
  margin: 0;
  margin-top: 5px;
  font-family: AppleSDGothicNeoSB;
}
.round-list button {
  background: white;
  border: none;
  font-size: 30px;
  padding: 0 20px;
  cursor: pointer;
}
.round-list .right-btn {
  margin-left: auto;
}
.active .round-thumbnail {
  border: 1px solid #00dc64;
}
.active .round-title {
  color: #00dc64;
}

.overflow-hidden {
  white-space: nowrap; /* 줄 바꿈 방지 */
  overflow: hidden; /* 넘치는 부분 숨김 */
  text-overflow: ellipsis; /* 넘치는 부분에 ... 추가 */
}

/* 작가의 말 */
.author-note-wrap {
  margin-top: 30px;
}
.author-profile {
  display: flex;
  direction: column;
  align-items: center;
  font-family: AppleSDGothicNeoSB;
  font-size: 18px;
}
.author-profile > * {
  margin-right: 5px;
}
.author-profile-image {
  width: 40px;
  border-radius: 50%;
  aspect-ratio: 1/1;
}
.author-note {
  padding: 18px 5px;
  font-family: AppleSDGothicNeoSB;
  font-size: 17px;
  border-bottom: 1px solid #efefef;
}

/* 위아래 이동 버튼 */
.move-control-btn {
  position: fixed;
  right: 50px;
  bottom: 50px;
  z-index: 1000;
}
.move-control-btn button {
  display: block;
  background-color: white;
  border-radius: 50%;
  font-size: 30px;
  width: 60px;
  aspect-ratio: 1/1;
  box-shadow: 0px 5px 5px 1px rgba(0, 0, 0, 0.068);
  border: none;
  color: #999;
  cursor: pointer;
}
.move-control-btn .up {
  margin-bottom: 20px;
}
</style>
