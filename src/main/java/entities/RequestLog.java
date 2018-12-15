package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RequestLog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    private BaseData requestedData;
    @ManyToOne
    private Client requestingClient;

    private Date dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseData getRequestedData() {
        return requestedData;
    }

    public void setRequestedData(BaseData requestedData) {
        this.requestedData = requestedData;
    }

    public Client getRequestingClient() {
        return requestingClient;
    }

    public void setRequestingClient(Client requestingClient) {
        this.requestingClient = requestingClient;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
