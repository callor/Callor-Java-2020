package com.callor.pattern.singletone;

/**
 * 
 * @author callor
 * 
 * 앞서 1~5번에서 살펴본 싱글톤 방식은 사실 완전히 안전할 수 없습니다. 
 * 왜냐하면 Java의 Reflection을 통해서 싱글톤을 파괴할 수 있기 때문입니다.
 * 
 * 이에 Java 계의 거장 Joshua Bloch는 Enum으로 싱글톤을 구현하는 방법을 제안했습니다.
 * 그러나 이 방법 또한 1, 2번과 같이 사용하지 않았을 경우의 메모리 문제를 해결하지 못한 것과 
 * 유연성이 떨어진다는 면에서의 한계를 지니고 있습니다.
 *
 * 
 * 각각의 방식마다 장단점이 있어 무엇이 항상 옳은 구현이라고 할 수 없지만 
 * BillPughSingletonImplementaion의 
 * inner static class 방식을 사용하는 것이 대부분의 경우에 최선의 방법이 아닐까 생각됩니다.
 * 실제로 유명한 자바 오픈 소스 프로젝트의 코드를 살펴보시면
 *  
 * BillPughSingletonImplementaion의 
 * inner static class 방식 싱글톤을 사용하고 있는 것을 확인할 수 있습니다.
 *
 */
public enum EnumSingleton {
	  	INSTANCE;
	    public static void doSomething(){
	        //do something
	    }

}


