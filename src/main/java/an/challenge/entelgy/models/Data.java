package an.challenge.entelgy.models;

import java.io.Serializable;

public class Data implements Serializable {

    private int id;
    private String last_name;
    private String email;

    public Data() {}

    public Data(int id, String last_name, String email) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
