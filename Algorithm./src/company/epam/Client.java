package company.epam;

public class Client {

    private Message message;
//    private String value;

    public Client(Message message) {
        this.message = clone(message);
    }

    public Message clone(Message message) {
        Message newObj = new Message();
        newObj.setValue(message.getValue());
        return newObj;
    }

//    client.getMessage().setValue("Bye");

    public Message getMessage() {
        return this.clone(message);
    }

//    public String getValue() {
//        return message.getValue();
//    }
}




