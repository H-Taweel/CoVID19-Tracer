package com.redi.j2.CoVID19Tracer.services;


import com.redi.j2.CoVID19Tracer.models.MapStats;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19DataService {

    private static String Data_Url = "https://corona.lmao.ninja/v2/countries?";
    private List<MapStats> mapStats = new ArrayList<>();

    public List<MapStats> getMapStats() {
        return mapStats;}
    @PostConstruct
    //updating data by scheduling it every day at 06:00 am
    @Scheduled(cron = "* * 6 * * *")
    public void fetchCovid19Data() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Data_Url)).build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser jsonParser = new JSONParser();
        List<MapStats> newStats = new ArrayList<>();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(httpResponse.body());

            long lat_ = 0;
            long long_ = 0;
            long activePerOneMillion = 0;
            long recoveredPerOneMillion = 0;
            long criticalPerOneMillion = 0;

            //looping Json array
            for (Object object : jsonArray) {
                JSONObject record = (JSONObject) object;
                long update = (long) record.get("updated");
                JSONObject countryInfo = (JSONObject) record.get("countryInfo");

                if (countryInfo.get("_id") == null) {
                    System.out.println("ID is missing");
                } else {
                    long country_id = (long) countryInfo.get("_id");
                    String country = (String) record.get("country");
                    String iso2 = (String) record.get("iso2");
                    String iso3 = (String) record.get("iso3");

                    if (countryInfo.get("lat") instanceof Double) {
                        lat_ = ((Double) countryInfo.get("lat")).longValue();
                    } else {
                        lat_ = (long) countryInfo.get("lat");
                    }
                    if (countryInfo.get("long") instanceof Double) {
                        long_ = ((Double) countryInfo.get("long")).longValue();
                    } else {
                        long_ = (long) countryInfo.get("long");
                    }

                    String flag = (String) countryInfo.get("flag");
                    long cases = (long) record.get("cases");
                    long todayCases = (long) record.get("todayCases");
                    long deaths = (long) record.get("deaths");
                    long todayDeaths = (long) record.get("todayDeaths");
                    long recovered = (long) record.get("recovered");
                    long todayRecovered = (long) record.get("todayRecovered");
                    long active = (long) record.get("active");
                    long critical = (long) record.get("critical");
                    long casesPerOneMillion = (long) record.get("casesPerOneMillion");
                    long deathsPerOneMillion = (long) record.get("deathsPerOneMillion");
                    long tests = (long) record.get("tests");
                    long testsPerOneMillion = (long) record.get("testsPerOneMillion");
                    long population = (long) record.get("population");
                    String continent = (String) record.get("continent");
                    long oneCasePerPeople = (long) record.get("oneCasePerPeople");
                    long oneDeathPerPeople = (long) record.get("oneDeathPerPeople");
                    long oneTestPerPeople = (long) record.get("oneTestPerPeople");

                    if (record.get("activePerOneMillion") instanceof Double) {
                        activePerOneMillion = ((Double) record.get("activePerOneMillion")).longValue();
                    } else {
                        activePerOneMillion = (long) record.get("activePerOneMillion");
                    }

                    if (record.get("recoveredPerOneMillion") instanceof Double) {
                        recoveredPerOneMillion = ((Double) record.get("recoveredPerOneMillion")).longValue();
                    } else {
                        recoveredPerOneMillion = (long) record.get("recoveredPerOneMillion");
                    }


                    if (record.get("criticalPerOneMillion") instanceof Double) {
                        criticalPerOneMillion = ((Double) record.get("criticalPerOneMillion")).longValue();
                    } else {
                        criticalPerOneMillion = (long) record.get("criticalPerOneMillion");
                    }
                    MapStats mapStat = new MapStats();
                    mapStat.setCountry(country);
                    mapStat.setCases(cases);
                    mapStat.setTodayCases(todayCases);
                    mapStat.setDeaths(deaths);
                    mapStat.setTodayDeaths(todayDeaths);
                    mapStat.setUpdate(update);
                    newStats.add(mapStat);
                }
//                System.out.println("Records inserted.....");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mapStats = newStats;
    }
}