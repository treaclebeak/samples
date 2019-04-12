class Tennis {
    public enum Action {
        DOUBLE_FAULT(false), OUT(false), WINNER(true);

        boolean point;
        Action(boolean playersPoint) {
            this.point = playersPoint;
        }
    }

    static class Event {
        Action action;
        int player;

        Event(Action action, int player) {
            this.action = action;
            this.player = player;
        }
    }
}
