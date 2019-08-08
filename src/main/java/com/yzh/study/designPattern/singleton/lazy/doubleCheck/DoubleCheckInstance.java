package com.yzh.study.designPattern.singleton.lazy.doubleCheck;

/**
 * @program: data-analysis
 * @description: 使用代码块锁双重校验
 * @author: HeroYang
 * @create: 2019-08-05 17:37
 **/
public class DoubleCheckInstance {

	//private static DoubleCheckInstance instance;
	//加入volatile避免指令重排
	private static volatile DoubleCheckInstance instance;

	private DoubleCheckInstance(){}

	public static DoubleCheckInstance getInstance(){
		if (instance == null){
			synchronized (DoubleCheckInstance.class){
				//缩短锁的范围，此处为null才会进，较大程度地避免锁竞争
				if (instance == null){
					//new实例分为以下四步
					//1、分配对象的内存空间【memory = allocate();】（获取对象地址）
					//2、初始化对象【ctorInstance(memory);】（生成对象的值 放在 对象地址）
					//3、instance指向对象内存空间【instance = memory;】（引用的值 等于 对象的地址）
					//4、初次访问对象 （instance引用 对象地址 获取 对象的值）

					// 指令优化重排可能导致2,3对调
					// 多线程的情况存在，线程A执行1,3时，线程B在校验instance不为空(在第一层校验的时候)，此时线程B获取到的对象有地址没有值，即没有初始化
					//解决方法：加入volatile禁止指令重排
					instance = new DoubleCheckInstance();
					//volatile的另一层语义是可见性，可见性是指在一个线程中对该变量的修改会马上由工作内存（Work Memory）写回主内存（Main Memory），
					// 所以其它线程会马上读取到已修改的值，关于工作内存和主内存可简单理解为高速缓存（直接与CPU打交道）和主存（日常所说的内存条），
					// 注意工作内存是线程独享的，主存是线程共享的。
				}
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
