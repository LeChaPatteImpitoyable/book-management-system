package com.ying.background.services.customer;

import com.ying.background.model.Customer;

public interface ICustomerService {

    public Customer login(String telephone, String password, String clientIp, String appType);
}
