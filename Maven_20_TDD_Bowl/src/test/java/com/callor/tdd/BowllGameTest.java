package com.callor.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS )
class BowllGameTest {

	
	//@BeforeAll을 사용하면 안됨
	//@BeforeAll method 는 static으로 만들어져야 하며.
	//  	또는 @TestInstance(Lifecycle.PER_CLASS ) 을 설정해야 한다.
	// 그렇지 않으면 JUnit  시작이 실패한다
	
	private BowllGame game;

	// 매번 @Test 수행전에 실행할 method
	// 각 테스트가 시작하기전 게임을 초기화 해주어야 한다.
    @BeforeEach
    public void newGame() throws Exception{
    	game = new BowllGame();
    }
    
    // 게임이 가능한가?
    @Test
    public void canRoll() {
        game.roll(0);
    }

    
    // 연속 게임을 호출하기 위해 만든 method
	private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    // 스페어 처리 계산을 위해 호출하는 method
    private void rollSpare() {
        game.roll(5);
        game.roll(5); // spare
    }
    
    // 스트라이크 계사을 위해 호출하는 method
    private void rollStrike() {
        game.roll(10);
    }

	
    // 모든 프레임에서 핀이 0( All Zero )
    @Test
    public void gutterGame() {
        rollMany(20, 0);
        // assertThat(game.score(). is(0));
        assertEquals(0, game.score());
    }

    // 모든 프레임(Roll1, Roll2)에서 Roll 당 각 1점씩 얻었을때
    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    // 최초 1 프레임에서 spare, 2 프레임에서 3점만 
    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    // 최초 1 프레임에서 strike 2 프레임에서 5점, 3점 
    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        
//        extracted();
        
        
         rollMany(16, 0);
        System.out.println(game.score());
        assertEquals(26, game.score());
    }

//	private void extracted() {
//		Random rnd = new Random();
//        for(int i = 0 ; i < 16 ; i++) {
//        	game.roll(rnd.nextInt(5));
//        }
//	}

    // 퍼펙트 게임 계산
    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

}
