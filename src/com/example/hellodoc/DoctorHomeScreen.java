package com.example.hellodoc;

import com.example.hellodoc.DoctorAppointments;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DoctorHomeScreen extends ActionBarActivity implements OnClickListener 
{
	Button appointments,logout;
	String susername,spassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_home_screen);

		logout=(Button )findViewById(R.id.button1);
		appointments = (Button )findViewById(R.id.button2);

		
		Intent intent=getIntent();
		
		susername=intent.getStringExtra("u1");
		spassword=intent.getStringExtra("p1");
		
		appointments.setOnClickListener(this);
		logout.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doctor_home_screen, menu);
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
		case R.id.button1:
			
			super.finish();
		
			break;
		case R.id.button2:
			
			Intent i=new Intent(this,DoctorAppointments.class);
			i.putExtra("u2", susername);
			startActivity(i);			
			
			break;
		}
		
	}
}
