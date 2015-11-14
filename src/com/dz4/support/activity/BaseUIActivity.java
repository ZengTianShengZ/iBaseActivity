package com.dz4.support.activity;

import android.os.Bundle;
import android.view.Window;

public abstract class BaseUIActivity extends BaseActivity {
	public abstract void initView();
	public abstract void initData();
	public abstract void initEvent();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initView();
		initData();
		initEvent();
	}
	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
	}
}
