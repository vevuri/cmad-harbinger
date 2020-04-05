package com.harbinger.cmad;

//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	private int loginId;
	//private String loginId;
	private String passwordSha;
	/*
	private List<String> devices;
	
	public List<String> getDevices() {
		return devices;
	}

	public void setDevices(List<String> devices) {
		this.devices = devices;
	}
*/	
	public String getPasswordSha() {
		return passwordSha;
	}
	public void setPasswordSha(String passwordSha) {
		this.passwordSha = passwordSha;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	@Override
	public String toString() {
//		return "Event [uid=" + loginId + ", devices=" + devices + "]";
		return "Event [uid=" + loginId + "]";

	}
}
