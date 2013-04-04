package seniorjava.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/19/13
 * Time: 12:18 AM
 */
@Service
public class OnOrderDeliveredPost implements ApplicationListener<OnOrderDelivered>,Ordered {
    @Override
    public void onApplicationEvent(OnOrderDelivered onOrderDelivered) {
        System.out.println(String.format("Order:%s is posting for customer.",onOrderDelivered.getOrder().getOrderId()));
    }

    @Override
    public int getOrder() {
        return 1000;
    }
}
