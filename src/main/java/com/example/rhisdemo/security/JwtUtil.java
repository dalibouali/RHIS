package com.example.rhisdemo.security;


import com.example.rhisdemo.entities.Affectation;
import com.example.rhisdemo.entities.Droit;
import com.example.rhisdemo.entities.Role;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.repositories.AffectationRepository;
import com.example.rhisdemo.repositories.DroitRepository;
import com.example.rhisdemo.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class JwtUtil {
    private UserRepository userRepository;
    private AffectationRepository affectationRepository;
    private DroitRepository droitRepository;
    public JwtUtil(UserRepository userRepository,AffectationRepository affectationRepository,DroitRepository droitRepository){
        this.userRepository=userRepository;
        this.affectationRepository=affectationRepository;
        this.droitRepository=droitRepository;
    }
    private String SECRET_KEY = "secret";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Set<String> Userroles = new HashSet<>();
        User user = userRepository.findUserByUsername(userDetails.getUsername());
        List<Affectation> affectations =affectationRepository.findByUser(user.getId());
        for(Affectation a:affectations){

            List<Droit> droits=droitRepository.findAllByRole(a.getRole().getId());


            for(Droit d:droits){
                System.out.println(d.getEcran().getName());
                claims.put(d.getEcran().getName(),d.getCum());
            }

        }


        return createToken(claims, userDetails.getUsername(),userDetails.getAuthorities());
    }

    private String createToken(Map<String, Object> claims, String subject, Collection<? extends GrantedAuthority> authorities) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
