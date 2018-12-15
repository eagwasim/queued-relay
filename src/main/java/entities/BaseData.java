package entities;

import constant.QueueStatusConstant;

import javax.persistence.*;

@Entity
public class BaseData {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(unique = true)
    private Integer data;
    private QueueStatusConstant queueStatus = QueueStatusConstant.DEQUEUED;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public QueueStatusConstant getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(QueueStatusConstant queueStatus) {
        this.queueStatus = queueStatus;
    }
}
