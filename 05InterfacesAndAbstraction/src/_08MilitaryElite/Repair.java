package _08MilitaryElite;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:16 ч.
 */
public class Repair {

    private String partName;
    private int hoursWorked;

    public Repair() {
    }

    public Repair(String partName, int hoursWorked) {
        setPartName(partName);
        setHoursWorked(hoursWorked);
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    private String getPartName() {
        return partName;
    }

    private int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",
                getPartName(),
                getHoursWorked());
    }
}