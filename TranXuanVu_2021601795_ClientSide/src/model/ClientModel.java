package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.ClientController;
import view.ClientView;

public class ClientModel implements Runnable{
    private String ip = "localhost";
    private int port = 5555;
    private Socket sk = null;
    private ObjectOutputStream output = null;
    private ObjectInputStream input = null;
    ClientView view;
    ClientController controller;
    public ClientModel()
    {
    	controller = new ClientController(this);
    	this.view = this.controller.getView();
			try {
				sk = new Socket(ip, port);
				if(sk!=null)
				{
					OutputStream ou = sk.getOutputStream();
					output = new ObjectOutputStream(ou);
					InputStream in = sk.getInputStream();
					input = new ObjectInputStream(in);
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public void sendServer(Student st)
    {
    	if(st!= null)
    	{
    		try {
    			this.view.showMessage("Sending....");
				output.writeObject(st);
				output.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else
    	{
    		this.view.showMessage("Errol give student!");
    	}
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
	            while (true) {
	                String message = (String) input.readObject();
	                this.view.showMessage(message);
	            }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
	            // Đóng các luồng và socket khi kết thúc
	            try {
	                if (output != null) output.close();
	                if (input != null) input.close();
	                if (sk != null) sk.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			}
	}
	
}
