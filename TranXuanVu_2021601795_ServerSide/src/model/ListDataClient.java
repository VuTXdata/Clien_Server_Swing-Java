package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListDataClient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DataClient> clients;
	public ListDataClient()
	{
		clients = new ArrayList<DataClient>();
	}
	public ListDataClient(ArrayList<DataClient> clients) {
		super();
		this.clients = clients;
	}
	public ArrayList<DataClient> getClients() {
		return clients;
	}
	public void setClients(ArrayList<DataClient> clients) {
		this.clients = clients;
	}
	// Sap xep theo ten
	public void sortByName()
	{
		Collections.sort(clients, new Comparator<DataClient>() {

			@Override
			public int compare(DataClient o1, DataClient o2) {
				// TODO Auto-generated method stub
				return o1.getInforStu().getFullName().compareTo(o2.getInforStu().getFullName());
			}
			
		});
	}
	public void sortByGPA()
	{
		Collections.sort(clients, new Comparator<DataClient>() {

			@Override
			public int compare(DataClient o1, DataClient o2) {
				// TODO Auto-generated method stub
				double gpa1 = (o1.getInforStu().getMark1()+o1.getInforStu().getMark2()+o1.getInforStu().getMark3())/3;
				double gpa2 = (o2.getInforStu().getMark1()+o2.getInforStu().getMark2()+o2.getInforStu().getMark3())/3;
				if(gpa1 > gpa2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
		});
	}
	public boolean existStudent(String id)
	{
		for (DataClient dataClient : clients) {
			if(dataClient.getInforStu().getStudentID().compareToIgnoreCase(id) == 0)
			{
				return true;
			}
		}
		return false;
	}
	public DataClient findStudent(String id)
	{
		for (DataClient dataClient : clients) {
			if(dataClient.getInforStu().getStudentID().compareToIgnoreCase(id) == 0)
			{
				return dataClient;
			}
		}
		return null;
	}
	public boolean addStudent(DataClient dc)
	{
		if(dc != null)
		{
			if(existStudent(dc.getInforStu().getStudentID()))
			{
				return false;
			}
			this.clients.add(dc);
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean deleteStudent(String id)
	{
		DataClient c =  findStudent(id);
		if(c != null)
		{
			this.clients.remove(c);
			return true;
		}
		else
		{
			return false;
		}
	}
}
