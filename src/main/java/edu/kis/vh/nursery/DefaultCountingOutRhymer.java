package edu.kis.vh.nursery;

/**
 * Implementation of a "Counting Out Rhymer" using a fixed-size stack data structure.
 * Models the traditional children's counting-out game where players are eliminated
 * in a circle based on a counting rhyme. Uses stack operations to track the current
 * state of counted players/numbers.
 *
 * Capacity is fixed at 12 elements (common for counting-out games).
 */
public class DefaultCountingOutRhymer {

    /** Maximum number of elements the stack can hold (12 players/numbers) */
    private static final int CAPACITY = 12;

    /** Sentinel value indicating empty stack (-1) */
    private static final int EMPTY_RHYMER_INDICATOR = -1;

    /** Return value when stack operations are called on empty stack (-1) */
    private static final int IF_EMPTY = -1;

    /** Fixed-size array backing the stack implementation */
    private final int[] numbers = new int[CAPACITY];

    /**
     * Returns the current total count of elements in the stack.
     *
     * @return the total number of elements currently stored in the stack
     */
    public int getTotal() {
        return total;
    }

    private int total = EMPTY_RHYMER_INDICATOR;

    /**
     * Adds an integer to the stack (increments total and stores value).
     * Only adds if stack is not full.
     *
     * @param in the integer value to add to the stack
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if no elements are stored (total == EMPTY_RHYMER_INDICATOR), false otherwise
     */
    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    /**
     * Checks if the stack has reached maximum capacity.
     *
     * @return true if total equals CAPACITY - 1, false otherwise
     */
    public boolean isFull() {
        return total == CAPACITY - 1;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element if stack is not empty, IF_EMPTY otherwise
     */
    protected int getPeekaboo() {
        if (callCheck())
            return IF_EMPTY;
        return numbers[total];
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element if stack is not empty, IF_EMPTY otherwise
     */
    public int countOut() {
        if (callCheck())
            return IF_EMPTY;
        return numbers[total--];
    }

}
