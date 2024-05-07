package model;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;

public class HandlerClient implements Runnable{
	Student student;
	LocalDateTime time;
	ServerModel server = null;
	Socket sk = null;
	ObjectInputStream input = null;
	ObjectOutputStream output = null;
	
	public HandlerClient(ServerModel s, Socket sk, LocalDateTime time)
	{
		this.time = time;
		this.server = s;
		this.sk = sk;
		try {
			InputStream in = sk.getInputStream();
			input = new ObjectInputStream(in);
			OutputStream ou = sk.getOutputStream();
			output = new ObjectOutputStream(ou);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
			try {
				while(true)
				{
					this.student = (Student) input.readObject();
					InetAddress ip = this.sk.getInetAddress();
					DataClient client = new DataClient(student,ip , time);
					this.server.giveDataClient(client);
					// Gui phan hoi
					String respone = "Server gave data!";
					output.writeObject(respone);
					output.flush();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(input!= null)input.close();
					if(output!=null)output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
}
