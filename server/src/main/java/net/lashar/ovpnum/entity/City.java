package net.lashar.ovpnum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true, nullable = false,length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
