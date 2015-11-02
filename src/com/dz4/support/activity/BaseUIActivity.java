package com.dz4.support.activity;

import android.os.Bundle;

public abstract class BaseUIActivity extends BaseActivity {
	public abstract void initView();
	public abstract void initData();
	public abstract void initEvent();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		initView();
		initData();
		initEvent();
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
	}
}
