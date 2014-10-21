package inc.bme.api;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.common.TypeConverter;
import org.apache.xmlrpc.common.TypeConverterFactory;
import org.apache.xmlrpc.common.TypeConverterFactoryImpl;
import java.net.URL;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BMEApi {
	
	/** Variables **/
	private final XmlRpcClient	client;
	
	
	/** Methods **/
	public static InterfaceBMEApi getBMEServices() {	
		
		InterfaceBMEApi result = null;
		
		try {		
			
			/** Create XML RPC Configuration **/
			final XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();						
			config.setServerURL(new URL("http://api.benchmarkemail.com/1.0/"));
			config.setEnabledForExtensions(true);
			config.setConnectionTimeout(60 * 1000);

			/** Create Object of XML RPC **/
			final XmlRpcClient clientx = new XmlRpcClient();
			clientx.setConfig(config);			
			final BMEApi objCall = new BMEApi(clientx);	

			result = (InterfaceBMEApi) objCall.newInstance(
					InterfaceBMEApi.class.getClassLoader(),
					InterfaceBMEApi.class);
			
		} 
		catch (final Throwable t) {		
			System.out.println("Failed to connect to BME services");
		}
		return result;
	}

	
	
	private BMEApi(final XmlRpcClient pClient) {			
		this.client = pClient;				
	}
	
	
	private Object newInstance(final ClassLoader oClassLoader, final Class<?> oClass) {
		
		return Proxy.newProxyInstance(oClassLoader, new Class[] { oClass },					
				new InvocationHandler() {
			public Object invoke(final Object pProxy,
					final Method pMethod, final Object[] pArgs)
							throws Throwable {							
				final String methodName = pMethod.getName();																				
				Object result;
				try {
					TypeConverterFactory objConvert  = new TypeConverterFactoryImpl();
					result = client.execute(methodName, pArgs);
					final TypeConverter typeConverter = objConvert
							.getTypeConverter(pMethod.getReturnType());
					return typeConverter.convert(result);
				} catch(Exception e) {
					String message = e.getMessage();
					if ((message == null)
							|| (message.length() == 0)) {
						message = "Unknown Error";
					}
					throw new RuntimeException(message);																
				}							
			}
		});
	}	
	
}
