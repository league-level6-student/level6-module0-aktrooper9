package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    @Mock
    BakeryService bakery;
    @Mock
    PaymentService payment;
    @Mock
    DeliveryService delivery;
    @Mock
    Order mockOrder;
    @BeforeEach
    void setUp() {
    MockitoAnnotations.openMocks(this);
    myDonutShop= new MyDonutShop(payment,delivery,bakery);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
Order order= new Order("Name","Number",12,24,"CredCard",true);
        //when
    myDonutShop.takeOrder(order);
        //then
        verify(myDonutShop, times(1)).takeOrder(order);
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given

        //when

        //then
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

        //when

        //then
    }

}