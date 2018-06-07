package com.power.designpattern.iterator;

public class BookShelf implements Aggregate {
    private Book[] book;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.book = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return book[index];
    }

    public void appendBook(Book book) {
        this.book[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
