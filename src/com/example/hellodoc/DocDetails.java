package com.example.hellodoc;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class DocDetails extends ActionBarActivity implements OnClickListener
{

	Button book,previous;
	RadioGroup timings;
	RadioButton morning,afternoon,evening;
	String stimings=" 10 : 00 AM ",sdocname,spatname,spatusername;
	
	List <AppointmentsTable> apt;
	List <PatTable> pats;
	MyDb db;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doc_details);
		book =(Button )findViewById(R.id.button1);
		previous =(Button )findViewById(R.id.button2);
		
		timings = (RadioGroup) findViewById(R.id.radioGroup1);
		morning =(RadioButton) findViewById(R.id.radio0);
		afternoon =(RadioButton) findViewById(R.id.radio1);
		evening =(RadioButton) findViewById(R.id.radio2);
		
		db=new MyDb(this);
		
		Intent intent=getIntent();
		sdocname=intent.getStringExtra("dn");
		spatusername=intent.getStringExtra("pn");
		
		pats=db.getAllPatients();
		
		for(PatTable p : pats)
		{
			if(spatusername.equals(p.getPatUsername()))
			{
				spatname=p.getPatName();
				break;
			}
		}

		
		timings.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{

				if(checkedId == R.id.radio0) 
				{
					stimings=" 10 : 00 AM ";
					
					apt=db.getAllAppointments(); 
					for(AppointmentsTable dt :apt)
					{
						if(stimings.equals(dt.getDisplayTime()))
						{
							String d=dt.getDocName();
							Message.message(getApplicationContext(), "Sorry..! Appointment at this timings for Dr."+d+" has already been booked..! Try another slot..! ");
						}
					}
							
				}
				else if(checkedId == R.id.radio1) 
				{
					stimings=" 02 : 00 PM ";
					
					apt=db.getAllAppointments(); 
					for(AppointmentsTable dt :apt)
					{
						if(stimings.equals(dt.getDisplayTime()))
						{
							String d=dt.getDocName();
							Message.message(getApplicationContext(), "Sorry..! Appointment at this timings for Dr."+d+" has already been booked..! Try another slot..! ");
						}
					}
				}
				else
				{
					stimings=" 06 : 00 PM ";
					
					apt=db.getAllAppointments(); 
					for(AppointmentsTable dt :apt)
					{
						if(stimings.equals(dt.getDisplayTime()))
						{
							String d=dt.getDocName();
							Message.message(getApplicationContext(), "Sorry..! Appointment at this timings for Dr."+d+" has already been booked..! Try another slot..! ");
						}
					}
					
				}
			}
			
		});

		
		book.setOnClickListener(this);
		previous.setOnClickListener(this);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doc_details, menu);
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
		
			apt=db.getAllAppointments();

			int flag=0;
			for(AppointmentsTable a : apt)
			{
				if(spatname.contains(a.getPatName()))
				{
					if(sdocname.equals(a.getDocName()))
					{
						Message.message(this, "You have already made an appointment with the same Dr."+sdocname+"..!");
						flag=1;
						super.finish();
					}

				}
			}
			if(flag==0)
			{
				db.addAppointment(new AppointmentsTable(sdocname,spatname ,stimings));
				Message.message(this,"Your Appointment with Dr."+sdocname+" has been fixed at "+stimings+"..!" );
				super.finish();				
			}
			break;
		case R.id.button2:
			
			super.finish();
			
			break;
		}
		
	}
}
