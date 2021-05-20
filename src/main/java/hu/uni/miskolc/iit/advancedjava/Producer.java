package hu.uni.miskolc.iit.advancedjava;

import hu.uni.miskolc.iit.advancedjava.exceptions.StorageFullException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producer {
    private StoreWriter storeWriter;

    public void produce(int id, String name) throws StorageFullException {
        Product product = new Product(id,name);
        storeWriter.add(product);
    }
}
