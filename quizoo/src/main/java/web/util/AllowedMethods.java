package web.util;

import java.io.Serializable;
import java.util.ArrayList;

public class AllowedMethods implements Serializable{
	public ArrayList<String> GET = new ArrayList<String>();
	public ArrayList<String> POST = new ArrayList<String>();
	public ArrayList<String> getGet() {
		return GET;
	}
	public void setGET(ArrayList<String> get) {
		this.GET = get;
	}
	public ArrayList<String> getPost() {
		return POST;
	}
	public void setPOST(ArrayList<String> post) {
		this.POST = post;
	}
	
}