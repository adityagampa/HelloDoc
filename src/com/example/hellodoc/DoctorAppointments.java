package com.example.hellodoc;

import java.util.ArrayList;
import java.util.List;

import com.example.hellodoc.AppointmentsTable;
import com.example.hellodoc.MyDb;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoctorAppointments extends ActionBarActivity 
{
	ListView listview;
	AppointmentsTable apt;
	List <DocTable> dt;
	MyDb db;
	String docname,name;
	List<AppointmentsTable> appointments;
	List<String> pnames;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_appointments);
		listview=(ListView )findViewById(R.id.listView1);
		
		apt=new AppointmentsTable();
		db=new MyDb(this);
		
		appointments=db.getAllAppointments();
		dt=db.getAllDoctors();
		
		pnames=new ArrayList<String>();
		
		Intent intent=getIntent();
		name = intent.getStringExtra("u2");
		
		for(DocTable d : dt)
		{
			if(name.equals( ( d.getDocUsername() ) ) )
			{
				docname=d.getDocName();
			}
		}
		
        for (AppointmentsTable cn : appointments) 
        {
        	if(docname.equals(cn.getDocName()))
        	{
        		String s=cn.getPatName() +" 		@		" +cn.getDisplayTime();
        		pnames.add(s);
        	}
        }
        
		
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pnames);

		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{
				
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
				{


				}
		});
		
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doctor_appointments, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
