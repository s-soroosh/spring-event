package seniorjava.spring.event;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import seniorjava.spring.event.CustomerInfo;
import seniorjava.spring.event.Order;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/18/13
 * Time: 10:30 PM
 */

@ContextConfiguration("classpath*:context.xml")
public class OrderTest extends AbstractJUnit4SpringContextTests {
    @Test
    public void you_can_see_messages_in_console_when_order_state_is_DELIVERED() {
        final Order order = new Order("111", new CustomerInfo("1234567", "soroosh.sarabadani@gmail.com"));
        order.checkOut();
        order.deliver();

    }

    @Test
    public void you_can_see_messages_in_console_when_order_state_is_POSTPONED() {
        final Order order = new Order("111", new CustomerInfo("12345", "soroosh.sarabadani@gmail.com"));
        order.checkOut();
        order.postponeDelivery();

    }
}
