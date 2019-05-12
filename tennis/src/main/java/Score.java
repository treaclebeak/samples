class Score {
    private int[] gamePoints = new int[2];
    private int[][] sets = new int[3][2];
    private int currentSet = 0;

    private Score() {
    }

    static Score startingScore() {
        return new Score();
    }

    static Score processEvent(Tennis.Event e) {
        Score result = new Score();
        ++result.gamePoints[e.action.point ? e.player : (e.player + 1) % 2]; //who does the point belong to?
        return result;
    }

    int[] getGamePoints() {
        return gamePoints;
    }

    int[][] getSets() {
        return sets;
    }

    int getCurrentSet() {
        return currentSet;
    }

    Score accumulate(Score s) {
        Score result = new Score();
        gamePoints[0] += s.getGamePoints()[0];
        gamePoints[1] += s.getGamePoints()[1];
        if (gameOver()) {
            int setWinner = gamePoints[0] > gamePoints[1] ? 0 : 1;
            sets[getCurrentSet()][setWinner] += 1;
            gamePoints[0] = gamePoints[1] = 0;
            if (setOver()) {
                currentSet++;
            }
        }
        result.currentSet = currentSet;
        result.gamePoints = gamePoints;
        result.sets = sets;
        return result;
    }

    private boolean setOver() {
        return sets[getCurrentSet()][0] == 6 || sets[getCurrentSet()][1] == 6;
    }


    private boolean gameOver() {
        int p1Points = gamePoints[0];
        int p2Points = gamePoints[1];

        if (p1Points >= 3 && p2Points >= 3) {  //got to 40 all
            return Math.abs(p2Points - p1Points) == 2;  //need to win by 2
        }
        return p1Points == 4 || p2Points == 4;
    }

    String gameScore() {
        String result;
        int p1Points = gamePoints[0];
        int p2Points = gamePoints[1];

        if (p1Points >= 3 && p2Points >= 3) {
            if (p1Points == p2Points) {
                result = "40 40";
            } else {
                if (p1Points > p2Points) {
                    return "ADV 40";
                } else {
                    return "40 ADV";
                }

            }
        } else {
            p1Points = p1Points < 3 ? p1Points * 15 : 40;
            p2Points = p2Points < 3 ? p2Points * 15 : 40;
            result = p1Points + " " + p2Points;
        }
        return result;
    }
}
