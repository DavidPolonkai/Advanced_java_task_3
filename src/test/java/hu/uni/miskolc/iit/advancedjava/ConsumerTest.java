package hu.uni.miskolc.iit.advancedjava;

import hu.uni.miskolc.iit.advancedjava.exceptions.StorageEmptyException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class ConsumerTest {
    final StoreReader mockStoreReader = mock(StoreReader.class);

    @Test
    @DisplayName("Test if consume calls the remove method of the storage")
    public void testIfConsumeCallsTheRemoveMethod() throws StorageEmptyException{
        //given
        final Consumer consumer = new Consumer(mockStoreReader);
        //when
        consumer.consume(anyInt());
        //then
        verify(mockStoreReader,times(1)).remove(anyInt());
    }

    @Test
    @DisplayName("Test if consume returns the correct value returned by remove method of the storage")
    public void testIfConsumeReturnsTheCorrectValue() throws StorageEmptyException{
        //given
        final Consumer consumer = new Consumer(mockStoreReader);
        final Product expectedProduct = new Product(1,"Alma");
        when(mockStoreReader.remove(1)).thenReturn(expectedProduct);
        //when
        Product actual = consumer.consume(1);
        //then
        assertThat(actual).isEqualTo(expectedProduct);
    }

    @Test
    @DisplayName("Test if consume throws the exception raised by remove method of the storage")
    public void testIfConsumeForwardsTheException() throws StorageEmptyException{
        //given
        final Consumer consumer = new Consumer(mockStoreReader);
        final Product expectedProduct = new Product(1,"Alma");
        when(mockStoreReader.remove(1)).thenThrow(StorageEmptyException.class);
        //when
        //then
        assertThatThrownBy(() -> consumer.consume(1)).isInstanceOf(StorageEmptyException.class);
    }




}