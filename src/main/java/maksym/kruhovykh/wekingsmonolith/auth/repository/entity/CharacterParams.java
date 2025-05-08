package maksym.kruhovykh.wekingsmonolith.auth.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterParams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(name = "defense", nullable = false)
    private Integer defense;

    @Column(name = "agility", nullable = false)
    private Integer agility;

    @Column(name = "mastery", nullable = false)
    private Integer mastery;

    @Column(name = "vitality", nullable = false)
    private Integer vitality;

    @Column(name = "health", nullable = false)
    private Integer health;

    @Column(name = "max_health", nullable = false)
    private Integer maxHealth;

    @Column(name = "health_regen", nullable = false)
    private Integer healthRegen;

}
