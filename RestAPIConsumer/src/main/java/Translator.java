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
        headers.add("Authorization", "Bearer " + "t1.9euelZqZnI-KkZSVnZDIlpGXmJuZze3rnpWazM-Sl5HNkYmVlcyPzpSayZfl8_cOCFNV-e8tEVtE_N3z9042UFX57y0RW0T8zef1656VmpiciZrMlJGSl4yPlsqWzoyU7_zF656VmpiciZrMlJGSl4yPlsqWzoyU.AxNZLfiW6LaRF2DqUMi6UMErpzC2YpqIJstyptG5EKIYKgQuZLCru7HgY1bt_IxzekOnzX70H0JYq4Nk5I0kCQ");

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
