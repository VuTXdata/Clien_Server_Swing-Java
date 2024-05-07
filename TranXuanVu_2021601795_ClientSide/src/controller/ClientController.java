package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ClientModel;
import model.ListClient;
import view.ClientView;

public class ClientController implements ActionListener{
	ClientView view = new ClientView(this);
	ListClient client;
	ClientModel c;
	public ClientController(ClientModel c)
	{
		this.view = new ClientView(this);
		this.view.setVisible(true);
		this.client = new ListClient();
		this.c = c;
	}
	public ClientView getView()
	{
		return this.view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		if(cm.equalsIgnoreCase("CANCLE"))
		{
			this.view.clearText();
		}
		if(cm.equalsIgnoreCase("SEND"))
		{
			c.sendServer(this.view.getInforClient());
			this.client.addStudent(this.view.getInforClient());
			this.view.refreshData(client.getStudents());
			this.view.clearText();
		}
		
	}
	
}
