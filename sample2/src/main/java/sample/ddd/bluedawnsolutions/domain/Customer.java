package sample.ddd.bluedawnsolutions.domain;

class Customer {

    private String emailAddress;

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
