package com.redi.j2.CoVID19Tracer.models;

public class MapStats {

    private long id, update, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered,
            active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
            population, continent, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion,
            recoveredPerOneMillion, criticalPerOneMillion;
    private String country, iso2, iso3, lat, lang, flag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(long todayCases) {
        this.todayCases = todayCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
        this.tests = tests;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getContinent() {
        return continent;
    }

    public void setContinent(long continent) {
        this.continent = continent;
    }

    public long getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(long oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public long getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(long oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public long getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(long oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public long getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(long activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public long getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(long recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public long getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(long criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MapStats{" +
                "id=" + id +
                ", update=" + update +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", todayRecovered=" + todayRecovered +
                ", active=" + active +
                ", critical=" + critical +
                ", casesPerOneMillion=" + casesPerOneMillion +
                ", deathsPerOneMillion=" + deathsPerOneMillion +
                ", tests=" + tests +
                ", testsPerOneMillion=" + testsPerOneMillion +
                ", population=" + population +
                ", continent=" + continent +
                ", oneCasePerPeople=" + oneCasePerPeople +
                ", oneDeathPerPeople=" + oneDeathPerPeople +
                ", oneTestPerPeople=" + oneTestPerPeople +
                ", activePerOneMillion=" + activePerOneMillion +
                ", recoveredPerOneMillion=" + recoveredPerOneMillion +
                ", criticalPerOneMillion=" + criticalPerOneMillion +
                ", country='" + country + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", iso3='" + iso3 + '\'' +
                ", lat='" + lat + '\'' +
                ", lang='" + lang + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
