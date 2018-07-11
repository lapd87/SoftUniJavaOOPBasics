package _05BorderControl;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 13:00 ч.
 */
public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        setModel(model);
        setId(id);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}