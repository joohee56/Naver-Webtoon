<template lang="ko">
  <div class="webtoon-wrap">
    <div class="webtoon" v-for="webtoon in webtoons">
      <router-link :to="{name: webtoonType + 'RoundList', params: {webtoonId: webtoon.webtoonId}}">
        <img class="cover-image" :src="require(`@/assets/image/${webtoon.posterStoreFileName}`)">
      </router-link>
      <div class="webtoon-name-wrap overflow-hidden">
        <span class="up" v-if="webtoon.roundUpdateCount>0">UP</span>
        <router-link :to="{name: webtoonType + 'RoundList', params: {webtoonId: webtoon.webtoonId}}">
          <span class="title">{{webtoon.webtoonName}}</span>
        </router-link>
      </div>
      <div class="like-cnt-wrap">
        <i class="fa-solid fa-heart"></i>
        <div>&nbsp;{{webtoon.totalLikeCount}}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["webtoons", "webtoonType"], //webtoonId, webtoonName, posterStoreFileName, totalLikeCount
};
</script>

<style scoped>
.webtoon-wrap {
  display: grid;
  grid-template-columns: repeat(6, minmax(130px, 1fr));
  column-gap: 30px;
  row-gap: 30px;
  width: 100%;
  margin-bottom: 180px;
}
.cover-image {
  width: 100%;
  border-radius: 4px;
  aspect-ratio: 480 / 623;
}
.webtoon-name-wrap {
  display: block;
  margin-top: 8px;
}
.webtoon .up {
  color: #ff4d56;
  border-radius: 5px;
  border: #ff4d56 solid 0.5px;
  font-family: AppleSDGothicNeoEB;
  text-align: center;
  padding: 0 4px;
  margin-right: 3px;
  font-size: 14px;
  margin-bottom: 5px;
}
.webtoon .title {
  font-family: AppleSDGothicNeoB;
  font-size: 18px;
  margin-left: 5px;
}
.webtoon .title:hover {
  text-decoration: underline;
}
.like-cnt-wrap {
  display: flex;
  font-size: 15px;
  margin-left: 5px;
}
.like-cnt-wrap i {
  font-size: 13px;
  color: #6e6d6d;
  line-height: 20px;
}
.overflow-hidden {
  white-space: nowrap; /* 줄 바꿈 방지 */
  overflow: hidden; /* 넘치는 부분 숨김 */
  text-overflow: ellipsis; /* 넘치는 부분에 ... 추가 */
}
</style>
