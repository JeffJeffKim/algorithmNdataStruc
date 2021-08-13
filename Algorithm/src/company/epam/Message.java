package company.epam;

import java.util.Map;

public class Message {
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


//    How many items will be added to the map if below class is used as 'key'
class Key{
    String value ;
    //getters and setters
    public int hashCode(){
        return 1;
    }
}

public class Main {
    public static void main(String args[])
    Map<Key,Object> map= new Hashmap();
    Key key1 = new Key("1");
    Key key2 = new Key("2");
    map.put(key1, new Object());
    map.put(key2, new Object());
}
}

enrty[] = {linkedlist, linkedlist, ...}
entry[0].linkedlist[0] = Key("1")
entry[0].linkedlist[1] = Key("2")