package web.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class methodChecker {
	private static AllowedMethods methods = null;
	public static boolean check(HttpServletRequest req) throws IOException {
		if(methods == null) {
			try(Reader reader = new InputStreamReader(req.getServletContext().getResourceAsStream("/WEB-INF/web.json"))){
				Gson gson = new Gson();
				
				AllowedMethods methods = gson.fromJson(reader, AllowedMethods.class);
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}			
		}
		
		String reqMethod = req.getMethod();
		String reqServiceKey = req.getRequestURI().toString().replaceFirst("/quizoo/","");
		
		return methods.methodsServiceMap.get(reqMethod).contains(reqServiceKey);
		
	}
} 
class AllowedMethods{
	HashMap<String, ArrayList<String>> methodsServiceMap = new HashMap<>();
	ArrayList<String> get = new ArrayList<String>();
	ArrayList<String> post = new ArrayList<String>();
	{
		methodsServiceMap.put("GET", get);
		methodsServiceMap.put("POST", post);
	}
}
