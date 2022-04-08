package com.bvr.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("server")
public class ServerProperties {

	public ServerProperties() {
		// TODO Auto-generated constructor stub
	}
	
	public static class Cluster {
		private String ip;
		private String path;
		
		public String getIp() {
			return ip;
		}
		
		public void setIp(String ip) {
			this.ip = ip;
		}
		
		public String getPath() {
			return path;
		}
		
		public void setPath(String path) {
			this.path = path;
		}

		@Override
		public String toString() {
			return "Cluster [ip=" + ip + ", path=" + path + "]";
		}
			
	}
	
	
	private String email;
	private List<Cluster> cluster = new ArrayList<>();
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Cluster> getCluster() {
		return cluster;
	}
	
	
	public void setCluster(List<Cluster> cluster) {
		this.cluster = cluster;
	}


	@Override
	public String toString() {
		return "ServerProperties [email=" + email + ", cluster=" + cluster + "]";
	}
	
	
	
	

}
