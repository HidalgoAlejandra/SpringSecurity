package cl.titanium.security.accuweather.access;

import java.util.Map;
import java.util.HashMap;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.titanium.security.accuweather.model.Pronostico;

/* 
 * Administra las llamadas a la API de AccuWeather: https://developer.accuweather.com 
 * Guarda la información obtenida en un HashMap para minimizar las solicitudes realizadas a la API
 */
@Component
public class AccesoAccuWeather {

	// Clave de la API, usada en todas las solicitudes
	private static final String APIKEY = "EtoSdYCUid3ZnQxgYd1rIDw17dpP2ot0";
	// Guarda los datos obtenidos desde la API en un ambiente temporal
	private static Map<Integer, Pronostico> pronosticos = null;
	
	// Crea un objeto AccesoAccuWeather, siguiendo el patrón de diseño Singleton
	private AccesoAccuWeather() {
		
		pronosticos = new HashMap<Integer, Pronostico>();
		
	}
	
	/*
	 * Realiza una solicitud a la API, obteniendo el pronóstico del tiempo del día siguiente 
	 * para una ciudad en especifico, según el código de ciudad definido por la API
	 */
	private static Pronostico getAccuWeatherForecast(int cod_ciudad) {
		
		Pronostico p = null;
		
		final String uri = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + cod_ciudad + "?apikey="
				+ APIKEY + "&metric=true";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Pronostico> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<Pronostico>() {
				});
		p = postResponse.getBody();
		
		return p;
		
	}
	
	/* 
	 * Devuelve el pronóstico del tiempo del día siguiente para una ciudad en específico.
	 * Si no se ha hecho la solicitud antes, se obtienen los datos desde la API
	 */
	public static Pronostico getPronostico(int cod_ciudad) {
		
		if (pronosticos == null) {
			
			new AccesoAccuWeather();
			
		}
		
		if (pronosticos.get(cod_ciudad) == null) {
			
			pronosticos.put(cod_ciudad, getAccuWeatherForecast(cod_ciudad));
			
		}
		
		return pronosticos.get(cod_ciudad);

	}

}
