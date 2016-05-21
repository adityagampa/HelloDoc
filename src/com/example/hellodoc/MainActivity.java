package com.example.hellodoc;

import com.example.hellodoc.DoctorRegistration;
import com.example.hellodoc.PatientRegistration;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener
{

	Button doctor;
	Button patient;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doctor=(Button )findViewById(R.id.button1);
		patient=(Button )findViewById(R.id.button2);
		doctor.setOnClickListener(this);
		patient.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			Intent i=new Intent(this,DoctorRegistration.class);
			startActivity(i);
			break;
		case R.id.button2 :
			Intent q=new Intent(this,PatientRegistration.class);
			startActivity(q);
			break;
		}
	}

	
}
