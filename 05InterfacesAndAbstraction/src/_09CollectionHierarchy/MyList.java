package _09CollectionHierarchy;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 13:59 ч.
 */
public class MyList extends BasicAddCollection implements Removable, Sizeable {

    public MyList() {
        super();
    }

    @Override
    public String remove() {
        List<String> tempCollection = getCollection();

        String item = tempCollection
                .remove(0);

        setCollection(tempCollection);

        return item;
    }

    @Override
    public int used() {
        return getCollection().size();
    }
}