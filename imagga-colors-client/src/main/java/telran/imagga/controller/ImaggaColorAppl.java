package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.BackgroundColor;
import telran.imagga.dto.ResponseDTO;


public class ImaggaColorAppl {
	final static String TOKEN = "Basic ==";
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		String httpUrl = "https://api.imagga.com/v2/colors";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(httpUrl)
								.queryParam("image_url", "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg");
								
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", TOKEN);
		
		RequestEntity<String> requestEntity = 
				new RequestEntity<>(headers , HttpMethod.GET, builder.build().toUri());
		ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(requestEntity, ResponseDTO.class);
		
		responseEntity.getBody().getResult().getColors().getBackgroundColors().forEach(System.out::println);
		
		responseEntity.getBody().getResult().getColors().getForegroundColors().forEach(System.out::println);
		System.out.println();
		responseEntity.getBody().getResult().getColors().getImageColors().forEach(System.out::println);
				
	}

}
