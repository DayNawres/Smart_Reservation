package com.SmartReservation.VenueService.web;

import com.SmartReservation.VenueService.Model.Hotel;
import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Base64;

@Controller

public class UserGraphql {

    @MutationMapping
    public String addUser(@Argument(name="file") MultipartFile file)
  {
      User user=new User();
        String filename= StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains(".."))
        {System.out.println(("not a valid file"));}
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user.getImage();
    }
}
