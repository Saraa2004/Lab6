package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int START = 1_000;
    private static final int STOP = 2_000;
    private static final int ELEMENTS = 100_000;
    private static final int READ = 1_000;
    private static final long AFRICA = 1_110_635_000L;
    private static final long ASIA = 4_298_723_000L;
    private static final long OCEANIA = 38_304_000L;
    private static final long EUROPE = 742_452_000L;
    private static final long ANTARCTICA = 0;
    private static final long AMERICAS = 972_005_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        final List<Integer> list = new ArrayList<>();
        for(int i = START; i < STOP; i++) {
            list.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        final List<Integer> llist = new LinkedList<>(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        final int e = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, e);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for(final int el : list) {
            System.out.println(el);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        for(int i = 0; i < ELEMENTS; i++) {
            list.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Time for adding " + ELEMENTS + " elements in ArrayList: " + time + " ns");
        time = System.nanoTime();
        for(int i = 0; i < ELEMENTS; i++) {
            llist.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Time for adding " + ELEMENTS + " elements in LinkedList: " + time + " ns");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        for(int i = 0; i < READ; i++) {
            list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Time for reading " + READ + " times in ArrayList: " + time + " ns");
        time = System.nanoTime();
        for(int i = 0; i < READ; i++) {
            llist.get(llist.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Time for reading " + READ + " times in LinkedList: " + time + " ns");


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA);
        map.put("Americas", AMERICAS);
        map.put("Antarctica", ANTARCTICA);
        map.put("Asia", ASIA);
        map.put("Europe", EUROPE);
        map.put("Oceania", OCEANIA);

        /*
         * 8) Compute the population of the world
         */

        long worldPopulation = 0;
        for(final long el : map.values()) {
            worldPopulation += el;
        }
        System.out.println("World Population: " + worldPopulation);
    }
}
