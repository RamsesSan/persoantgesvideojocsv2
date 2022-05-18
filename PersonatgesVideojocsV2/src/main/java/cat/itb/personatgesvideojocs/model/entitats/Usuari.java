package cat.itb.personatgesvideojocs.model.entitats;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Usuari implements UserDetails {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String matchingPassword;
    private String avatar;
    @NotNull
    private String rol = "USER";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuari(Long id, String username, String password, String matchingPassword, String avatar, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.avatar = avatar;
        this.rol = "USER";
    }
}

