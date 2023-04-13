package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;
    @Mock
    CellPhone cellPhone;
    @Mock
    Car car;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deliveryDriver = new DeliveryDriver("test",car,cellPhone);

    }

    @Test
    void itShouldWasteTime() {
        //given
boolean expected= true;
when(cellPhone.browseCatMemes()).thenReturn(true);
        //when
boolean actual = deliveryDriver.wasteTime();
        //then
        assertEquals(expected,actual);
    }

    @Test
    void itShouldRefuel() {
        //given
boolean expected= true;
when(car.fillTank(7)).thenReturn(true);
        //when
boolean actual = deliveryDriver.refuel(7);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void itShouldContactCustomer() {
        //given
boolean expected = true;
when(cellPhone.call(deliveryDriver.cellPhone.toString())).thenReturn(true);
        //when
boolean actual= deliveryDriver.contactCustomer(deliveryDriver.cellPhone.toString());
        //then
        assertEquals(expected,actual);
    }

}