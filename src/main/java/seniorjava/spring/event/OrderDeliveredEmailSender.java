package seniorjava.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/18/13
 * Time: 11:47 PM
 */
@Service
public class OrderDeliveredEmailSender implements ApplicationListener<OnOrderDelivered>,Ordered {

    @Override
    public void onApplicationEvent(OnOrderDelivered event) {
        System.out.println(String.format("Message sent for delivered order to:%s ORDER-ID:%s",event.getOrder().getCustomerInfo().getEmail(),event.getOrder().getOrderId()));
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
