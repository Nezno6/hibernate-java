package zad_dom_pojazd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pojazd {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // `id` INT PRIMARY KEY AUTO_INCREMENT
    @Column(nullable = false)
    private String marka;
    @Column(nullable = false)
    private double moc;
    @Column(nullable = false)
    private String kolor;
    @Column(nullable = false)
    private int rokProdukcji;
    @Column(nullable = false)
    private boolean elektryczny;
}
