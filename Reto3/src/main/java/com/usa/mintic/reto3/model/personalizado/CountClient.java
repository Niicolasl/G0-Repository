package com.usa.mintic.reto3.model.personalizado;

import com.usa.mintic.reto3.model.Client;

public class CountClient {
    private Long total;
    private Client client;

    public CountClient(Long aLong, Client client) {

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
