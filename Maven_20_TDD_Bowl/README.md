# Test Driven Developer
## 볼링게임 점수계산 프로젝트


### Bowling Game Kata
* 엉클밥이라는 애칭으로 유명한  Clean Code의 저자 로버트 C 마틴이 학습용 프로젝트로 제안한 볼링 점수 계산 프로그램 이다.
* 원본출처 : [The Bowling Game Kata](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata)

### 볼링점수 계산 규칙
* 총 10프레임으로 진행하며, 한 프레임에 2회 공을 굴릴 수 있는 기회가 주어진다.
* 핀 1개는 1점이다
* 스페어 처리했을 경우 10점 + 다음 프레임 1구 점수
* 스트라이크의 경우 10점 + 다음 프레임 1구 점수 + 이후 2구 점수
* 10 프레임째에서는 스트라이크나 스페어가 나오면 최대 3번의 롤링(Rolling) 가

#### 요구사항
* roll 은 플레이어가 공을 굴릴때마다 호출된다. 파라미터인 pins는 공을 굴렸을 때 쓰러트린 핀의 갯수를 나타낸다.
* score 는 게임이 끝났을때만 호출되며, 게임의 총 점수를 계산한다.


#### Java Junit5 Project
* new / Maven Project
* Template : uk.co.markg.archetypes.java11-junit5 1.0
* pom.xml Java Version 11 to 1.8
* Maven Update
* Run As / JUnit Test

### TDD 수행순서
1. RED : 실패하는 유닛 테스트 작성하기
2. GREEN : 유닛 테스트 성공시키기
3. BLUE : 리팩토링