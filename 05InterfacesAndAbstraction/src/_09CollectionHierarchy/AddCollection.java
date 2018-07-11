package _09CollectionHierarchy;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 11:20 ч.
 */
public class AddCollection extends BasicCollection implements Addable {

    public AddCollection() {
        super();
    }

    @Override
    public int add(String item) {

        List<String> tempCollection = getCollection();

        tempCollection.add(item);

        setCollection(tempCollection);

        return tempCollection.size() - 1;
    }
}