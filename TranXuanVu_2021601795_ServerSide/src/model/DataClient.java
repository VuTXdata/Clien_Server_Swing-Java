package model;

import java.io.Serializable;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Objects;

public class DataClient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student inforStu;
	private InetAddress ip;
	private LocalDateTime time;
	public DataClient(Student inforStu, InetAddress ip, LocalDateTime time) {
		super();
		this.inforStu = inforStu;
		this.ip = ip;
		this.time = time;
	}
	public Student getInforStu() {
		return inforStu;
	}
	public void setInforStu(Student inforStu) {
		this.inforStu = inforStu;
	}
	public InetAddress getIp() {
		return ip;
	}
	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		return Objects.hash(inforStu, ip, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataClient other = (DataClient) obj;
		return Objects.equals(inforStu, other.inforStu) && Objects.equals(ip, other.ip)
				&& Objects.equals(time, other.time);
	}
	@Override
	public String toString() {
		return "DataClient [inforStu=" + inforStu + ", ip=" + ip + ", time=" + time + "]";
	}
	
	
}
