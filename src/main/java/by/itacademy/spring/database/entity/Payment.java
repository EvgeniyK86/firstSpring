package by.itacademy.spring.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id",
            referencedColumnName = "id")
    private User receiver;

}
