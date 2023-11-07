package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.FringeAccumulationStrategy;

import java.util.Deque;

/**
 * Breadth first accumulation.
 * 
 * @param <S>
 *            step type
 */
public final class BreadthFirst<S> implements FringeAccumulationStrategy<S> {

    /*
     * Singleton object: since the object is stateless, we don't need more than an instance.
     */
    private static final BreadthFirst<?> INSTANCE = new BreadthFirst<>();

    private BreadthFirst() {
    }

    /**
     * @param <S>
     *            the step type
     * @return an instance of a {@link DepthFirst}.
     */
    @SuppressWarnings("unchecked")
    public static <S> BreadthFirst<S> getInstance() {
        /*
         * Safe to cast: the actual generic type is irrelevant, as far as addToFringe is
         * used consistently.
         */
        return (BreadthFirst<S>) INSTANCE;
    }

    @Override
    public void addToFringe(final Deque<? super S> fringe, final S step) {
        fringe.addLast(step);
    }
}
