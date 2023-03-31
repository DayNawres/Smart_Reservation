package com.SmartReservation.VenueService;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class ConnectDatabase {

    public static void main(String[] args) {
        // Create the CqlSession object:
        try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("C:\\Users\\wael\\Downloads\\secure-connect-venue.zip"))
                .withAuthCredentials("AczudQilAFlTzeOPDdglCxwZ","WPeF_iIBK9ueFGkfc+4OcAa9qUbMacjfviBq.k+snrzlmZoGtUdZShra3Pw6auRJ6SbkdTEIEDi0SCkmSghalJrism2ETCSCAnKulKb78izB-X,8+QaX107YoZx+Rb8i")
                .build()) {
            // Select the release_version from the system.local table:
            ResultSet rs = session.execute("select category from cass.venue");
            Row row = rs.one();
            //Print the results of the CQL query to the console:
            if (row != null) {
                System.out.println(row.getString("category"));
            } else {
                System.out.println("An error occurred.");
            }
        }
        System.exit(0);
    }
}