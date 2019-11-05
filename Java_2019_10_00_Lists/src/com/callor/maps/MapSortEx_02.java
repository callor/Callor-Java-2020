package com.callor.maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.callor.maps.domain.MapsVO;

public class MapSortEx_02 {

	public static void main(String[] args) {

		Map<String, MapsVO> map = new HashMap<String,MapsVO>();
        map.put("A", MapsVO.builder().name("홍길동").num("001").build());
        map.put("B", MapsVO.builder().name("이몽룡").num("002").build());
        map.put("C", MapsVO.builder().name("성춘향").num("003").build());
        map.put("D", MapsVO.builder().name("장보고").num("004").build());
        map.put("E", MapsVO.builder().name("성춘향").num("005").build());
        map.put("F", MapsVO.builder().name("장영실").num("006").build());
        map.put("G", MapsVO.builder().name("임꺽정").num("007").build());
        
        /*
         * Map.Entry 인터페이스
         * Map에 저장되는 Key Value 쌍을 다루기 위해 Map의 내부에 정의된 내부 인터페이스
         * 맵에 저장되는 엔트리의 조작을 위한 method가 정의 되어 있다
         * 
         * map.entrySet() method는
         * key와 value가 모두 필요한 경우 사용한다.
         */
        
        // Map을 value값으로 정렬하기 위하여
        // Map.Entry<> 자료를 List로 선언하고
        // map.entrySet() 메서드를 사용하여 List를 채운다.
        List<Map.Entry<String, MapsVO>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, MapsVO>>() {
            @Override
            public int compare(Map.Entry<String, MapsVO> o1, Map.Entry<String, MapsVO> o2) {
            	// int comparision = (o1.getValue() - o2.getValue()) * -1;
            	int comparision = o1.getValue().getName().compareTo(o2.getValue().getName());
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            
            }
        });

        
        // List를 정렬한 후 다시 다른 Map을 생성하여
        // List로 부터 Map을 만든다
        
        // 순서유지를 위해 LinkedHashMap을 사용
        Map<String, MapsVO> sortedMap = new LinkedHashMap<>(); 
        for(Map.Entry<String,MapsVO> m : list) {
        	sortedMap.put(m.getKey(), m.getValue());
        }
        
    
        /*
        for(Iterator<Map.Entry<String, MapsVO>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, MapsVO> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        */
        
        Set<String> keys = sortedMap.keySet();
        for(String key : keys) {
        	System.out.print(key + " : " );
        	System.out.println(sortedMap.get(key));
        }
        // System.out.println(sortedMap);
		
		
	}

}
