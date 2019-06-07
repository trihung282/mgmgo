package com.mgmtp.internship.experiences.services.impl;

import com.mgmtp.internship.experiences.dto.PlaceDTO;
import com.mgmtp.internship.experiences.repositories.PlaceRepository;
import com.mgmtp.internship.experiences.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<PlaceDTO> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public PlaceDTO findById(long id) {
        return placeRepository.findById(id);
    }

    @Override
    public int update(PlaceDTO place) {
        return placeRepository.update(place);
    }

    @Override
    public int delete(long placeId) {
        return placeRepository.delete(placeId);
    }
}
