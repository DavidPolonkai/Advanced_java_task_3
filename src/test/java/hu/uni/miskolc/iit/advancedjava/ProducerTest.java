package hu.uni.miskolc.iit.advancedjava;

import hu.uni.miskolc.iit.advancedjava.exceptions.StorageFullException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class ProducerTest {
    private final StoreWriter mockStoreWriter = mock(StoreWriter.class);

    @Test
    @DisplayName("Test if produce calls the add method of the storage")
    public void testIfConsumeCallsTheAddMethod() throws StorageFullException {
        //given
        final Producer producer = new Producer(mockStoreWriter);
        //when
        producer.produce(1, "product1");
        //then
        verify(mockStoreWriter, times(1)).add(any());
    }

    @Test
    @DisplayName("Test if produce throws the exception raised by add method of the storage")
    public void testIfProduceForwardsTheException() throws StorageFullException {
        //given
        final Producer producer = new Producer(mockStoreWriter);
        doThrow(StorageFullException.class).when(mockStoreWriter).add(anyObject());
        //when
        //then
        assertThatThrownBy(() -> producer.produce(1, "product1")).isInstanceOf(StorageFullException.class);
    }
}