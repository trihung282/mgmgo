package com.mgmtp.internship.experiences.services;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.model.tables.tables.Quote;
import org.jooq.tools.json.JSONObject;

import java.util.List;

public interface QuoteService {

    List<QuoteDTO> findAll();

    QuoteDTO findRandomQuote();

    int update(QuoteDTO quote);

    int delete(long id);
}
