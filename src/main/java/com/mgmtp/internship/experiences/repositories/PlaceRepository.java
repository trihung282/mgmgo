package com.mgmtp.internship.experiences.repositories;

import com.mgmtp.internship.experiences.dto.PlaceDTO;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.mgmtp.internship.experiences.model.tables.tables.Place.PLACE;

@Component
public class PlaceRepository {

    @Autowired
    private DSLContext dslContext;

    public List<PlaceDTO> findAll() {
        return dslContext.selectFrom(PLACE)
                .orderBy(PLACE.ID)
                .fetch().stream()
                .map(placeRecord -> new PlaceDTO(placeRecord.getId(), placeRecord.getTitle()))
                .collect(Collectors.toList());
    }

    public PlaceDTO findById(long id) {
        return dslContext.selectFrom(PLACE)
                .where(PLACE.ID.eq(id))
                .fetchOneInto(PlaceDTO.class);
    }

    public int update(PlaceDTO placeDTO) {
        return dslContext.update(PLACE)
                .set(PLACE.TITLE, placeDTO.getTitle())
                .where(PLACE.ID.eq(placeDTO.getId()))
                .execute();
    }

    public int delete(long placeId) {
        return dslContext.delete(PLACE)
                .where(PLACE.ID.eq(placeId))
                .execute();
    }

}
