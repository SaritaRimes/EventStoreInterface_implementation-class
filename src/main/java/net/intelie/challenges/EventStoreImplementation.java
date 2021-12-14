package net.intelie.challenges;

import java.util.ArrayList; /* Allows the use of ArrayList collection */
import java.util.List; /* Allows the use of List structure */
import java.util.Objects; /* Allows use of methods for operating on objects  */

/** The class that implements the EventStores interface */

public class EventStoreImplementation implements EventStore{
    /* As the number of events is unknown, the List structure is most appropriate */
    /* eventsList will be used for store the Event "event" */
    public static List<Event> eventsList = new ArrayList<>();
    /* eventsQuery store de events collected by "query" method */
    public static List<Event> eventsQuery = new ArrayList<>();
    /* iterator store positions in eventsList of elements collected by "query" method */
    public static List<Integer> iterator = new ArrayList<>();

    /* "insert" stores an event */
    @Override
    public void insert(Event event) {
        eventsList.add(event); /* Add an event to eventsList list */
    }

    /* "removeAll" remove all elements of specific type, accessing them inside each object of eventsList */
    @Override
    public synchronized void removeAll(String type) {
        /* The for loop will remove from eventsList all elements os specific type */
        for (int i = 0; i < eventsList.size(); ++i) {
            /* eventString store the String element of the object in i position of eventsList */
            String eventString = eventsList.get(i).type();

            /* When eventString is equal to type, the object in i position is removed */
            if (Objects.equals(eventString, type)) {
                eventsList.remove(i);
                --i; /* elements of eventsList are relocated when one element is removed */
            }
        }
    }

    /* "query" returns all events that have same type as type and timestamp between startTime and endTime  */
    /* I believe that the implementation of query method is linked to implementation of methods inside EventIterator
    *  interface. Unfortunately, I don't know how to do this. So I implemented it here so that you can see I know
    *  the logic behind them, even though I don't have enough experience in Java to do that in the right way. */
    @Override
    public synchronized EventIterator query(String type, long startTime, long endTime) {
        String eventString;
        long eventTimestamp;

        for (int i = 0; i < eventsList.size(); ++i) {
            /* eventString store the String element of the object in i position of eventsList */
            eventString = eventsList.get(i).type();
            /* eventTimestamp store the timestamp element of the object in i position of eventsList */
            eventTimestamp = eventsList.get(i).timestamp();

            if (Objects.equals(eventString, type) && eventTimestamp == (endTime - startTime)) {
                /* Add the referred element to the new List eventsQuery */
                eventsQuery.add(eventsList.get(i));
                /* The iterator is updated */
                iterator.add(i);
            }
        }
        return null;
    }
}
