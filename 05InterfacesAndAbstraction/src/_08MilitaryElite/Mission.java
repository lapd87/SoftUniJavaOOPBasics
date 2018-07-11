package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:19 ч.
 */
public class Mission {

    private String codeName;
    ;
    private State state;

    public Mission() {
    }

    public Mission(String codeName, State state) {
        setCodeName(codeName);
        setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(State state) {
        this.state = state;
    }

    private String getCodeName() {
        return codeName;
    }

    private State getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                getCodeName(),
                getState());
    }
}