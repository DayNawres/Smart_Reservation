package com.SmartReservation.VenueService;

import com.SmartReservation.VenueService.Enum.CategoryEnum;
import com.SmartReservation.VenueService.Model.Venue;
import com.SmartReservation.VenueService.Repository.VenueRepository;
import com.datastax.astra.sdk.AstraClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Controller
@SpringBootApplication(exclude = {

        DataSourceAutoConfiguration.class}
        )
@EnableEurekaClient
//@EnableCassandraRepositories
public class VenueServiceApplication {
        @Autowired
    private AstraClient astraClient;
    @GetMapping("/")
    public String hello() {
        return astraClient.apiDevopsOrganizations().organizationId();
    }
    public static void main(String[] args) {

        SpringApplication.run(VenueServiceApplication.class, args);



    }

}
