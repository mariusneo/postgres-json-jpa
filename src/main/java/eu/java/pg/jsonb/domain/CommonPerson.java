package eu.java.pg.jsonb.domain;

import eu.java.pg.jsonb.domain.info.Info;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "person")
public abstract class CommonPerson<T extends Info> extends Person {

    public abstract void setInfo(T info);

    public abstract T getInfo();
}
