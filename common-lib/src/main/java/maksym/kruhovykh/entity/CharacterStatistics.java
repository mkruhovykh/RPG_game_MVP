package maksym.kruhovykh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "friends", nullable = false)
    private Integer friends;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @Column(name = "max_experience", nullable = false)
    private Integer maxExperience;

    @Column(name = "glory", nullable = false)
    private Integer glory;

    @Column(name = "clan", nullable = false)
    private String clan;

    @Column(name = "brotherhood", nullable = false)
    private String brotherhood;

    @Column(name = "victories", nullable = false)
    private Integer victories;

    @Column(name = "defeats", nullable = false)
    private Integer defeats;

    @Column(name = "loot_gained", nullable = false)
    private Integer lootGained;

    @Column(name = "loot_lost", nullable = false)
    private Integer lootLost;

    @Column(name = "items_gained", nullable = false)
    private Integer itemsGained;

    @Column(name = "minutes_on_expedition", nullable = false)
    private Integer minutesOnExpedition;

    @Column(name = "hours_on_site", nullable = false)
    private Integer hoursOnSite;
}
