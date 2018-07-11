package _09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 14:26 ч.
 */
public abstract class BasicAddCollection extends BasicCollection implements Addable{

    public BasicAddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        List<String> tempCollection = new ArrayList<>();

        tempCollection.add(item);

        tempCollection.addAll(getCollection());

        setCollection(tempCollection);

        return 0;
    }

}