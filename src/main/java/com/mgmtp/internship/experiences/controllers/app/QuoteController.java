package com.mgmtp.internship.experiences.controllers.app;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.services.QuoteService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Service;
import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping()
    public String home(Model model){
        model.addAttribute("quote", quoteService.findRandomQuote());
        return "home";
    }
}
