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
public interface SensorsHomeGateway {
	
	public String testApi(String token) throws UnauthorizedException;
	
	public List<ActiveLifestylePASession> getSessions(String token, Date date) throws UnauthorizedException; 

	public ActiveLifestylePASession getSummary(String token, Date startDate, Date endDate) throws UnauthorizedException;
	
	public String getAuthCode(String patientId) throws MalformedURLException, IOException;
	
	public Map<String,String> getAccessToken(String code) throws MalformedURLException, IOException;
	
	public Map<String,String> refreshToken(String refreshToken) throws MalformedURLException, IOException;
	
	public String getAccesTokenKey();
	
	public String getRefreshTokenKey();
	
	public List<DailyActivity> getDailyActivities(String token, Date startDate, Date endDate) throws UnauthorizedException;
}
