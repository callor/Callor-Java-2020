package com.callor.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.callor.maps.domain.MapsVO;

public class MapSortEx_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Map<String, MapsVO> map = new HashMap<String,MapsVO>();
        map.put("A", MapsVO.builder().name("홍길동").num("001").build());
        map.put("B", MapsVO.builder().name("이몽룡").num("002").build());
        map.put("C", MapsVO.builder().name("성춘향").num("003").build());
        map.put("D", MapsVO.builder().name("장보고").num("004").build());
        map.put("E", MapsVO.builder().name("성춘향").num("005").build());
        map.put("F", MapsVO.builder().name("장영실").num("006").build());
        map.put("G", MapsVO.builder().name("임꺽정").num("007").build());
		
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, MapsVO> sorted_map = new TreeMap<String, MapsVO>(bvc);

		sorted_map.putAll(map);

		for (Map.Entry<String, MapsVO> entry : sorted_map.entrySet()) {
			// 정렬한 리스트에서 순번을 배열번호로 변경하여 원본 리스트에서 추출
			System.out.println(entry.getKey() + " : " + map.get(entry.getKey()));
		}

	}

}

class ValueComparator implements Comparator<String> {

	Map<String, MapsVO> base;

	public ValueComparator(Map<String, MapsVO> base) {
		this.base = base;
	}

	// Note: this comparator imposes orderings that are inconsistent with equals.
	public int compare(String a, String b) {
		
		return base.get(a).getName().compareTo( base.get(b).getName());   // 내림차순
		// return base.get(b).getName().compareTo( base.get(a).getName());   // 오름차순
		
		
		/*
		if( base.get(a).getName().compareTo( base.get(b).getName() ) ) { // 반대로 하면 오름차순 <=
		
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
		*/
	}
}
