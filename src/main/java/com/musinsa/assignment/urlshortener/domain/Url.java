package com.musinsa.assignment.urlshortener.domain;

import com.musinsa.assignment.urlshortener.common.Base62;
import com.musinsa.assignment.urlshortener.common.Utils;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Url extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private int count = 1;

    @Type(type="org.hibernate.type.NumericBooleanType")
    @Column(nullable = false , columnDefinition = "bit", length = 1)
    private Boolean sslYn = false;

    @Builder
    public Url(String path){
        this.path = removePrefixPath(path);
        this.sslYn = Utils.isSslPath(path);
    }

    private String removePrefixPath(String path){
        return path.replaceFirst("http://", "")
                   .replaceFirst("https://","");
    }

    public void increaseCount(){
        this.count += 1;
    }

    public boolean isValidPath(){
        return Utils.isValidPath(this.path);
    }

    public String getShorten(){
        return new Base62().encode(getId());
    }


}
