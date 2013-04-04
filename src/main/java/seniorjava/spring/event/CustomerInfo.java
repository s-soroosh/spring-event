package seniorjava.spring.event;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/18/13
 * Time: 11:35 PM
 */
@Configurable
public class CustomerInfo {
    private final String phone;

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    private final String email;

    public CustomerInfo(String phone    , String email) {
        this.phone = phone;
        this.email = email;
    }
}
