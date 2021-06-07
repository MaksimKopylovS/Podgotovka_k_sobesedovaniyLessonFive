package max_sk.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Integer mark;

    public Students(String name, int mark){
            this.name = name;
            this.mark = mark;
    }

}
