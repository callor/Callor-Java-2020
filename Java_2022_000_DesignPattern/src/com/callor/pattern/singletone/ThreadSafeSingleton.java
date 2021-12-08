package com.callor.pattern.singletone;


/**
 * 
 * @author callor
 * 
 * Thread Safe Singleton은 3번의 문제를 해결하기 위한 방법으로, 
 * getInstance() 메소드에 synchronized를 걸어두는 방식이다. 
 * synchronized 키워드는 임계 영역(Critical Section)을 형성해 
 * 해당 영역에 오직 하나의 쓰레드만 접근 가능하게 해 준다. 
 *
 */
public class ThreadSafeSingleton {

	 private static ThreadSafeSingleton instance;
	    
	    private ThreadSafeSingleton(){}
	    
	    public static synchronized ThreadSafeSingleton getInstance(){
	        if(instance == null){
	            instance = new ThreadSafeSingleton();
	        }
	        return instance;
	    }
	    /**
	     * 위와 같은 방식으로 구현한다면 getInstance() 메소드 내에 
	     * 진입하는 쓰레드가 하나로 보장받기 때문에 멀티 쓰레드 환경에서도 정상 동작하게 됩니다. 
	     * 그러나 synchronized 키워드 자체에 대한 비용이 크기 때문에 
	     * 싱글톤 인스턴스 호출이 잦은 어플리케이션에서는 성능이 떨어지게 됩니다.
	     * 
	     * 그래서 고안된 방식이 double checked locking 입니다.
	     * 
	     * 이는 getInstance() 메소드 수준에 lock을 걸지 않고 instance가 null일 경우에만 synchronized가 동작하도록 합니다.
	     * 
	     * 코드는 아래와 같습니다.
	     */
	    
	    public static ThreadSafeSingleton getInstanceDB(){
	        if(instance == null){
	            synchronized (ThreadSafeSingleton.class) {
	                if(instance == null){
	                    instance = new ThreadSafeSingleton();
	                }
	            }
	        }
	        return instance;
	    }
	    
	
}
