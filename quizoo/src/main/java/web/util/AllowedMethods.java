package web.util;

import java.util.ArrayList;
import java.util.HashMap;

public class AllowedMethods{
	HashMap<String, ArrayList<String>> methodsServiceMap = new HashMap<>();
	ArrayList<String> get = new ArrayList<String>();
	ArrayList<String> post = new ArrayList<String>();
	{
		methodsServiceMap.put("GET", get);
		methodsServiceMap.put("POST", post);
	}
}