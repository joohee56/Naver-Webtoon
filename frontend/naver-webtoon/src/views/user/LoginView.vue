<template lang="ko">
	<div class="container">
		<header>
				<div class="header-inner">
          <router-link to="/" class="naver-logo">NAVER</router-link>
					<div class="lang">
						<select class="select-language">
							<option value="ko_KR">한국어</option>
							<option value="en_US">English</option>
						</select> 
					</div>
				</div>
		</header>
		
		<!-- content -->
		<div class="content">
			<div class="login-wrap">

				<!-- menu -->
				<ul class="menu-wrap">
					<li class="menu-item">
						<a class="menu-id on">ID 로그인</a>
					</li>
					<li class="menu-item">
						<a class="menu-ones">일회용 번호</a>
					</li>
					<li class="menu-item">
						<a class="menu-qr">QR 코드</a>
					</li>
				</ul>

				<!-- form -->
				<div>
					<input type="hidden">
					<ul class="panel-wrap">
						<li class="panel-item" style="display: block;">
							<div class="panel-inner">

								<div class="id-pw-wrap">

									<!-- input id -->
									<div class="input-row" id="id-line" :class="{'focused' : idIsFocused}">
										<i class="fa-regular fa-user icon-cell"></i>
										<input type="text" id="id" name="id" class="input-text" placeholder="아이디" maxlength="41" v-model="user.loginId" @focus="idIsFocused=true" @blur="idIsFocused=false">
										<span class="btn-delete" id="id-clear" style="display: block;" v-if="user.loginId.length > 0" @click="user.loginId=''"><i class="fa-solid fa-circle-xmark"></i></span>
									</div>

									<!-- input pw -->
									<div class="input-row" id="pw-line" :class="{'focused' : pwIsFocused}">
										<i class="fa-solid fa-lock icon-cell"></i>
										<input type="password" id="pw" name="pw" class="input-text" placeholder="비밀번호" maxlength="16" v-model="user.password" @focus="pwIsFocused=true" @blur="pwIsFocused=false">
										<span class="btn-delete" id="pw-clear" style="display: block;" v-if="user.password.length > 0" @click="user.password=''"><i class="fa-solid fa-circle-xmark"></i></span>
									</div>
								</div>

								<!-- 로그인 상태 유지 -->
								<!-- <div class="login-keep-wrap">
									<input type="checkbox" id="keep" class="input-keep">
									<label for="keep" class="keep-text">로그인 상태 유지</label>
								</div> -->

								<!-- error message -->
                <div class="error-message" v-html="errorMessage"></div>

								<!-- 로그인 버튼 -->
								<div class="btn-login-wrap">
									<button type="button" class="btn-login" @click="login">
										<span class="btn-text">로그인</span>
									</button>
								</div>

							</div>
						</li>
					</ul>
				</div>
			</div>
			<ul class="find-wrap">
				<li><a class="find-text">비밀번호 찾기</a></li>
				<li><a class="find-text">아이디 찾기</a></li>
				<li><router-link to="/join" class="find-text">회원가입</router-link></li>
			</ul>
		</div>

		<!-- 배너 (광고) -->
		<div class="banner-wrap">
			<!-- iframe -->
			<img src="https://ssl.pstatic.net/melona/libs/1378/1378592/e54e34361a2043e7b1df_20240205133414551.png" alt="[광고]스트리밍은 계속되어야 해 치지직" style="vertical-align:top;width:100%;height:auto;border:none;">
		</div>

		<!-- footer -->
		<footer>
			<div class="footer-inner">
				<ul class="footer-link" id="footer_link">
						<li><a target="_blank" class="footer-item" href="http://www.naver.com/rules/service.html" id="fot.agreement"><span class="text">이용약관</span></a></li>
						<li><a target="_blank" class="footer-item" href="http://www.naver.com/rules/privacy.html" id="fot.privacy"><span class="text"><strong>개인정보처리방침</strong></span></a></li>
						<li><a target="_blank" class="footer-item" href="http://www.naver.com/rules/disclaimer.html" id="fot.disclaimer"><span class="text">책임의 한계와 법적고지</span></a></li>
						<li><a target="_blank" class="footer-item" href="https://help.naver.com/alias/membership/p.membership/main.naver" id="fot.help"><span class="text">회원정보 고객센터</span></a></li>
				</ul>
				<div class="footer-copy">
					<a id="fot.naver" target="_blank" href="https://www.navercorp.com">
							<span class="footer-logo">NAVER</span>
					</a>
					<span class="text">Copyright</span>
					<span class="corp">© NAVER Corp.</span>
					<span class="text">All Rights Reserved.</span>
			</div>
			</div>
		</footer>
	</div>
</template>

<script>
import { postLogin } from "@/api/member";
import { mapMutations } from "vuex";

export default {
  data() {
    return {
      user: {
        loginId: "",
        password: "",
      },
      title: {
        loginId: "아이디",
        password: "비밀번호",
      },
      idIsFocused: false,
      pwIsFocused: false,
      errorMessage: "",
    };
  },
  methods: {
    ...mapMutations("memberStore", ["SET_LOGIN_USER", "SET_PROFILE_IMAGE"]),
    async login() {
      const pass = this.validateInput();
      if (!pass) {
        return;
      }

      let response = await postLogin(this.user);
      console.log(response);

      if (response.status === 200) {
        this.SET_LOGIN_USER(response.data);
        this.SET_PROFILE_IMAGE(response.data.profileImage);

        const redirectUrl = this.$route.params.redirectUrl;
        this.$router.push(redirectUrl);
      } else if (response.status === 400) {
        let data = response.data;

        if (data.code === "VALIDATION") {
          let errorMessage = "";
          for (const key in data.message) {
            errorMessage =
              this.title[key] + data.message[key] + "<br/>" + errorMessage;
          }
          this.errorMessage = errorMessage;
        } else if (data.code === "BUSINESS") {
          this.errorMessage = data.message;
        }
      }
    },
    validateInput() {
      if (this.user.loginId === "") {
        this.errorMessage = this.title.loginId + "를 입력해 주세요.";
        return false;
      }
      if (this.user.password === "") {
        this.errorMessage = this.title.password + "를 입력해 주세요.";
        return false;
      }
      return true;
    },
  },
};
</script>

<style scoped>
ul {
  list-style: none;
}
.container {
  font-family: "Inter", sans-serif;
  font-optical-sizing: auto;
  font-weight: 400;
  font-style: normal;
  font-variation-settings: "slnt" 0;
  position: relative;
}
header {
  padding-bottom: 48px;
  box-sizing: border-box;
  display: block;
}
.header-inner {
  position: relative;
  width: 743px;
  margin: 0 auto;
  text-align: center;
  box-sizing: border-box;
}
.naver-logo {
  font-family: "Archivo Black", sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 2.5rem;
  color: #03c75a;
  margin-top: 108px;
  display: inline-block;
  vertical-align: top;
  width: 155px;
  height: 30px;
}
.lang {
  position: absolute;
  top: 20px;
  right: 0;
}
.select-language {
  position: relative;
  font-size: 12px;
  line-height: 18px;
  width: 100%;
  min-width: 95px;
  height: 30px;
  padding: 4px 10px 6px 8px;
  color: #333;
  float: right;
  border: 1px solid #ccc;
  border-radius: 0;
  z-index: 1;
}

/* content */
.login-wrap {
  box-sizing: border-box;
  width: 460px;
  margin: 0 auto;
}

/* menu */
.menu-wrap {
  display: table;
  table-layout: fixed;
  width: 100%;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
}
.menu-item {
  position: relative;
  display: table-cell;
  vertical-align: top;
  padding: 0;
  margin: 0;
}
.menu-id,
.menu-ones,
.menu-qr {
  display: block;
  position: relative;
  height: 61px;
  padding-top: 17px;
  border: 1px solid #e3e3e3;
  border-bottom: 0;
  border-radius: 6px 6px 0 0;
  background-color: #f8f9fa;
  text-align: center;
  box-sizing: border-box;
  z-index: 2;
}
.menu-id {
  border-right: 0;
}
.on {
  border-color: #c6c6c6;
  background-color: white;
  z-index: 5;
}
.menu-ones {
  border-right: 0;
  border-radius: 0 0 6px 0;
}
.menu-qr {
  border-radius: 0 6px 0 0;
}

/* form */
form {
  margin: 0;
  padding: 0;
}
.panel-wrap {
  list-style: none;
  z-index: 3;
  position: relative;
  margin: 0;
  padding: 0;
  margin-top: -8px;
}
.panel-item {
  border: 1px solid #c6c6c6;
  border-radius: 6px;
  background-color: white;
  box-shadow: 0 5px 8px 0 rgba(68, 68, 68, 0.04);
  display: block;
  margin: 0;
  padding: 0;
}
.panel-inner {
  padding: 20px 28px;
}

/* id, pw wrap */
.id-pw-wrap .input-row {
  display: table;
  table-layout: fixed;
  width: 100%;
  padding: 14px 17px 13px;
  box-sizing: border-box;
  position: relative;
  border: 1px solid #dadada;
  height: 100%;
  text-align: left;
}

#id-line {
  border-radius: 6px 6px 0 0;
}
#pw-line {
  border-bottom-left-radius: 5px;
  border-bottom-right-radius: 5px;
}
.input-row input {
  outline: none;
}
.focused {
  border: 1px solid #00dc64 !important;
}

.input-text {
  display: table-cell;
  padding-right: 30px;
  position: relative;
  border: none;
  width: 100%;
  font-size: 16px;
  z-index: 4;
  box-sizing: border-box;
}
.icon-cell {
  display: table-cell;
  width: 24px;
  vertical-align: middle;
  color: #dbdbdb;
}
.btn-delete {
  position: absolute;
  top: 6px;
  right: 8px;
  width: 35px;
  height: 35px;
  z-index: 5;
  background-color: #fff;
  text-align: center;
  vertical-align: center;
  line-height: 35px;
  cursor: pointer;
}
.fa-solid.fa-circle-xmark {
  font-size: large;
  color: #9ba1a3;
}

/* 로그인 상태 유지 */
.login-keep-wrap {
  margin-top: 13px;
  position: relative;
  padding-left: 30px;
}
.input-keep {
  position: absolute;
  top: 2px;
  left: 3px;
  width: 15px;
  height: 15px;
}
.keep-text {
  display: inline-block;
  font-size: 14px;
  line-height: 17px;
  color: #777;
}

/* 로그인 버튼  */
.btn-login-wrap {
  margin-top: 38px;
}
.btn-login {
  display: block;
  width: 100%;
  background-color: #00dc64;
  border: solid 1px rgba(0, 0, 0, 0.15);
  color: white;
  padding: 13px 0;
  border-radius: 6px;
  box-sizing: border-box;
  cursor: pointer;
}
.btn-text {
  font-family: AppleSDGothicNeoB;
  font-size: 20px;
}

/* 에러 메시지 */
.error-message {
  margin-top: 20px;
  color: red;
}

/* 찾기 */
.find-wrap {
  padding: 20px 0 35px;
  text-align: center;
  margin: 0;
}
.find-wrap li {
  position: relative;
  display: inline-block;
  padding: 0;
  margin: 0;
}
.find-wrap li a {
  display: inline-block;
  font-size: 14px;
  line-height: 17px;
  text-decoration: none;
  color: #888;
}
.find-wrap li + li {
  padding-left: 28px;
}
.find-wrap li + li::before {
  content: "";
  position: absolute;
  top: 3px;
  left: 12px;
  width: 1px;
  height: 12px;
  border-radius: 0.5px;
  background-color: #dadada;
}

/* 배너 */
.banner-wrap {
  width: 460px;
  height: 147px;
  margin: 0 auto;
  text-align: center;
}

/* footer */
footer {
  padding: 63px 0 32px;
  box-sizing: border-box;
}
.footer-inner {
  position: relative;
  text-align: center;
}
.footer-link li {
  display: inline-block;
}
footer .corp,
footer .text {
  font-size: 12px;
  line-height: 15px;
  letter-spacing: -0.5px;
  color: #888;
}
footer .footer-link + .footer-copy {
  margin-top: 9px;
}
.footer-logo {
  font-family: "Archivo Black", sans-serif;
  font-weight: 400;
  font-style: normal;
  color: #03c75a;
  vertical-align: top;
  margin-right: 5px;
}
.footer-link li + li {
  position: relative;
  padding-left: 13px;
}

.footer-link li + li::before {
  content: "";
  position: absolute;
  top: 4px;
  left: 4px;
  width: 1px;
  height: 11px;
  background-color: #dadada;
}
</style>
