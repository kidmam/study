package com.power.thread.readwritelock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Buffer {
    private final int capacity;
    private final Deque<String> recent;
    private int discarded;
    private final Lock readLock;
    private final Lock writeLock;

    public Buffer(int capacity) {
        this.capacity = capacity;
        recent = new ArrayDeque<>(capacity);
        final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    public void putItem(String item) {
        writeLock.lock();
        try {
            while (recent.size() >= capacity) {
                recent.removeFirst();
                ++discarded;
            }
            recent.addLast(item);
        } finally {
            writeLock.unlock();
        }
    }

    public List<String> getRecent() {
        readLock.lock();
        try {
            final ArrayList<String> result = new ArrayList<>();
            result.addAll(recent);
            return result;
        } finally {
            readLock.unlock();

        }
    }

        public int getDiscardedCount() {
            readLock.lock();
            try {
                return discarded;
            } finally {
                readLock.unlock();
            }
        }

        public int getTotal() {
            readLock.lock();
            try {
                return discarded + recent.size();
            } finally {
                readLock.unlock();
            }
        }


        public void flush() {
            writeLock.lock();
            try {
                discarded += recent.size();
                recent.clear();
            } finally {
                writeLock.unlock();
            }
        }


}
