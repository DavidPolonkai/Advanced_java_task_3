package hu.uni.miskolc.iit.advancedjava;

import hu.uni.miskolc.iit.advancedjava.exceptions.StorageEmptyException;
import hu.uni.miskolc.iit.advancedjava.exceptions.StorageFullException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer {
    private StoreReader storeReader;

    public Product consume(int id) throws StorageEmptyException {
        return storeReader.remove(id);
    }
}
