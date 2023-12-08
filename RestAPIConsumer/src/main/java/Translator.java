import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Введите предложение на русском языке:");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();
        RestTemplate template = new RestTemplate();

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + "");

        Map<String , String > jasonData = new HashMap<>();
        jasonData.put("folderId", "b1g29qut66o9vhv3kda3");
        jasonData.put("targetLanguageCode", "en");
        jasonData.put("texts", "[" + sentenceToTranslate + "]");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jasonData, headers);
        YandexResponse response = template.postForObject(url, request, YandexResponse.class);


        assert response != null;
        System.out.println("Перевод: " + response.getTranslations().get(0).getText());
    }
}
