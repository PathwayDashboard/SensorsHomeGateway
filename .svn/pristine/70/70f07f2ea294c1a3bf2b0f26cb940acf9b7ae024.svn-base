package it.eng.sensors.home.gateway;

public class SensorsHomeGatewayFactory {
	/**
	 * Implemented version of CloudClient are available inside the Provider enumeration.
	 * If it is not supported the developer has to pass as parameter the actual implementation of the CloudClient interface
	 * 
	 * @param provider - nullable
	 * @param actualCloudClient - nullable
	 * @param clientId
	 * @param clientSecret
	 * @param scope
	 * @param redirectUri
	 * @return
	 */
	public static SensorsHomeGatewayImpl getGateway(Provider provider, CloudClient actualCloudClient, String clientId, String clientSecret, String scope, String redirectUri){
		if (provider!=null){
			return new SensorsHomeGatewayImpl(provider, clientId, clientSecret, scope, redirectUri);
		}
		if (actualCloudClient!=null){
			return new SensorsHomeGatewayImpl(actualCloudClient, clientId, clientSecret, scope, redirectUri);
		}
		return null;
	}
	
}
