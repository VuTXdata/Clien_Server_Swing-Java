package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.ListDataClient;

public class ClientDao {
	ListDataClient listClients;
	FileInputStream in = null;
	FileOutputStream ou = null;
	ObjectInputStream input = null;
	ObjectOutputStream output = null;
	public ClientDao(ListDataClient listClients) {
		super();
		this.listClients = listClients;
	}

	public ClientDao() {
		this.listClients = new ListDataClient();
	}
	
	public ListDataClient getListClients() {
		return listClients;
	}

	public void setListClients(ListDataClient listClients) {
		this.listClients = listClients;
	}

	public void openFile(String path)
	{
		try {
			in = new FileInputStream(path);
			input = new ObjectInputStream(in);
			try {
				this.listClients = (ListDataClient) input.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(input != null) input.close();
				if(in!=null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void saveFile(String path)
	{
		try {
			ou = new FileOutputStream(path);
			output = new ObjectOutputStream(ou);
			output.writeObject(this.listClients);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(output!= null)output.close();
				if(ou!=null) ou.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
