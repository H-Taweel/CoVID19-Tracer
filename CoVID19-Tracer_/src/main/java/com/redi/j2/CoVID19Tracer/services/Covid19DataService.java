package com.redi.j2.CoVID19Tracer.services;

import com.redi.j2.CoVID19Tracer.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19DataService {
    //
    private static String dataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    // instantiate location stats
    private List<LocationStats> allStats = new ArrayList<>();

    @PostConstruct
    //updating data by scheduling it every day at 06:00 am
    @Scheduled(cron = "* * 6 * * *")
    public void fetchCovid19Data () throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(dataURL))
                .build();
        HttpResponse<String> httpResponse= client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        //Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(csvReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            locationStat.setLatestTotalCases(record.get(record.size() -1));
            System.out.println(locationStat);
            newStats.add(locationStat);
        }
        this.allStats = newStats;
    }
}
