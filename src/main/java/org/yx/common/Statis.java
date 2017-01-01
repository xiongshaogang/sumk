package org.yx.common;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Statis {
	public final String name;

	public final AtomicInteger count;

	public final AtomicLong time;

	public final AtomicInteger failedCount;
	public final AtomicLong failedTime;

	public Statis(String name) {
		this.name = name;
		this.count = new AtomicInteger(0);
		this.time = new AtomicLong(0);
		this.failedCount = new AtomicInteger(0);
		this.failedTime = new AtomicLong(0);
	}

	/**
	 * 增加一次访问
	 * 
	 * @param t
	 */
	public void successVisit(long t) {
		this.count.incrementAndGet();
		this.time.addAndGet(t);
	}

	public void failedVisit(long t) {
		this.failedCount.incrementAndGet();
		this.failedTime.addAndGet(t);
	}

	@Override
	public String toString() {
		return name + ": count=" + count + ", time=" + time + ", failedCount=" + failedCount + ", failedTime="
				+ failedTime;
	}

}
