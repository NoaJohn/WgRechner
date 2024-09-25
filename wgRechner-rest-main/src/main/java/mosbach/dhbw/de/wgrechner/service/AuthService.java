package mosbach.dhbw.de.wgrechner.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import mosbach.dhbw.de.wgrechner.model.User;
//WIP einiges fehlt noch
@Service
public class AuthService {

    /*WIP Kommt noch?
    @Autowired
    private TokenBlacklist tokenBlacklist;
    */
    //Speichern des Entschluesselungskey in Umgbungsvariabel
    private String secretKey = EnvConfig.getJwtSecret();

    //2 Stunden Tokenzeit -> 1000*10 fuer 10 Sekunden
    private final long jwtExpiration = 1000 * 60 * 60 * 2;

    //Extrahiert explizit UserId WIP anpassbar?
    public String extractUserIdFromToken(String token) {
        System.err.println("Extracting username from token: " + token); //WIP debugging
        return extractClaimFromToken(token, Claims::getSubject); //digga keine Ahnung was hier passiert, aber der zweite :ist der zurückgegebene claim-inhalt
        //Claims::getSubject sehr kompliziert -> passiert interne überschreibung einer Methode "getSubject", damit getSubjekt zurückgegeben wird (ganz komisch)
    }
    //WIP jede extraClaim info aus Token rausziehen -> muss noch debuggen
    public String extractAnyExtraClaimFromToken(String token, String extraClaimRef) {
        Map<String, Object> claims = extractAllClaims(token);
        return (String) claims.get(extraClaimRef); // Zugriff auf Ref welche angegeben wird im Kopf
    }

    //Fuer das extrahieren eines Claims noetig -> kann sonst nichts -> siehe extractUserIdFromToken
    public <T> T extractClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        System.err.println("Extracting claim from token: " + token); //WIP fuer Debugging
        final Claims claims = extractAllClaims(token); //extrahiert alle claims -> siehe Methode
        return claimsResolver.apply(claims); //referenziert den inhalt des Claims auf anderer weise -> als Function<Claims,T> -> Claims ist eingabe, T rückgabewert
    }

    //Alle claims aus Token extrahieren -> gebündelt in einem claims objekt -> kann nichts -> siehe extractClaimFromToken
    private Claims extractAllClaims(String token) {
        System.err.println("Extracting all claims from token: " + token); //WIP fuer debugging
        return Jwts
                .parserBuilder() //mit Jwts -> ein Objekt um JWT's zu verarbeiten
                .setSigningKey(getSignInKey()) //setzen des Entschluesselungskey
                .build() //Bauen des Konfigurationsobjekt für den JWT
                .parseClaimsJws(token) //gibt Jws<Claims> Objekt -> beinhaltet Header, Claims und Signatur des Tokens
                .getBody(); //Gibt nur den Body vom Payload -> Also alle Claims (wie expiriation, sub, usw. -> Aufgebaut wie eine HashMap
    }


    //Baut Token ohne extra claims und ohne eigener Expiration
    public String generateToken(User user) {
        return generateToken(new HashMap<>(), user);
    }

    //Baut Token mit extraClaims und ohne eigener Expiration
    public String generateToken(Map<String, Object> extraClaims, User user) {
        return buildToken(extraClaims, user, jwtExpiration);
    }


    //Baut den Token mit extra Claims und eigener Expiration
    private String buildToken(Map<String, Object> extraClaims, User user, long expiration) {
        //JWTS wird kreiert, mit UserId als sub, Zeit und verschlüsselung von HS256 algorithmus
        //setClaims sind hierbei weitere Informationen -> wie eine HashMap
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUserId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /*WIP
    public boolean isTokenExpired(String token) {
        try{
            if(tokenBlacklist.isTokenBlacklisted(token)) {
                return true;
            }
            return extractExpirationFromToken(token).before(new Date());
        }
        catch (JwtException e){
            return true;
        }

    }*/

    //standartexpiration zurückgeben
    public long getExpirationTime() {
        return jwtExpiration;
    }

    //Verfallszeit aus einem Token extrahieren
    private Date extractExpirationFromToken(String token) {
        return extractClaimFromToken(token, Claims::getExpiration);
    }



    //Verifizieren oder signieren von JWT's -> Kann sonst nichts -> siehe generateVerificationToken
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Erstellen eines Verifizierungstokens -> Also JWT's -> Kann was!
    public String generateVerificationToken(User user) {
        return Jwts
                .builder()
                .setSubject(user.getUserId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /*WIP Blacklist kommt später
    public void invalidateToken(String token) {
        tokenBlacklist.blacklistToken(token);
    }*/
}
