package it.unibo.generics.graph.api;

import java.util.Deque;

/**
 * Provides a method to accumulate to the fringe.
 *
 * @param <S>
 *            the step type
 */
public interface FringeAccumulationStrategy<S> {

    /**
     * @param fringe
     *            the queue representing the fringe
     * @param step
     *            the step to add
     */
    void addToFringe(Deque<? super S> fringe, S step);

}
