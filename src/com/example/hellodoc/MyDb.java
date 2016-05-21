package com.example.hellodoc;

import java.util.ArrayList;
import java.util.List;

import com.example.hellodoc.AppointmentsTable;
import com.example.hellodoc.DocTable;
import com.example.hellodoc.Message;
import com.example.hellodoc.PatTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDb extends SQLiteOpenHelper 
{
	private static final int DATABASE_VERSION = 4;
	private static final String DATABASE_NAME = "HelloDoc.db";
	
	private static final String TABLE_DOC_DETAILS = "DocTable";
	private static final String KEY_DOCID = "did";
	private static final String KEY_DOCNAME = "dname";
	private static final String KEY_DOCEMAIL = "demail";
	private static final String KEY_DOCMOBILE = "dmobile";
	private static final String KEY_DOCUSERNAME = "dusername";
	private static final String KEY_DOCPASSWORD = "dpassword";
	
	private static final String TABLE_PAT_DETAILS = "PatTable";
	private static final String KEY_PATID = "pid";
	private static final String KEY_PATNAME = "pname";
	private static final String KEY_PATEMAIL = "pemail";
	private static final String KEY_PATMOBILE = "pmobile";
	private static final String KEY_PATUSERNAME = "pusername";
	private static final String KEY_PATPASSWORD = "ppassword";
	
	private static final String TABLE_APPOINTMENT_DETAILS = "AppointmentsTable";
	private static final String KEY_AID = "id";
	private static final String KEY_ADOCNAME ="docname";
	private static final String KEY_APATNAME ="patname";
	private static final String KEY_APATDISPLAYNAME ="displayname";
	
	private static final String CREATE_TABLE_DOC_DETAILS = "CREATE TABLE "
			+ TABLE_DOC_DETAILS + "(" + KEY_DOCID + " INTEGER PRIMARY KEY," + KEY_DOCNAME+ " TEXT," 
			+ KEY_DOCEMAIL + " TEXT," + KEY_DOCMOBILE + " TEXT," + KEY_DOCUSERNAME + " TEXT," + KEY_DOCPASSWORD + " TEXT" + ")";
	
	private static final String CREATE_TABLE_PAT_DETAILS = "CREATE TABLE "
			+ TABLE_PAT_DETAILS + "(" + KEY_PATID + " INTEGER PRIMARY KEY," + KEY_PATNAME+ " TEXT," 
			+ KEY_PATEMAIL + " TEXT," + KEY_PATMOBILE + " TEXT," + KEY_PATUSERNAME + " TEXT," + KEY_PATPASSWORD + " TEXT" + ")";

	private static final String CREATE_TABLE_APPOINTMENT_DETAILS = "CREATE TABLE "
			+ TABLE_APPOINTMENT_DETAILS 
			+ "("
			+ KEY_AID + " INTEGER PRIMARY KEY," 
			+ KEY_ADOCNAME+ " TEXT," 
			+ KEY_APATNAME + " TEXT,"
			+ KEY_APATDISPLAYNAME + " TEXT" 
			+ ")";

	
	private final Context context;

	public MyDb(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context=context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(CREATE_TABLE_DOC_DETAILS);
		db.execSQL(CREATE_TABLE_PAT_DETAILS);
		db.execSQL(CREATE_TABLE_APPOINTMENT_DETAILS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOC_DETAILS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAT_DETAILS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENT_DETAILS);

		onCreate(db);
	}

	public void addDoctor(DocTable doc) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_DOCNAME, doc.getDocName());
		values.put(KEY_DOCEMAIL, doc.getDocEmail()); 
		values.put(KEY_DOCMOBILE, doc.getDocMobile()); 
		values.put(KEY_DOCUSERNAME, doc.getDocUsername()); 
		values.put(KEY_DOCPASSWORD, doc.getDocPassword()); 
	
		db.insert(TABLE_DOC_DETAILS, null, values);
		db.close();
		Message.message(context, "Registration Complete");
	}
	
	public void addPatient(PatTable pat) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
	
		ContentValues values = new ContentValues();
		values.put(KEY_PATNAME, pat.getPatName());
		values.put(KEY_PATEMAIL, pat.getPatEmail()); 
		values.put(KEY_PATMOBILE, pat.getPatMobile()); 
		values.put(KEY_PATUSERNAME, pat.getPatUsername()); 
		values.put(KEY_PATPASSWORD, pat.getPatPassword()); 
		
		db.insert(TABLE_PAT_DETAILS, null, values);
		db.close();
		Message.message(context, "Registration Complete");
	}
	
	public void addAppointment(AppointmentsTable apt) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
	 
		ContentValues values = new ContentValues();
		values.put(KEY_ADOCNAME, apt.getDocName()); 
		values.put(KEY_APATNAME, apt.getPatName()); 
		values.put(KEY_APATDISPLAYNAME, apt.getDisplayTime()); 
	 
		db.insert(TABLE_APPOINTMENT_DETAILS, null, values);

		db.close(); 
	}
	
	public List<DocTable> getAllDoctors() 
	{
		List<DocTable> docs = new ArrayList<DocTable>();
		String selectQuery = "SELECT  * FROM " + TABLE_DOC_DETAILS;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) 
		{
			do {
				DocTable dt = new DocTable();
				dt.setId(Integer.parseInt(c.getString(0)));
                dt.setDocName(c.getString(1));
                dt.setDocEmail(c.getString(2));
                dt.setDocMobile(c.getString(3));
                dt.setDocUsername(c.getString(4));
                dt.setDocPassword(c.getString(5));
                docs.add(dt);
			} while (c.moveToNext());
		}

		return docs;
	}

	public List<PatTable> getAllPatients() 
	{
		List <PatTable> pats = new ArrayList<PatTable>();
		String selectQuery = "SELECT  * FROM " + TABLE_PAT_DETAILS;

		//Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) 
		{
			do {
				PatTable pt = new PatTable();
				pt.setPId(Integer.parseInt(c.getString(0)));
                pt.setPatName(c.getString(1));
                pt.setPatEmail(c.getString(2));
                pt.setPatMobile(c.getString(3));
                pt.setPatUsername(c.getString(4));
                pt.setPatPassword(c.getString(5));
                pats.add(pt);
			} while (c.moveToNext());
		}

		return pats;
	}
	
	public List<AppointmentsTable> getAllAppointments() 
	{
		List <AppointmentsTable> apts = new ArrayList<AppointmentsTable>();
		String selectQuery = "SELECT  * FROM " + TABLE_APPOINTMENT_DETAILS;

		//Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) 
		{
			do {
				AppointmentsTable pt = new AppointmentsTable();
				pt.setId(Integer.parseInt(c.getString(0)));
                pt.setDocName(c.getString(1));
                pt.setPatName(c.getString(2));
                pt.setDisplayName(c.getString(3));
                apts.add(pt);
			} while (c.moveToNext());
		}

		return apts;
	}
	
	public boolean searchDoc(String u,String p)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<DocTable> docs=getAllDoctors();
        
        String docusername=u;
        String docpassword=p;
        
        for (DocTable cn : docs) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	String g=cn.getDocUsername();
        	if( docusername.equals(g) )
        	{
        		if(docpassword.equals(cn.getDocPassword()))
        		{
            		Message.message(context,"Login Succesful");
            		db.close();
            		return true;        			
        		}
        	}
        }
        db.close();
        return false;

	}
	
	public boolean searchPat(String u,String p)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<PatTable> pats=getAllPatients();
        
        String patusername=u;
        String patpassword=p;
        
        for (PatTable cn : pats) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	if( patusername.equals(cn.getPatUsername()) )
        	{
        		if(patpassword.equals(cn.getPatPassword()))
        		{
            		Message.message(context,"Login Succesful");
            		db.close();
            		return true;        			
        		}
        	}
        }
        db.close();
        return false;
	}
	
	public String getMyAppointments(String u)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<AppointmentsTable> apts=getAllAppointments();
        
        String docname=u;
        
        for (AppointmentsTable cn : apts) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	if( docname.equals(cn.getDocName()) )
        	{
                db.close();
        		return cn.getDisplayTime();
        	}
        }
        db.close();
        return null;
	}

	public String myAppointment(String u)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<AppointmentsTable> apts=getAllAppointments();
        
        String patname=u;
        
        for (AppointmentsTable cn : apts) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	if( patname.equals(cn.getPatName()) )
        	{
                db.close();
        		return cn.getDocName();
        	}
        }
        db.close();
        return null;
	}
	
	public boolean docUsernameAvailability(String u)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<DocTable> docs=getAllDoctors();
        
        String docusername=u;
        
        for (DocTable cn : docs) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	if( docusername.equals(cn.getDocUsername()) )
        	{
        		db.close();
            	return false;        			
        	}
        }
        db.close();
        return true;
	}
	public boolean patUsernameAvailability(String u)
	{
        SQLiteDatabase db = this.getReadableDatabase();
        
        List<PatTable> pats=getAllPatients();
        
        String patusername=u;
        
        for (PatTable cn : pats) 
        {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() +" ,Email:"+cn.getEmail()+" ,Phone: " + cn.getPhone();
        	if( patusername.equals(cn.getPatUsername()) )
        	{
        		db.close();
            	return false;        			
        	}
        }
        db.close();
        return true;
	}
	
}
