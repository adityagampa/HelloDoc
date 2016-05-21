package com.example.hellodoc;

public class AppointmentsTable
{
	String  docname, patname, displaytime;
	int id;
	public AppointmentsTable()
	{
	}
	public AppointmentsTable(int id, String dname,String pname,String displaytime)
	{
		this.id=id;
		docname=dname;
		patname=pname;
		this.displaytime=displaytime;
	}
	public AppointmentsTable(String dname,String pname,String displaytime)
	{
		docname=dname;
		patname=pname;
		this.displaytime=displaytime;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setDocName(String dname)
	{
		docname=dname;
	}
	public void setPatName(String pname)
	{
		patname=pname;
	}
	public void setDisplayName(String displaytime)
	{
		this.displaytime=displaytime;
	}

	public int getId()
	{
		return id;
	}
	public String getDocName()
	{
		return docname;
	}
	public String getPatName()
	{
		return patname;
	}
	public String getDisplayTime()
	{
		return displaytime;
	}
		
}
