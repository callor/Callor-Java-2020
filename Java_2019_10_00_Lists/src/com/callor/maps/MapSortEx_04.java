package com.callor.maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapSortEx_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List 안에있는 Map 데이터를 입력 (num은 0부터 하는걸 추천: 배열번호로 추출하기 때문)
		String sample = "sum=4.3207455E8, num=0, 0=3.5337459E7, comp_nm=A사"
				+ "`sum=2.191123E7, num=1, 0=1991930.0, comp_nm=B사" + "`sum=8030636.0, num=2, 0=730057.0, comp_nm=C사"
				+ "`sum=6.7682255E7, num=3, 0=6152932.0, comp_nm=D사" + "`sum=1195123.0, num=4, 0=108647.0, comp_nm=E사";

		String[] main = sample.split("`");

		List<HashMap> listData = new ArrayList();

		HashMap<String, Object> hashmap1 = new HashMap<String, Object>();

		for (String sub : main) {

			String[] main2 = sub.split(",");

			hashmap1 = new HashMap<String, Object>();
			for (String sub2 : main2) {

				hashmap1.put(sub2.split("=")[0].trim(), sub2.split("=")[1].trim());

			}

			listData.add(hashmap1);

		}

		// 데이터 생성 완료
		for (HashMap<String, Object> tmp : listData) {

			System.out.println(tmp);

		}

		System.out.println("========================================================");

		// List 안에있는 Map 중에서 sum이 큰 수로 내림정렬 하시오
		HashMap<String, Double> map = new HashMap<String, Double>();
		ValueComparatorV2 bvc = new ValueComparatorV2(map);
		TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);

		// 리스트에서 순번과 합계만 따로 맵에 넣는다.
		for (HashMap<String, Object> hashmap : listData) {

			map.put((String) hashmap.get("num"), Double.parseDouble((String) hashmap.get("sum")));

		}

		// 정렬 (Map의 값 정렬)
		sorted_map.putAll(map);
		// 맵 정렬 출력
		System.out.println(sorted_map);
		System.out.println("========================================================");

		List<HashMap<String, Object>> resultListData = new ArrayList();

		for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
			// 정렬한 리스트에서 순번을 배열번호로 변경하여 원본 리스트에서 추출
			resultListData.add(listData.get(Integer.parseInt(entry.getKey())));
		}

		// 정렬 결과
		for (HashMap<String, Object> tmp : resultListData) {
			System.out.println(tmp);
		}
	}

}

class ValueComparatorV2 implements Comparator<String> {

	Map<String, Double> base;

	/**
	 * @param base
	 */
	public ValueComparatorV2(Map<String, Double> base) {
		this.base = base;
	}

	// Note: this comparator imposes orderings that are inconsistent with equals.
	public int compare(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}
