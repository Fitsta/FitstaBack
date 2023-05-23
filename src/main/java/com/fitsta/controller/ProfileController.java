package com.fitsta.controller;

import com.fitsta.model.dto.Profile;
import com.fitsta.model.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> profile(@PathVariable int userId) {
        Profile profile = profileService.getProfile(userId);
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }
}
