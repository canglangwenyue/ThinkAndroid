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
package com.ta.util.resoperate;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;

/**
 * @Title TAResOperateUtils
 * @Package com.ta.util.resoperate
 * @Description TAResOperateUtils��һ������Ӧ�ó���Res����Դ
 * @author ��è
 * @date 2013-1-22 ���� 11:25
 * @version V1.0
 */
public class TAResOperateUtils
{

	/**
	 * ��ȡRes�е��ַ���
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID���ַ���
	 */
	public static String doReadString(Context context, int resourceID)
	{
		return context.getResources().getString(resourceID);
	}

	/**
	 * ��ȡRes�е�Colorֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��Colorֵ
	 */
	public static int doReadColor(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getColor(resourceID);
	}

	/**
	 * ��ȡRes�е�ColorStateListֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��ColorStateListֵ
	 */
	public static ColorStateList doReadColorStateList(Context context,
			int resourceID) throws NotFoundException
	{
		return context.getResources().getColorStateList(resourceID);
	}

	/**
	 * ��ȡRes�е�Dimensionֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��Dimensionֵ
	 */
	public static float doReadDimension(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getDimension(resourceID);
	}

	/**
	 * ��ȡRes�е�drawableֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��drawableֵ
	 */
	public static Drawable doReadDrawable(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getDrawable(resourceID);
	}

	/**
	 * ��ȡRes�е�layoutֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��layoutֵ
	 */
	public static XmlResourceParser doReadlayout(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getLayout(resourceID);
	}

	/**
	 * ��ȡRes�е�String����Arrayֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��String����Arrayֵ
	 */
	public static String[] doReadStringArray(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getStringArray(resourceID);
	}

	/**
	 * ��ȡRes�е�int����Arrayֵ
	 * 
	 * @param context
	 * @param resourceID
	 *            ��ԴID
	 * @return ������ӦID��int����Arrayֵ
	 */
	public static int[] doReadIntArray(Context context, int resourceID)
			throws NotFoundException
	{
		return context.getResources().getIntArray(resourceID);
	}
}
