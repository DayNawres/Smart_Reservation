package com.SmartReservation.VenueService.web;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class User {
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//    String pass;
}
