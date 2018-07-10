package io.nekopara.proxy.impl;

import java.util.Random;

import io.nekopara.proxy.intf.Moveable;

public class Tank implements Moveable {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank Moving....");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time::"+(end - start));
	}

}
