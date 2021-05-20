package hu.uni.miskolc.iit.advancedjava;

import hu.uni.miskolc.iit.advancedjava.exceptions.StorageEmptyException;


public interface StoreReader {
    Product remove(int id) throws StorageEmptyException;

    int getProductCount();
}
