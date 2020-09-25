package com.callor.maps.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MapsVO {

	private String num ;
	private String name;
	
}
