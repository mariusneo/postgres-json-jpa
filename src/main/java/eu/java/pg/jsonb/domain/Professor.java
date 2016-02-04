package eu.java.pg.jsonb.domain;

import eu.java.pg.jsonb.domain.info.ProfessorInfo;
import eu.java.pg.jsonb.types.JSONBUserType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@TypeDef(name = "professorJsonb", typeClass = JSONBUserType.class, parameters = {
        @Parameter(name = JSONBUserType.CLASS, value = "eu.java.pg.jsonb.domain.info.ProfessorInfo")})
public class Professor extends CommonPerson<ProfessorInfo> {

    @Type(type = "professorJsonb")
    @Column(name = "info")
    private ProfessorInfo info;

    public ProfessorInfo getInfo() {
        return info;
    }

    public void setInfo(ProfessorInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", info=" + info +
                '}';
    }
}
