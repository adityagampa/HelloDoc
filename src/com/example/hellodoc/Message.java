package com.example.hellodoc;

import android.content.Context;
import android.widget.Toast;

public class Message 
{
	public static void message(Context context,String s)
	{
		Toast.makeText(context, s, Toast.LENGTH_LONG).show();
	}
}
