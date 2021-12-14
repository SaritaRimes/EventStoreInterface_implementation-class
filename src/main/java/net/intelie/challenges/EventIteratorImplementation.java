package net.intelie.challenges;


public class EventIteratorImplementation implements EventIterator {
    /* I probably should implement those methods, but I'm wondering how to do this if
    *  the methods don't have input parameters.
    *  I believe it is a simple task, but I don't have experience with Java and can't say
    *  how the interfaces work together. */

    @Override
    public boolean moveNext() {
        return false;
    }

    @Override
    public Event current() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void close() throws Exception {

    }
}
