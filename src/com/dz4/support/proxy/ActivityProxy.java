package com.dz4.support.proxy;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import android.view.View;

import com.dz4.support.proxy.ToastProxy.ToastProxiable;
import com.dz4.support.utils.UtilsTools;
/**
 * 
 * 封装了Dialog代理器，Toast代理器的
 * activity的代理对象。
 * 对话框，吐司的功能由他代理实现
 * 
 * @author MZone
 *
 */
public class ActivityProxy implements ToastProxiable {
	private ToastProxy mToastProxy;
	private DialogProxy mDialogProxy;
	private Context mContext;
	private Handler mHandler = new Handler();
	public ActivityProxy(Context context){
		this.mContext=context;
	}
	public void onDestroy()
	{
		if (mDialogProxy != null)
		{
			mDialogProxy.cancelMsgDialog();
			mDialogProxy.cancelProgressDialog();
		}
	}
	public void initToastProxy(){
		if(mToastProxy==null){
			mToastProxy=new ToastProxy(mContext);
		}
	}
	
	public void showToast(final String text) {
		// TODO 自动生成的方法存根
		
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				initToastProxy();
				mToastProxy.showToast(text);
			}
		});
		
	}

	
	public void showToast(final int resourceId) {
		// TODO 自动生成的方法存根
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				initToastProxy();
				mToastProxy.showToast(resourceId);
			}
		});
	}
	
	protected void initDialogProxy()
	{
		if (mDialogProxy == null)
		{
			mDialogProxy = new DialogProxy(mContext);
		}
	}

	public void showMsgDialog()
	{
		// TODO Auto-generated method stub
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				initDialogProxy();
				mDialogProxy.showMsgDialog();
			}
		});
	}

	public void showMsgDialogWithSize(final int width, final int height)
	{
		// TODO Auto-generated method stub
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				initDialogProxy();
				mDialogProxy.showMsgDialogWithSize(width, height);
			}
		});
	}

	public void showProgressDialog()
	{
		// TODO Auto-generated method stub
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				initDialogProxy();
				mDialogProxy.showProgressDialog();
			}
		});
	}

	public void cancelProgressDialog()
	{
		// TODO Auto-generated method stub
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				initDialogProxy();
				mDialogProxy.cancelProgressDialog();
			}
		});
	}

	public DialogProxy getDialogProxy()
	{
		// TODO Auto-generated method stub
		initDialogProxy();
		return mDialogProxy;
	}

	public void cancelMsgDialog()
	{
		// TODO Auto-generated method stub
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				initDialogProxy();
				mDialogProxy.cancelMsgDialog();
			}
		});
	}

	/*******************************************************************************
	 * DialogProxy expand
	 *******************************************************************************/
	public void showMsgDialog(final String title, final String detials,
			final String btnLeft, final String btnRight,
			final View.OnClickListener btnLeftListener,
			final View.OnClickListener btnRightListener)
	{
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				DialogProxy dialogProxy = getDialogProxy();
				if (!UtilsTools.isStringInvalid(title))
				{
					dialogProxy.showMsgDialogTitle();
					dialogProxy.setMsgDialogTitle(title);
				}
				else
				{
					dialogProxy.hideMsgDialogTitle();
				}

				if (!UtilsTools.isStringInvalid(detials))
				{
					dialogProxy.showMsgDialogDetailMsg();
					dialogProxy.setMsgDialogDetailMsg(detials);
				}
				else
				{
					dialogProxy.hideMsgDialogDetailMsg();
				}

				if (!UtilsTools.isStringInvalid(btnLeft))
				{
					dialogProxy.showMsgDialogBtnLeft();
					dialogProxy.setMsgDialogBtnLeftText(btnLeft);
				}
				else
				{
					dialogProxy.hideMsgDialogBtnLeft();
				}

				if (!UtilsTools.isStringInvalid(btnRight))
				{
					dialogProxy.showMsgDialogBtnRight();
					dialogProxy.setMsgDialogBtnRightText(btnRight);
				}
				else
				{
					dialogProxy.hideMsgDialogBtnRight();
				}
				dialogProxy.setMsgDialogCanceledOnTouchOutside(true);
				dialogProxy.setMsgDialogBtnLeftClickListener(btnLeftListener);
				dialogProxy.setMsgDilaogBtnRightClickListener(btnRightListener);
				dialogProxy.showMsgDialog();
			}
		});
	}

	public void showProgressDialog(final String msg,
			final OnCancelListener listener, final boolean cancelable)
	{
		mHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				DialogProxy dialogProxy = getDialogProxy();

				if (!UtilsTools.isStringInvalid(msg))
				{
					dialogProxy.showProgressDialogMsg();
					dialogProxy.setProgressDialogMsgText(msg);
				}
				else
				{
					dialogProxy.hideProgressDialogMsg();
				}

				dialogProxy.setProgressDialogCancelable(cancelable);
				dialogProxy.setProgressDialogCancelListener(listener);

				dialogProxy.showProgressDialog();
			}
		});
	}
	
}
