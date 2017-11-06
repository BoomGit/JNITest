package com.boom;
import java.util.Random;
import java.util.UUID;

import javax.sound.midi.VoiceStatus;

import com.sun.javafx.runtime.VersionInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.recompile;

import jdk.nashorn.internal.objects.NativeDataView;

public class JNITest {
	public static native String getStringFromC();
	
	public native String getString2FromC(int i);

	public  String name ="jason";

	public static int age = 21;
	
	public Human mHuman  = new Man();
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	

	public int getRandomInt(int Max){
		System.out.println("getRandInt");
		return new Random().nextInt(Max);
	}	
	
	
	public native String accessField();

	public native void accessStaticField();

	public native void accessMethod();

	public native void accessStaticMethod();
	
	public native Object accessConstaructor();
	
	public native void accessNovirtualMethod();
	
	public native String chineseChars(String in);
	
	public native void giveArray(int[] arr);
	
	public native int[] getArray(int len);
	
	public native void localRef();
	
	public native void createGlobalRef();
	
	public native String getGloballRef();
	
	public native void deleteGlobalRef();
	
	public native void exception();
	
	
	
	public static void main(String[] args){
		System.out.println("静态方法：static native");
		String str = getStringFromC();
		System.out.println(str);
		System.out.println("==================");
		System.out.println("非静态方法： native");
		JNITest t = new JNITest();
		str = t.getString2FromC(6);
		System.out.println(str);
		System.out.println("==================");
		System.out.println("获取属性值");
		System.out.println("name 改变之前"+t.name);
		System.out.println("在Jni中修改属性值后，返回值");
		t.accessField();
		System.out.println("name 改变之后"+t.name);
		System.out.println("==================");
		System.out.println("获取静态属性值");
		System.out.println("age 改变之前"+age);
		System.out.println("在Jni中修改静态属性值后，返回值");
		t.accessStaticField();
		System.out.println("age 改变之后"+age);
		System.out.println("==================");
		System.out.println("获取方法");
		t.accessMethod();
		System.out.println("==================");
		System.out.println("获取静态方法");
		t.accessStaticMethod();
		System.out.println("==================");
		System.out.println("中文");
		System.out.println(t.chineseChars("宋江"));
		System.out.println("==================");
		System.out.println("传入数组，排序数组");
		int[] array = {9,100,10,37,5,10};
		//排序
		t.giveArray(array);
		for(int i: array){
			System.out.println(i);
		}
		//===============
		System.out.println("=================");
		System.out.println("传入数组，返回数组，刷新数组");
		int[] array2 =t.getArray(10);
		for(int i: array){
			System.out.println(i);
		}
		System.out.println("=================");
		System.out.println("创建全局变量");
		t.createGlobalRef();
		System.out.println("=================");
		System.out.println("得到全局变量");
		System.out.println(t.getGloballRef());
		System.out.println("=================");
		//用完释放
		System.out.println("释放全局变量");
		t.deleteGlobalRef();
		System.out.println("释放完了。。。。");
		System.out.println("=================");
		System.out.println("捕捉java中的异常");
		try{
			t.exception();
		}catch (Exception e) {
			System.out.println("发生异常："+e.getMessage());
		}
		System.out.println("=================");
		System.out.println("C中的异常，在C层进行处理，并自定义异常");
		try{
			t.exception();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("=================");
	}
	
	static{
		System.load("E:\\Users\\Boom\\workspace\\JNITest\\src\\NdkTest.dll");
	}

}
