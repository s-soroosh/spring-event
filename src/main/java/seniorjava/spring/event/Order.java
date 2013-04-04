package seniorjava.spring.event;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.Date;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/18/13
 * Time: 10:28 PM
 */
@Configurable
public class Order implements ApplicationEventPublisherAware {
    private final String orderId;
    private final Date createDate;
    private final CustomerInfo customerInfo;
    private ApplicationEventPublisher eventPublisher;
    private Date lastUpdateDate;
    private Status status;

    public Order(String orderId, CustomerInfo customerInfo) {
        this.orderId = orderId;
        this.customerInfo = customerInfo;
        status = Status.MODIFIABLE;
        this.createDate = new Date();
        this.lastUpdateDate = this.createDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void checkOut() {
        if (status == Status.DELIVERED) {
            throw new IllegalStateException(String.format("Order is already delivered"));
        }
        this.status = Status.CHECKED_OUT;
        this.lastUpdateDate = new Date();
    }

        public void deliver() {
        if (this.status != Status.CHECKED_OUT && this.status != Status.POSTPONED) {
            throw new IllegalStateException(String.format("Order status should be CHECKED OUT for delivery to be called. but is : %s", status));
        }

        this.status = Status.DELIVERED;
        this.lastUpdateDate = new Date();
        this.eventPublisher.publishEvent(new OnOrderDelivered(this));
    }

    public void postponeDelivery() {
        if (status != Status.CHECKED_OUT && status != Status.POSTPONED) {
            throw new IllegalStateException(String.format("Can not postpone delivery in this state: %s", status));
        }
        this.status = Status.POSTPONED;
        this.lastUpdateDate = new Date();
        this.eventPublisher.publishEvent(new OnOrderPostponed(this));
    }

    public Status getStatus() {
        return status;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static enum Status {
        MODIFIABLE,
        CHECKED_OUT,
        POSTPONED,
        DELIVERED,
        CANCELED;
    }
}
