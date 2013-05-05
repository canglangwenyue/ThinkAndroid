/*
 * Copyright (C) 2013  WhiteCat ��è (www.thinkandroid.cn)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ta.util.netstate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ta.TAApplication;
import com.ta.util.TALogger;
import com.ta.util.netstate.NetWorkUtil.netType;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @Title NetworkStateReceiver
 * @Package com.ta.util.netstate
 * @Description ��һ���������״̬�ı�ģ���Ҫ���� <receiver
 *              android:name="com.ta.core.util.extend.net.NetworkStateReceiver"
 *              > <intent-filter> <action
 *              android:name="android.net.conn.CONNECTIVITY_CHANGE" /> <action
 *              android:name="android.cat.conn.CONNECTIVITY_CHANGE" />
 *              </intent-filter> </receiver>
 * @author ��è
 * @date 2013-5-5 ���� 22:47
 * @version V1.2
 */
public class NetworkStateReceiver extends BroadcastReceiver
{
	private static Boolean networkAvailable = false;
	private netType netType;
	private static HashMap<String, TANetChangeObserver> netChangeObserverHashMap = new HashMap<String, TANetChangeObserver>();

	@Override
	public void onReceive(Context context, Intent intent)
	{
		TALogger.i(NetworkStateReceiver.this, "����״̬�ı�.");
		Iterator<Entry<String, TANetChangeObserver>> iter = netChangeObserverHashMap
				.entrySet().iterator();
		if (!NetWorkUtil.isNetworkAvailable(context))
		{
			TALogger.i(NetworkStateReceiver.this, "û����������.");

			networkAvailable = false;
		} else
		{
			TALogger.i(NetworkStateReceiver.this, "�������ӳɹ�.");
			netType = NetWorkUtil.getAPNType(context);
			networkAvailable = true;
		}
		while (iter.hasNext())
		{
			Map.Entry<String, TANetChangeObserver> entry = iter.next();
			TANetChangeObserver observer = entry.getValue();
			if (observer != null)
			{
				notifyObserver(observer);
			}
		}
	}

	/**
	 * ��ȡ��ǰ����״̬��trueΪ�������ӳɹ���������������ʧ��
	 * 
	 * @return
	 */
	public static Boolean isNetworkAvailable()
	{
		return networkAvailable;
	}

	public netType getAPNType()
	{
		return netType;
	}

	private void notifyObserver(TANetChangeObserver observer)
	{

		if (isNetworkAvailable())
		{
			observer.connect(netType);
		} else
		{
			observer.disConnect();
		}
	}

	/**
	 * ע���������ӹ۲���
	 * 
	 * @param observerKey
	 *            observerKey
	 * @param observer
	 *            ����仯�۲���
	 */
	public static void registerObserver(String observerKey,
			TANetChangeObserver observer)
	{
		if (netChangeObserverHashMap == null)
		{
			netChangeObserverHashMap = new HashMap<String, TANetChangeObserver>();
		}
		netChangeObserverHashMap.put(observerKey, observer);
	}

	/**
	 * ע���������ӹ۲���
	 * 
	 * @param resID
	 *            observerKey�� ��Դid
	 * @param observer
	 *            ����仯�۲���
	 */
	public static void registerObserver(int resID, TANetChangeObserver observer)
	{
		String observerKey = TAApplication.getApplication().getString(resID);
		registerObserver(observerKey, observer);
	}

	/**
	 * ע���������ӹ۲���
	 * 
	 * @param resID
	 *            observerKey
	 */
	public static void unRegisterObserver(String observerKey)
	{
		if (netChangeObserverHashMap != null)
		{
			netChangeObserverHashMap.remove(observerKey);
		}
	}

	/**
	 * ע���������ӹ۲���
	 * 
	 * @param resID
	 *            observerKey
	 */
	public static void unRegisterObserver(int resID)
	{
		String observerKey = TAApplication.getApplication().getString(resID);
		unRegisterObserver(observerKey);
	}

}