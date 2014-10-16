package sample.data.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.User;
import sample.data.jpa.model.UserRole;


@Service
@Transactional
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        List<GrantedAuthority> authorities =
                buildUserAuthority(null);
        return null;
    }

    private User buildUserForAuthentication(User user,
            List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(),
                user.isEnabled(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<GrantedAuthority> list) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (GrantedAuthority userRole : list) {
            setAuths.add(new SimpleGrantedAuthority(((UserRole) userRole).getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
