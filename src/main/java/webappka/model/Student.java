package webappka.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private boolean graduated;
    private Double homeDistance;
    private LocalDate birthDate;

    // birthDate jest nazwą kolumny w bazie. Czasami baza nazywa kolumny z podkreślnikami i w tej sytuacji możemy napotkać problemy.
    @Formula("(year(now())-year(birthDate))")
    private Integer age;
}
