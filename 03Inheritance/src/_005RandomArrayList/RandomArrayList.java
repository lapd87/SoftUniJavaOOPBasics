package _005RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 11:35 ч.
 */
public class RandomArrayList extends ArrayList {

    public Object getRandomElement(){
        Random random = new Random();

        int randomIndex = random.nextInt(super.size());

        Object object = super.get(randomIndex);
        super.remove(object);

        return object;
    }
}