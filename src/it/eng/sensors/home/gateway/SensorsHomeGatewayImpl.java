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
/**
 * 
 */
package it.eng.sensors.home.gateway;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import it.eng.pathway.fake.model.ActiveLifestylePASession;
import it.eng.pathway.fake.model.DailyActivity;
import it.eng.sensors.home.gateway.exception.UnauthorizedException;

/**
 * @author fabiomelillo
 *
 */
public class SensorsHomeGatewayImpl implements SensorsHomeGateway {

	private Provider provider;
	private CloudClient client;
	private String clientId;
	private String clientSecret;
	private String scope;
	private String redirectUri;
	
	public SensorsHomeGatewayImpl(CloudClient actualCloudClient, String clientId, String clientSecret, String scope, String redirectUri) {
		super();
		this.clientId=clientId;
		this.clientSecret=clientSecret;
		this.scope=scope;
		this.redirectUri=redirectUri;
		this.client=actualCloudClient;
	}


	public SensorsHomeGatewayImpl(Provider provider, String clientId, String clientSecret, String scope, String redirectUri) {
		super();
		this.provider = provider;
		this.clientId=clientId;
		this.clientSecret=clientSecret;
		this.scope=scope;
		this.redirectUri=redirectUri;
		switch (this.provider) {
		case MICROSOFT:
			client=new CloudClientMS();
			break;
		default:
			break;
		}
	}
	
	@Override
	public String testApi(String token) throws UnauthorizedException {
		return client.testApi(token);
	}
	
	public List<ActiveLifestylePASession> getSessions(String token, Date date) throws UnauthorizedException {
		return client.getSessions(token, date);
	}

	public ActiveLifestylePASession getSummary(String token, Date startDate, Date endDate) throws UnauthorizedException {
		return client.getSummary(token, startDate, endDate);
	}

	@Override
	public String getAuthCode(String patientId) throws MalformedURLException, IOException  {
//		String redirectForSingleUser=redirectUri+"%2F"+patientId;
//		return client.getAuthCode(clientId, scope, redirectForSingleUser);
		return client.getAuthCode(clientId, scope, redirectUri,patientId);
	}

	@Override
	public Map<String, String> getAccessToken(String code) throws MalformedURLException, IOException {
//		String redirectForSingleUser=redirectUri+"%2F"+patientId;
//		return client.getAccessToken(clientId, redirectForSingleUser, clientSecret,code);
		return client.getAccessToken(clientId, redirectUri, clientSecret,code);
	}

	@Override
	public Map<String, String> refreshToken(String refreshToken) throws IOException {
//		String redirectForSingleUser=redirectUri+"%2F"+patientId;
//		return client.refreshToken(clientId,redirectForSingleUser,clientSecret,refreshToken);
		return client.refreshToken(clientId,redirectUri,clientSecret,refreshToken);
	}

	@Override
	public String getAccesTokenKey() {
		return client.getAccessTokenKey();
	}

	@Override
	public String getRefreshTokenKey() {
		return client.getRefreshTokenKey();
	}


	@Override
	public List<DailyActivity> getDailyActivities(String token, Date startDate, Date endDate) throws UnauthorizedException {
		return client.getDailyActivities(token, startDate, endDate);
	}

	
	
}
