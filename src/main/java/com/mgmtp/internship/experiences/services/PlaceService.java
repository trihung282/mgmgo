package com.mgmtp.internship.experiences.services;

import com.mgmtp.internship.experiences.dto.PlaceDTO;

import java.util.List;

public interface PlaceService {
    List<PlaceDTO> findAll();

    PlaceDTO findById(long id);

    int update(PlaceDTO place);

    int delete(long placeId);
}
