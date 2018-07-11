package _09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 11:02 ч.
 */
public abstract class BasicCollection {

    private List<String> collection;

    public BasicCollection() {
        this.collection = new ArrayList<>();
    }

    public List<String> getCollection() {
        return collection;
    }

    public void setCollection(List<String> collection) {
        this.collection = collection;
    }
}