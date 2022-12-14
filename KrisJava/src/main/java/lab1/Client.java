package lab1;

import java.util.Objects;

/**
 * The type Client.
 */
public class Client extends Person
{
    /**
     * The Phone number.
     */
    protected final String phoneNumber;
    /**
     * The id order.
     */
    protected final int idOrder;

    /**
     * Instantiates a new Client.
     *
     * @param CB the cb
     */
    public Client(ClientBuilder CB)
    {
        super(CB);
        this.phoneNumber = CB.phoneNumber;
        this.idOrder = CB.idOrder;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets id order.
     *
     * @return the id order
     */
    public int getIdOrder() {
        return idOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return idOrder == client.idOrder && Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, idOrder);
    }

    @Override
    public String toString() {
        return "Client{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", idOrder=" + idOrder +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * The type Client builder.
     */
    public final static class ClientBuilder extends PersonBuilder
    {
        /**
         * The Phone number.
         */
        protected String phoneNumber;
        /**
         * The Id order.
         */
        protected int idOrder;

        /**
         * Instantiates a new Client builder.
         */
        ClientBuilder(){};

        /**
         * Sets phone number.
         *
         * @param phoneNumber the phone number
         * @return the phone number
         */
        public ClientBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Sets id order.
         *
         * @param idOrder the id order
         * @return the id order
         */
        public ClientBuilder setIdOrder(int idOrder) {
            this.idOrder = idOrder;
            return this;
        }
        public Person build()
        {
            return new Client(this);
        }
    }
}
