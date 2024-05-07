package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ClientDao;
import model.ServerModel;
import view.ServerView;

public class ServerController implements ActionListener {
	ServerView view;
	ClientDao clientDao;
	ServerModel server;
	public ServerController() {
		super();
		this.view = new ServerView(this);
		this.view.setVisible(true);
		this.clientDao = new ClientDao();
		this.server = new ServerModel(view, clientDao);
		new Thread(server).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		if(cm.equalsIgnoreCase("ADD"))
		{
			this.view.addData(clientDao.getListClients());
		}
		if(cm.equalsIgnoreCase("EDIT"))
		{
			this.view.updateData(clientDao.getListClients());
		}
		if(cm.equalsIgnoreCase("DELETE"))
		{
			this.view.deleteData(clientDao.getListClients());
		}
		if(cm.equalsIgnoreCase("CLEAR"))
		{
			this.view.clearText();
		}
		if(cm.equalsIgnoreCase("Sort by name"))
		{
			this.view.sortByName(clientDao.getListClients());
		}
		if(cm.equalsIgnoreCase("Sort by gpa"))
		{
			this.view.sortByGPA(clientDao.getListClients());
		}
		if(cm.equalsIgnoreCase("Save"))
		{
			this.view.makeSaveFile(clientDao);
		}
		if(cm.equalsIgnoreCase("Open"))
		{
			this.view.makeOpenFile(clientDao);
		}
	}

}
