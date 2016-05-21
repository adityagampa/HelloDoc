package com.example.hellodoc;

import com.example.hellodoc.DocTable;
import com.example.hellodoc.DoctorLogin;
import com.example.hellodoc.Message;
import com.example.hellodoc.MyDb;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorSecondRegistration extends ActionBarActivity implements OnClickListener
{
	EditText username,password,reenterpassword;
	Button submit;
	String susername,spassword,sreenterpassword,sname,semail,smobile;
	MyDb db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_second_registration);
		username=(EditText )findViewById(R.id.editText1);
		password=(EditText )findViewById(R.id.editText2);
		reenterpassword=(EditText )findViewById(R.id.editText3);
		submit=(Button )findViewById(R.id.button1);
		submit.setOnClickListener(this);
		
		Intent intent=getIntent();
		sname=intent.getStringExtra("sname2");
		semail=intent.getStringExtra("semail2");
		smobile=intent.getStringExtra("smobile2");
		
		db=new MyDb(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doctor_second_registration, menu);
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
	
	public void getSomeMoreDetails()
	{
		susername=username.getText().toString();
		spassword=password.getText().toString();
		sreenterpassword=reenterpassword.getText().toString();
	}
	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		
		case R.id.button1:
			getSomeMoreDetails();
			if(susername=="")
			{
				Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show();
			}
			else if(susername.length()<6)
			{
				Toast.makeText(this, "Username : min 6 characters", Toast.LENGTH_SHORT).show();
			}
			else if(susername.length()>=6)
			{
				if(!db.docUsernameAvailability(susername))
				{
					Message.message(this, "username has been already taken..! try another..!");
				}
				else
				{
					if(spassword.length()<8)
					{
						Toast.makeText(this, "Password : min 8 characters", Toast.LENGTH_SHORT).show();
					}
					else if(spassword.length()>=8)
					{
						if(!sreenterpassword.equals(spassword))
						{
							Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
						}
						else
						{
							db.addDoctor(new DocTable(sname,semail,smobile,susername,spassword));
							Intent j=new Intent(this,DoctorLogin.class);
							startActivity(j);						
						}
					}
				}
			}
			
			break;
		}
		
	}
}
