package com.callor.pattern.singletone;

/**
 * 
 * @author callor
 * 
 *         이는 Bill Pugh가 고안한 방식으로, inner static helper class를 사용하는 방식입니다.
 * 
 *         앞선 방식이 안고 있는 문제점들을 대부분 해결한 방식으로, 현재 가장 널리 쓰이는 싱글톤 구현 방법입니다. 코드를 먼저
 *         살펴보고 이어서 설명하겠습니다.
 *
 */
public class BillPughSingletonImplementaion {

	private BillPughSingletonImplementaion() {
	}

	/**
	 * 
	 * @author callor
	 * inner class로 인해 복잡해 보일 수 있지만 생각보다 간단합니다.
	 * 
	 * private inner static class를 두어 싱글톤 인스턴스를 갖게 합니다.
	 * 이때 1번이나 2번 방식과의 차이점이라면 SingletonHelper 클래스는 
	 * Singleton 클래스가 Load 될 때에도 Load 되지 않다가 getInstance()가 
	 * 호출됐을 때 비로소 JVM 메모리에 로드되고, 인스턴스를 생성하게 됩니다.
	 * 
	 * 아울러 synchronized를 사용하지 않기 때문에 4번에서 문제가 되었던 성능 저하 또한 해결됩니다.
	 */
	private static class SingletonHelper {
		private static final BillPughSingletonImplementaion INSTANCE = new BillPughSingletonImplementaion();
	}

	public static BillPughSingletonImplementaion getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
