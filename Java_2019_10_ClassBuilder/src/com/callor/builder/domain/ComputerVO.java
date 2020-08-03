package com.callor.builder.domain;

/*
 * Builder 패턴을 사용하는 VO
 */
public class ComputerVO {
	
	private String HDD;
	private String RAM;
	
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	public ComputerVO() {
	}
	
	private ComputerVO(Builder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	// 110478933316
	
	public static Builder builder() {
		return new ComputerVO.Builder();
	}
	
	@Override
	public String toString() {
		return "ComputerVO [HDD=" + HDD + ", RAM=" + RAM + ", isGraphicsCardEnabled=" + isGraphicsCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}

	public static class Builder {
		private String HDD;
		private String RAM;
		
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}
	

		public Builder HDD(String HDD) {
			this.HDD = HDD;
			return this;
		}

		public Builder RAM(String RAM){
			this.RAM = RAM;
			return this;
		}
		
		public Builder GraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public Builder BluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public ComputerVO build(){
			return new ComputerVO(this);
		}
	}
}
