package com.lance.learningnotes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Card implements Serializable {
    private String color;
    private String point;

    @Override
    public String toString() {
        String color2;
        if("hearts".equals(color)){
            color2 = "♥️";
        }else if("diamonds".equals(color)){
            color2 = "♦️";
        }else if("clubs".equals(color)){
            color2 = "♣️";
        }else if("spades".equals(color)){
            color2 = "♠️️️️";
        }else {
            color2 = color;
        }
        return color2+point;
    }
}
