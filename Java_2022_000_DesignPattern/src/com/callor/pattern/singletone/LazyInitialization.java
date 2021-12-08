package com.callor.pattern.singletone;

/**
 * 
 * @author callor
 * 
 *         Lazy Initialization은 이름에 걸맞게, 앞선 두 방식과는 달리 나중에 초기화하는 방법이다 이는 global
 *         access 한 getInstance() 메소드를 호출할 때에 인스턴스가 없다면 생성한다
 * 
 *         이 방식으로 구현할 경우 Eager, SaticBlock 에서 안고 있던 문제(사용하지 않았을 경우에는 인스턴스가 낭비)에
 *         대해 어느 정도 해결책이 된다.
 * 
 *         그러나 이 경우에도 문제점이 있다. 그건 바로 multi-thread 환경에서 동기화 문제이다
 * 
 *         만약 인스턴스가 생성되지 않은 시점에서 여러 쓰레드가 동시에 getInstance()를 호출한다면 예상치 못한 결과를 얻을
 *         수 있을뿐더러, 단 하나의 인스턴스를 생성한다는 싱글톤 패턴에 위반하는 문제점이 야기될 수 있다
 * 
 *         그렇기에 이 방법으로 구현을 해도 괜찮은 경우는 single-thread 환경이 보장됐을 때이다
 * 
 *
 */
public class LazyInitialization {
	private static LazyInitialization instance;

	private LazyInitialization() {
	}

	public static LazyInitialization getInstance() {
		if (instance == null) {
			instance = new LazyInitialization();
		}
		return instance;
	}
}
