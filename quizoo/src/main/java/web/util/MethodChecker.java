package web.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class MethodChecker {
	private static AllowedMethods methods = null;
	public static boolean check(HttpServletRequest req) throws IOException {
		if(methods == null) {
			try(Reader reader = new InputStreamReader(req.getServletContext().getResourceAsStream("/WEB-INF/web.json"))){
				Gson gson = new Gson();
				
				methods = gson.fromJson(reader, AllowedMethods.class);
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
