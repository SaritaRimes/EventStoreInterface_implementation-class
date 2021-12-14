# Implement EventStore

In this project, a class that implements the `EventStore` interface were created.

```java
public interface EventStore {
    void insert(Event event);

    void removeAll(String type);

    EventIterator query(String type, long startTime, long endTime);
}
```

The events were store in memory using List data structures, and some resource were used to provide thread-safety.
