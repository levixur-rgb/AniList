package kg.levixur.anilist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;

    public Card() {}

    public Card(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }
}