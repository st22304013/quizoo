package web.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServiceManager {
	private static HashMap<String, ServiceInfo> services = new HashMap<String, ServiceInfo>();
	private static final String webjson = "C:/repos/QuiZoo/quizoo/src/main/webapp/WEB-INF/web.json";
	static{
		FileReader reader = null;
		try {
			reader = new FileReader(webjson);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		Gson gson = new Gson();	
		
		List<ServiceInfo> serviceList = gson.fromJson(reader,new TypeToken<List<ServiceInfo>>() {});
		
		
		for(ServiceInfo service:serviceList) {
			services.put(service.getName(), service);
		}
		
		
	}
	public static ServiceInfo get(String name) {
		return services.get(name);
	}
}
