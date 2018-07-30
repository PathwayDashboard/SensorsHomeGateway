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
