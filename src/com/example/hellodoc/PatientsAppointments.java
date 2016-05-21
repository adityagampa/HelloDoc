package com.example.hellodoc;

import com.example.hellodoc.PatientsAppointmentList;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PatientsAppointments extends ActionBarActivity implements OnClickListener 
{
	String susernamep,spasswordp;
	Button logout,book;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patients_appointments);
		
		Intent intent=getIntent();
		
		susernamep=intent.getStringExtra("u1");
		spasswordp=intent.getStringExtra("p1");
		
		logout=(Button )findViewById(R.id.button1);
		book=(Button )findViewById(R.id.button2);
		
		logout.setOnClickListener(this);
		book.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patients_appointments, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button1 :
			super.finish();
			
			break;
		case R.id.button2 :
			
			Intent i=new Intent(this,PatientsAppointmentList.class);
			i.putExtra("u2", susernamep);
			startActivity(i);
			
			break;
		}
		
	}
}
