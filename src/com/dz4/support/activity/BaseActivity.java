package com.dz4.support.activity;

import com.dz4.support.R;
import com.dz4.support.app.IApplication;
import com.dz4.support.proxy.ActivityProxy;
import com.dz4.support.proxy.DialogProxy;
import com.dz4.support.proxy.DialogProxy.DialogExtProxiable;
import com.dz4.support.proxy.DialogProxy.DialogProxiable;
import com.dz4.support.proxy.ToastProxy.ToastProxiable;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View.OnClickListener;
/**
 * 封装常用功能的activity
 * 集成吐司，对话框功能
 * @author MZone
 *
 */
public class BaseActivity extends Activity implements ToastProxiable,DialogProxiable,DialogExtProxiable
{
	private ActivityProxy mActivityProxy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		mActivityProxy=new ActivityProxy(this);
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		mActivityProxy.onDestroy();
	}
	@Override
	public void showToast(String text) {
		// TODO 自动生成的方法存根
		mActivityProxy.showToast(text);
	}
	@Override
	public void showToast(int resourceId) {
		// TODO 自动生成的方法存根
		mActivityProxy.showToast(resourceId);
	}
	/////////////////////////////////////////
	
	
	
	@Override
	public void showMsgDialog() {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog();
	}
	@Override
	public void showMsgDialogWithSize(int width, int height) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialogWithSize(width, height);
	}
	@Override
	public DialogProxy getDialogProxy() {
		// TODO 自动生成的方法存根
		return mActivityProxy.getDialogProxy();
	}
	@Override
	public void cancelMsgDialog() {
		// TODO 自动生成的方法存根
		mActivityProxy.cancelMsgDialog();
		
	}
	@Override
	public void showProgressDialog() {
		// TODO 自动生成的方法存根
		mActivityProxy.showProgressDialog();
	}
	@Override
	public void cancelProgressDialog() {
		// TODO 自动生成的方法存根
		mActivityProxy.cancelProgressDialog();
	}
	
	/****************************************
	 * 
	 * DialogExProxyable
	 * 
	 ******************************************/
	
	@Override
	public void showProgressDialog(String msg, OnCancelListener listener,
			boolean cancelable) {
		// TODO 自动生成的方法存根
		mActivityProxy.showProgressDialog(msg, listener, cancelable);
	}
	@Override
	public void showProgressDialog(String msg) {
		// TODO 自动生成的方法存根
		mActivityProxy.showProgressDialog(msg, null, true);
	}
	@Override
	public void showProgressDialog(int resid) {
		// TODO 自动生成的方法存根
		mActivityProxy.showProgressDialog(getString(resid), null, true);
	}
	@Override
	public void showMsgDialog(String title, String detials, String btnLeft,
			String btnRight, OnClickListener btnLeftListener,
			OnClickListener btnRightListener) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog(title, detials, btnLeft, btnRight, btnLeftListener, btnRightListener);
		
	}
	@Override
	public void showMsgDialog(String detials, String btnLeft,
			OnClickListener btnLeftListener) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog(null, detials, btnLeft, null, btnLeftListener, null);
	}
	@Override
	public void showMsgDialog(String title, String detials, String btnLeft) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog(title, detials, btnLeft, null, null, null);
	}
	@Override
	public void showMsgDialog(String detials, String btnLeft) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog(null, detials, btnLeft, null, null, null);
	}
	@Override
	public void showMsgDialog(String detials) {
		// TODO 自动生成的方法存根
		mActivityProxy.showMsgDialog(null, detials, getString(R.string.str_ok), null, null, null);
	}
	@Override
	public void showMsgDialog(int res) {
		// TODO 自动生成的方法存根
		showMsgDialog(getString(res));
	}
}
