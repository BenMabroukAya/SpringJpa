package org.soa.springjpaclientrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringJpaClientRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaClientRestApplication.class, args);
    }
    /*public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Requête GET pour récupérer tous les produits
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/produits/", HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }*/

}
