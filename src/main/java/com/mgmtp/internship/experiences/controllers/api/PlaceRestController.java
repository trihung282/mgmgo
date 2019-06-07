package com.mgmtp.internship.experiences.controllers.api;

import com.mgmtp.internship.experiences.dto.ApiResponse;
import com.mgmtp.internship.experiences.dto.PlaceDTO;
import com.mgmtp.internship.experiences.exceptions.ApiException;
import com.mgmtp.internship.experiences.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController extends BaseRestController {

    @Autowired
    private PlaceService placeService;

    @GetMapping()
    public List<PlaceDTO> all() {
        return placeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public PlaceDTO get(@PathVariable long id) {
        if (id <= 0) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid id value.");
        }

        return placeService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponse delete(@PathVariable long id) {
        if (id <= 0) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid id value.");
        }

        int affectedRows = placeService.delete(id);
        if (affectedRows == 1) {
            return ApiResponse.success("Delete succesfully!");
        }

        return ApiResponse.failed("Delete failed");
    }
}
