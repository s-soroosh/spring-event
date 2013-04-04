package seniorjava.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/18/13
 * Time: 11:45 PM
 */
public abstract class OnOrderStatusChanged extends ApplicationEvent {

    private final Order order;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never <code>null</code>)
     */
    public OnOrderStatusChanged(Order source) {
        super(source);
        this.order = source;
        System.out.println(String.format("Order:%s status is changed to %s", source.getOrderId(), source.getStatus()));
    }

    public Order getOrder() {
        return order;
    }
}
