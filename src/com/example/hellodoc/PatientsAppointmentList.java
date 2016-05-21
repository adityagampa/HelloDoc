package com.example.hellodoc;

import java.util.ArrayList;
import java.util.List;

import com.example.hellodoc.AppointmentsTable;
import com.example.hellodoc.DocTable;
import com.example.hellodoc.Message;
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

public class PatientsAppointmentList extends ActionBarActivity 
{
	ListView listview;
	AppointmentsTable apt;
	DocTable doc;
	MyDb db;
	String docname,patname;
	List<DocTable> doctors;
	List<String> dnames;

	@Override
	public void onCreate(Bundle icicle)  
	{
		super.onCreate(icicle);
		setContentView(R.layout.activity_patients_appointment_list);
		listview=(ListView )findViewById(R.id.listView1);
		
		apt=new AppointmentsTable();
		doc=new DocTable();
		db=new MyDb(this);
		doctors=new ArrayList<DocTable>();
		doctors=db.getAllDoctors();
		dnames=new ArrayList<String>();
		
		Intent intent=getIntent();
		patname = intent.getStringExtra("u2");
		
		
        for (DocTable cn : doctors) 
        {
        	dnames.add(cn.getDocName());
        }
        
		
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dnames);

		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{
				
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
				{
					
					docname = (String) parent.getItemAtPosition(position);
					
					List<AppointmentsTable> apt=db.getAllAppointments();
					int count=0;
					for(AppointmentsTable dt :apt)
					{
						if(count==3)
						{
							break;
						}
						if(docname.equals(dt.getDocName()))
						{
							count++;
						}
						
					}
					if(count==3)
					{
						Message.message(getApplicationContext(), "Sorry ..! All the Slots for Dr."+docname+" have been booked already..! Please try booking other doctor..!");
					}
					else
					{
						Message.message(getApplicationContext(), "Dr."+ docname + " selected");
						
						Intent i=new Intent(getApplicationContext(),DocDetails.class);
						
						i.putExtra("dn", docname);
						i.putExtra("pn", patname);
						
						startActivity(i);
						
						finish();						
					}

				}
		});
		

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patients_appointment_list, menu);
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
