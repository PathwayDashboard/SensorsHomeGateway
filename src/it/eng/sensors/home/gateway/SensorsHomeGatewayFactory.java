/*******************************************************************************
 * Copyright 2018 Engineering Ing. Inf. S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
