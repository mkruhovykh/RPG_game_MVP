package maksym.kruhovykh.wekingsmonolith.mvp.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "gold", nullable = false)
    private Integer gold;

    @Column(name = "crystals", nullable = false)
    private Integer crystals;

    @Column(name = "battles_count", nullable = false)
    private Integer battlesCount;

    @Column(name = "max_battles_count", nullable = false)
    private Integer maxBattlesCount;

    @Column(name = "silver", nullable = false)
    private Integer silver;

    public void reduceSilver(int amount) {
        this.silver -= amount;
    }
}
