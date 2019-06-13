package com.mgmtp.internship.experiences.controllers.api;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/quotes")
public class QuoteRestController  extends  BaseRestController{

    @Autowired
    private QuoteService quoteService;

    @GetMapping()
    public List<QuoteDTO> findAll(){ return quoteService.findAll();}

    @GetMapping(value = "/random")
    public QuoteDTO getRandomQuote(){
       return quoteService.findRandomQuote();
    }
}
