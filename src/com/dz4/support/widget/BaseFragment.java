package com.dz4.support.widget;

import com.dz4.support.R;
import com.dz4.support.proxy.ActivityProxy;
import com.dz4.support.proxy.DialogProxy;
import com.dz4.support.proxy.DialogProxy.DialogExtProxiable;
import com.dz4.support.proxy.DialogProxy.DialogProxiable;
import com.dz4.support.proxy.HandlerProxy;
import com.dz4.support.proxy.HandlerProxy.HandlerProxiable;
import com.dz4.support.proxy.ToastProxy.ToastProxiable;

import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public abstract class BaseFragment extends Fragment implements
		HandlerProxiable, ToastProxiable, DialogProxiable,
		DialogExtProxiable {
	private HandlerProxy mHandlerProxy;
	protected ActivityProxy mActivityProxy;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mActivityProxy = new ActivityProxy(getActivity());
		initView();
		initData();
		initEvent();
		return super.onCreateView(inflater, container, savedInstanceState);
	};

	public abstract void initView();

	public abstract void initData();

	public abstract void initEvent();

	@Override
	public void onDestroy() {
		mActivityProxy.onDestroy();
		super.onDestroy();
	}

	/*******************************************************************************
	 * HandlerProxy
	 *******************************************************************************/
	protected void initHandlerProxy() {
		if (mHandlerProxy == null) {
			mHandlerProxy = new HandlerProxy(getActivity(), this);
		}
	}

	@Override
	public Handler getHandler() {
		initHandlerProxy();
		return mHandlerProxy.getHandler();
	}

	/*******************************************************************************
	 * ToastProxy
	 *******************************************************************************/
	@Override
	public void showToast(int resourceId) {
		mActivityProxy.showToast(resourceId);
	}

	@Override
	public void showToast(String text) {
		mActivityProxy.showToast(text);
	}

	/*******************************************************************************
	 * DialogProxy
	 *******************************************************************************/
	@Override
	public void showMsgDialog() {
		// TODO Auto-generated method stub
		mActivityProxy.showMsgDialog();
	}

	@Override
	public void showMsgDialogWithSize(int width, int height) {
		// TODO Auto-generated method stub
		mActivityProxy.showMsgDialogWithSize(width, height);
	}

	@Override
	public void showProgressDialog() {
		// TODO Auto-generated method stub
		mActivityProxy.showProgressDialog();
	}

	@Override
	public void cancelProgressDialog() {
		// TODO Auto-generated method stub
		mActivityProxy.cancelProgressDialog();
	}

	@Override
	public DialogProxy getDialogProxy() {
		// TODO Auto-generated method stub
		return mActivityProxy.getDialogProxy();
	}

	@Override
	public void cancelMsgDialog() {
		// TODO Auto-generated method stub
		mActivityProxy.cancelMsgDialog();
	}

	public void showMsgDialog(int res) {
		showMsgDialog(getString(res));
	}

	public void showMsgDialog(String detials) {
		showMsgDialog(null, detials, getString(R.string.str_ok), null,
				null, null);
	}

	public void showMsgDialog(String detials, String btnLeft) {
		showMsgDialog(null, detials, btnLeft, null, null, null);
	}

	public void showMsgDialog(String title, String detials, String btnLeft) {
		showMsgDialog(title, detials, btnLeft, null, null, null);
	}

	public void showMsgDialog(String detials, String btnLeft,
			View.OnClickListener btnLeftListener) {
		showMsgDialog(null, detials, btnLeft, null, btnLeftListener,
				null);
	}

	public void showMsgDialog(String title, String detials, String btnLeft,
			String btnRight, View.OnClickListener btnLeftListener,
			View.OnClickListener btnRightListener) {
		mActivityProxy.showMsgDialog(title, detials, btnLeft, btnRight,
				btnLeftListener, btnRightListener);
	}

	public void showProgressDialog(int resid) {
		showProgressDialog(getString(resid), null, true);
	}

	public void showProgressDialog(String msg) {
		showProgressDialog(msg, null, true);
	}

	public void showProgressDialog(String msg, OnCancelListener listener,
			boolean cancelable) {
		mActivityProxy.showProgressDialog(msg, listener, cancelable);
	}

}
