package jpaswing.projectspotiy.entityContent.entity.several;

import java.io.Serial;
import java.io.Serializable;

public class Restrictions implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String reason;

    // Getters and Setters
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

