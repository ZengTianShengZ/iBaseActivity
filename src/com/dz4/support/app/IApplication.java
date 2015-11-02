package com.dz4.support.app;

import com.dz4.support.R;
import com.dz4.support.proxy.DialogProxy;
import com.dz4.support.service.LocalService;
import com.dz4.support.service.LocalService.LocalServiceBinder;
import com.dz4.support.utils.ActivityManagerUtils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class IApplication extends Application {
	private NativeServiceConnection mServiceConnection;
	private LocalServiceBinder mLocalServiceBinder;
	@Override
	public void onCreate() {
		super.onCreate();
		
		//设置对话框的基本属性
		DialogProxy.setMsgDialogLayoutRes(R.layout.yi_dialog_template);
		DialogProxy.setMsgDialogTheme(R.style.Custom_Dialog_Dim);
		DialogProxy.setProgressDialogLayoutRes(R.layout.yi_progress_dialog_template);
		DialogProxy.setProgressDialogTheme(R.style.Custom_Dialog_Dim);
		
		//开启服务，并绑定服务
		mServiceConnection = new NativeServiceConnection();
		Intent serviceItent =new Intent(getBaseContext(),LocalService.class);
		startService(serviceItent);
		bindService(serviceItent, mServiceConnection , BIND_AUTO_CREATE);
	}
	/**
	 * activity管理
	 * 
	 * 
	 * @param ac
	 */
	
	public void addActivity(Activity ac){
		ActivityManagerUtils.getInstance().addActivity(ac);
	}
	
	public void exit(){
		ActivityManagerUtils.getInstance().removeAllActivity();
	}
	
	public Activity getTopActivity(){
		return ActivityManagerUtils.getInstance().getTopActivity();
	}
	/**
	 * 得到实现与服务交互对象Binder
	 * 
	 * @return
	 */
	public LocalServiceBinder getLocalService(){
		return mLocalServiceBinder;
	}
	/**
	 * 用于实现与服务交互的连接器
	 * 
	 * @return
	 */
	private class NativeServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name,
				IBinder service) {
			// TODO 自动生成的方法存根
			mLocalServiceBinder=(LocalServiceBinder)service;
		}
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO 自动生成的方法存根
			mLocalServiceBinder=null;
		}
		
	}
}
