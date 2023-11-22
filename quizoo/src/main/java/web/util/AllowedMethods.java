package web.util;

import java.io.Serializable;
import java.util.ArrayList;

public class AllowedMethods implements Serializable{
	public ArrayList<String> get = new ArrayList<String>();
	public ArrayList<String> post = new ArrayList<String>();
	public ArrayList<String> getGet() {
		return get;
	}
	public void setGet(ArrayList<String> get) {
		this.get = get;
	}
	public ArrayList<String> getPost() {
		return post;
	}
	public void setPost(ArrayList<String> post) {
		this.post = post;
	}
	
}