package com.dz4.support.service;

import java.lang.ref.WeakReference;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
/**
 * 
 * 本地服务对象
 * @author MZone
 *
 */
public class LocalService extends Service {
	private HandlerThread mExecutorThread;
	private ServiceExecutor mExecutor;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return new LocalServiceBinder(this);
	}
	@Override
	public void onCreate() {
		// TODO 自动生成的方法存根
		super.onCreate();
		mExecutorThread = new HandlerThread("LocalServiceExecutorThread");
		mExecutorThread.start();
	}
	public ServiceExecutor getServiceExecutor(){
		if(mExecutor==null){
			mExecutor= new ServiceExecutor(this, mExecutorThread.getLooper());
		}
		return mExecutor;
		
	}
	@Override
	public void onDestroy()
	{
		// 停止WorkThread
		if (mExecutorThread != null)
		{
			mExecutorThread.quit();
			mExecutor = null;
			mExecutorThread = null;
		}
		super.onDestroy();
	}
	public static class LocalServiceBinder extends Binder{
		protected WeakReference<LocalService> mServiceHandler;

		public LocalServiceBinder(LocalService s)
		{
			mServiceHandler = new WeakReference<LocalService>(s);
		}

		public void execute(Runnable runnable)
		{
			LocalService s = mServiceHandler.get();
			if (s != null)
			{
				s.getServiceExecutor().execute(runnable);
			}
		}

		public void executeDelayed(Runnable runnable, long delayMillis)
		{
			LocalService s = mServiceHandler.get();
			if (s != null)
			{
				s.getServiceExecutor().execute(runnable, delayMillis);
			}
		}

	}
	protected static class ServiceExecutor extends Handler
	{
		ServiceExecutor(LocalService s, Looper looper)
		{
			super(looper);
		}

		public void execute(Runnable task)
		{
			Message.obtain(this, 0/* don't care */, task).sendToTarget();
		}

		public void execute(Runnable task, long delayMillis)
		{
			Message msg = Message.obtain(this, 0/* don't care */, task);
			sendMessageDelayed(msg, delayMillis);
		}
	}
}
