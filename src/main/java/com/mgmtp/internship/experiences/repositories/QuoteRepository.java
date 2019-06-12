package com.mgmtp.internship.experiences.repositories;

import com.mgmtp.internship.experiences.dto.QuoteDTO;
import com.mgmtp.internship.experiences.model.tables.tables.Quote;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.mgmtp.internship.experiences.model.tables.tables.Quote.QUOTE;

@Component
public class QuoteRepository {
    @Autowired
    private DSLContext dslContext;

    public List<QuoteDTO> findAll(){
        return dslContext.selectFrom(QUOTE)
                .fetch().stream()
                .map(quoteRecord -> new QuoteDTO(quoteRecord.getId(), quoteRecord.getTitle(), quoteRecord.getAuthor(), quoteRecord.getImage()))
                .collect(Collectors.toList());
    }

    public QuoteDTO findRandomQuote(){
        List<QuoteDTO> list = findAll();
        int index = (int)(Math.random()*list.size());
        return list.get(index);
    }

    public int update(QuoteDTO quote){
        return dslContext.update(QUOTE)
                .set(QUOTE.TITLE, quote.getTitle())
                .where(QUOTE.ID.eq(quote.getId()))
                .execute();
    }

    public int delete(long id){
        return dslContext.delete(QUOTE)
                .where(QUOTE.ID.eq(id))
                .execute();
    }
}
