# Vue CLI

 Vue CLI란, Vue Command Line Interface로, 명령어를 통한 특정 액션을 수행하는 실행도구임



### 설치 (node version은 v10 이상이어야하며, npm은 v6 이상이어야 함)

#### node와 npm version 확인

```bash
node -v
npm -v
```



#### Vue CLI 설치

```bash
npm install -g @vue/cli
# OR
yarn global add @vue/cli
```

- Permission Error로 인해 Vue cli 설치가 안되는 경우

```bash
sudo npm install -g @vue/cli
```



#### 설치 완료

![image-20191012214218942](../image/8_1_vuecli_install.png)



### npm install 시 package 설치 경로 (Global libraries)

##### Unix

`/usr/local/lib/node` or `/usr/local/lib/node_modules`

##### Windows 7,8 and 10

`%USERPROFILE%\AppData\Roaming\npm\node_modules`



### npm install 시 package 설치 경로 (Non-Global libraries)

현재 디렉토리 경로의 `node_modules` 디렉토리



## Vue CLI 2.x와 3.x의 차이점

### Vue CLI 2.x

`vue init [프로젝트 템플릿 유형] [프로젝트 폴더 위치]`

`vue init webpack-simple [프로젝트 폴더 위치]`

### Vue CLI 3.x

`vue create [프로젝트 폴더 위치]`



#### Vue CLI로 프로젝트 생성

```
vue create vue-cli
```

![image-20191012215319210](../image/8_2_createproject.png)



##### Pick a preset (default로 선택)

![image-20191012215358280](../image/8_3_pickapreset.png)



#####  CLI Plugins 설치 화면

![image-20191012215442123](../image/8_4_installCLIPlugin.png)

![image-20191012215603119](../image/8_5_doneInstallation.png)



##### npm run serve (로컬 서버 실행)

![image-20191012215738224](../image/8_6_npm_run_serve.png)

![image-20191012215821638](../image/8_7_npm_run_serve_done.png)

![Screen Shot 2019-10-12 at 9.59.16 PM](../image/8_8_npm_run_serve_browser.png)