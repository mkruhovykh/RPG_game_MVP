package maksym.kruhovykh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "game_character")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "param_id", nullable = false)
    private CharacterParams params;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id", nullable = false)
    private CharacterStatistics statistics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", nullable = false)
    private CharacterInventory inventory;
}
