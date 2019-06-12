package com.mgmtp.internship.experiences.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.model.tables.tables.Quote;
import com.mgmtp.internship.experiences.repositories.QuoteRepository;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.jooq.tools.json.JSONArray;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteServicelmpl implements QuoteService {
    @Autowired
    QuoteRepository quoteRepository;

    String URL_QUOTE = "https://quota.glitch.me/random";
    String URL_IMAGE = "https://picsum.photos/v2/list";
    @Override
    public List<QuoteDTO> findAll() { return quoteRepository.findAll(); }

    @Override
    public QuoteDTO findRandomQuote() {
        RestTemplate restTemplate = new RestTemplate();
        QuoteDTO quoteDTO = new QuoteDTO();
        JSONObject jsonObject = restTemplate.getForObject(URL_QUOTE, JSONObject.class);

        //get Quote from URL
        String title = jsonObject.getOrDefault("quoteText","").toString();
        String author = jsonObject.getOrDefault("quoteAuthor","").toString();

        //get Image List
        List<JSONObject> listImage = new ArrayList<>();
        try {
            ResponseEntity<List<JSONObject>> responseEntity = restTemplate.exchange(
                    URL_IMAGE,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<JSONObject>>() {});
            if(responseEntity != null && responseEntity.hasBody()){
                listImage = responseEntity.getBody();
            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //get random Image
        int index = (int) (Math.random()*listImage.size());
        JSONObject imageObject = (JSONObject) listImage.get(index);
        String image = imageObject.getOrDefault("download_url","").toString();

        //apply to quoteDTO
        quoteDTO.setImage(image);
        quoteDTO.setAuthor(author);
        quoteDTO.setTitle(title);

        return quoteDTO;
    }


    @Override
    public int update(QuoteDTO quote) { return quoteRepository.update(quote); }

    @Override
    public int delete(long id) {
        return quoteRepository.delete(id);
    }
}
