package test.constance;

import ru.skypro.ListOfIntegersImpl;

public class ConstanceListTest {
    public static final ListOfIntegersImpl EMPTY_LIST = new ListOfIntegersImpl();
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;


    public static ListOfIntegersImpl LS_5 () {
        ListOfIntegersImpl list = new ListOfIntegersImpl(5);
        list.add(ZERO);
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
        list.add(FOUR);
        return list;
    }
}
