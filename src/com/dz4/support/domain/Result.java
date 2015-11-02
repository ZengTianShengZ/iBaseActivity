package com.dz4.support.domain;

import android.os.Bundle;
/**
 * 
 * mHandler的消息对象
 * 可用于耗时任务时，得到返回结果，来响应UI
 * @author MZone
 *
 */
public class Result {
	public enum Status {
		SUCCESS, FAILED
	}

	public enum Cmds {
		UNKNOWN
	}
	public Cmds what;
	public Status status = Status.FAILED;
	public Bundle data;
	public int arg0;
	public int arg1;
	public Object obj;
	
	public Result() {
		data = null;
		what = Cmds.UNKNOWN;
		arg0 = 0;
		arg1 = 0;
		obj = null;
	}

}
