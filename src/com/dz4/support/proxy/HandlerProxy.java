package com.dz4.support.proxy;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/**
 * 处理对象的代理器
 * handle功能由他代理实现
 * @author MZone
 *
 */
public class HandlerProxy
{
	private Context mContext;
	private Handler mHandler;
	private HandlerProxiable mHandlerProxiable;

	public HandlerProxy(Context context, HandlerProxiable handlerProxiable)
	{
		mContext = context;
		mHandlerProxiable = handlerProxiable;
		mHandler = new Handler(mContext.getMainLooper())
		{
			@Override
			public void handleMessage(Message msg)
			{
				processHandlerMessage(msg);
			}
		};
	}

	public void processHandlerMessage(Message msg)
	{
		mHandlerProxiable.processHandlerMessage(msg);
	}

	public Handler getHandler()
	{
		return mHandler;
	}

	public interface HandlerProxiable
	{
		void processHandlerMessage(Message msg);

		Handler getHandler();
	}
}
