package com.example.demo.Entity;

        import org.springframework.data.annotation.CreatedDate;
        import org.springframework.stereotype.Component;

        import javax.persistence.*;
        import java.util.Date;

@Entity
@Table(name = "token_login")
@Component("LoginTokenBean")
public class LoginToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private int id;

    @Column(name = "login_user")
    private int user_id;

    @Column(name = "login_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date loginAt;

}
