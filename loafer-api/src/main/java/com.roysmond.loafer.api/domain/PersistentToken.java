package com.roysmond.loafer.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by w on 2017/5/2.
 */
@Setter
@Getter
@Entity
@Table(name = "persistent_token")
public class PersistentToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int MAX_USER_AGENT_LEN = 255;

    @Id
    private String series;

    @JsonIgnore
    @NotNull
    @Column(name = "token_value", nullable = false)
    private String tokenValue;

    @Column(name = "token_date")
    private LocalDate tokenDate;

    @Size(min = 0, max = 39)
    @Column(name = "ip_address", length = 39)
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @JsonIgnore
    @ManyToOne
    private User user;

    public void setUserAgent(String userAgent) {
        if (userAgent.length() > MAX_USER_AGENT_LEN) {
            this.userAgent = userAgent.substring(0, MAX_USER_AGENT_LEN - 1);
        } else {
            this.userAgent = userAgent;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersistentToken)) return false;

        PersistentToken that = (PersistentToken) o;

        return getSeries() != null ? getSeries().equals(that.getSeries()) : that.getSeries() == null;
    }

    @Override
    public int hashCode() {
        return getSeries() != null ? getSeries().hashCode() : 0;
    }
}
