package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:19 ч.
 */
public class State {

    private String state;

    public State() {
    }

    public State(String state) {
        setState(state);
    }

    private void setState(String state) {
        if ("inProgress".equals(state)
                || "Finished".equals(state)) {
            this.state = state;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getState() {
        return state;
    }

    public void CompleteMission() {
        setState("Finished");
    }

    @Override
    public String toString() {
        return getState();
    }
}