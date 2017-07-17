package com.codurance.leaderboard;

class Points {

    static final int FIRST_POSITION_POINTS = 25;
    static final int SECOND_POSITION_POINTS = 18;
    static final int THIRD_POSITION_POINTS = 15;
    private static final Integer[] POINTS = new Integer[]{FIRST_POSITION_POINTS, SECOND_POSITION_POINTS, THIRD_POSITION_POINTS};

    static int pointsForPosition(int finishPosition) {
        if (finishPosition >= 0 && finishPosition < POINTS.length) {
            return POINTS[finishPosition];
        }
        return 0;
    }
}
