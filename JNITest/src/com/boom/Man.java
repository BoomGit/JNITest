package com.boom;

public class Man extends Human{

	@Override
	public void sayHi() {
		System.out.println("男人打招呼，儿子是我的...");
	}
	
	public void sayHi2(){
		super.sayHi();
	}

	
}
