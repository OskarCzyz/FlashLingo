package com.example.sqlitecrud.model;

public class FlashCard {
    private final String eng;
    private final String pl;
    private final Integer counter;
    private final long guess_time;
    public String getEng() {
        return eng;
    }

    public String getPl() {
        return pl;
    }

    public Integer getCounter() {
        return counter;
    }

    public long getGuess_time() {
        return guess_time;
    }

    public FlashCard(String eng, String pl, Integer counter, long guess_time) {
        this.eng = eng;
        this.pl = pl;
        this.counter = counter;
        this.guess_time = guess_time;
    }
}
