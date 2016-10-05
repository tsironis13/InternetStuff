package com.example.giannis.testapplication.POJO;

import java.util.List;

/**
 * Created by giannis on 5/10/2016.
 */

public class Lottery {

    private String draw_date, mega_ball, multiplier, winning_numbers;

    public Lottery() {}

    public String getDraw_date() {
        return draw_date;
    }

    public void setDraw_date(String draw_date) {
        this.draw_date = draw_date;
    }

    public String getWinning_numbers() {
        return winning_numbers;
    }

    public void setWinning_numbers(String winning_numbers) {
        this.winning_numbers = winning_numbers;
    }

    public String getMega_ball() {
        return mega_ball;
    }

    public void setMega_ball(String mega_ball) {
        this.mega_ball = mega_ball;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }
}
