package _09CollectionHierarchy;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.6.2018 г.
 * Time: 11:39 ч.
 */
public class AddRemoveCollection extends BasicAddCollection implements Removable {

    public AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {

        List<String> tempCollection = getCollection();

        String item = tempCollection
                .remove(tempCollection.size() - 1);

        setCollection(tempCollection);
        return item;
    }
}