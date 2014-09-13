//package sample.data.jpa.model;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//
//public class UserDetailsSecurity extends User implements UserDetails {
//
//    private static final long serialVersionUID = 1231241234L;
//
//    public UserDetailsSecurity(User user) {
//        if (user != null) {
//            this.setId(user.getId());
//            this.setAddress(user.getAddress());
//            this.setDateOfBirth(user.getDateOfBirth());
//            this.setIndexNo(user.getIndexNo());
//            this.setName(user.getName());
//            this.setSemester(user.getSemester());
//            this.setSurname(user.getSurname());
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        Set<Role> userRoles = this.getRoles();
//        if (userRoles != null)
//        {
//            for (Role role : userRoles) {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//                authorities.add(authority);
//            }
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getLogin();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
