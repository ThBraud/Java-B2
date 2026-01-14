package tp.example.tp.jpa;

import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
}



