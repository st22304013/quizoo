package frame;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import frame.context.RequestContext;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public abstract class ServiceFactory {
	
	private static final String filePath = "WEB-INF/lib/command-mapping.properties";
	
	public static Service getService(RequestContext req) throws ResourceException, NotFoundException{
		Service service = null;
		String serviceClassName = null;
		
		Properties prop = new Properties();
		try (FileInputStream input = new FileInputStream(filePath)){
			prop.load(input);
			
			String reqKey = req.getTargetServiceKey();
			
			serviceClassName = (String) prop.get(reqKey);
			
			if(serviceClassName == null || serviceClassName.isEmpty()) {
				throw new NotFoundException(reqKey + "に対応するクラスが見つかりません\n");
			}
			
			try {
				service = (Service)Class.forName(serviceClassName).getDeclaredConstructor().newInstance();
			} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				throw new NotFoundException(serviceClassName + "のインスタンス化に失敗しました\n"
							+ e.getMessage(), e);
			}
			
		} catch (IOException e) {
			throw new ResourceException("command-mapping.propertiesのロードに失敗しました\n" 
						+ e.getLocalizedMessage(), e);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new NotFoundException(serviceClassName + "のインスタンス化に失敗しました\n" 
						+ e.getMessage(),e);
		}
		return service;
	}
} 
