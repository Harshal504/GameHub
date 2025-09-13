package com.gamehubcdac.game;

import java.util.Comparator;

public class GameCompareId implements Comparator<Game> {
    @Override
    public int compare(Game o1, Game o2) {
        return o1.getId()-o2.getId();
    }

}

