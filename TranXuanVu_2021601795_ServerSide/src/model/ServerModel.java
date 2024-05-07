package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

import dao.ClientDao;
import view.ServerView;

public class ServerModel implements Runnable{
	ServerView view;
	ClientDao cd;
	public ServerModel(ServerView vi, ClientDao cd)
	{
		this.view = vi;
		this.cd = cd;
	}
	public void giveDataClient(DataClient c)
	{
		cd.getListClients().addStudent(c);
		this.view.showMessage("Give data successed!");
		this.view.refreshData(cd.getListClients().getClients());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket sr = null;
		try {
			sr = new ServerSocket(5555);
			while(true)
			{
				Socket sk = sr.accept();
				LocalDateTime time = LocalDateTime.now();
				this.view.showMessage("Just connected to new client");
				HandlerClient cl =  new HandlerClient(this, sk, time);
				new Thread(cl).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
