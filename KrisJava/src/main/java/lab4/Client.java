package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Client extends Person
{

    protected final String phoneNumber;

    protected final int idOrder;

    public Client(ClientBuilder CB)
    {
        super(CB);
        this.phoneNumber = CB.phoneNumber;
        this.idOrder = CB.idOrder;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

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
                '}';
    }

    public final static class ClientBuilder extends PersonBuilder
    {
        @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "it isn't a phone")
        protected String phoneNumber;
        @NotNull
        protected int idOrder;

        ClientBuilder(){};

        public ClientBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ClientBuilder setIdOrder(int idOrder) {
            this.idOrder = idOrder;
            return this;
        }
        public Person build()
        {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<ClientBuilder>> constraintViolations = validator.validate(this);
            if(constraintViolations.size() > 0) {
                String errors = constraintViolations.stream().map(constraintViolation -> {
                    String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                    String message = constraintViolation.getMessage();
                    return String.join(" : ", fieldName, message);
                }).collect(Collectors.joining("\n"));
                throw new IllegalArgumentException(errors);
            }
            return new Client(this);
        }
    }
}
