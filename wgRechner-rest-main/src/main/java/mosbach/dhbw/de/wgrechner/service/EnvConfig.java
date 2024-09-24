package mosbach.dhbw.de.wgrechner.service;

//Umgebungsvariablen zum speichern von wichtigen Informationen
//Besser als im Code hardcodieren (Best Practices :) -> Braucht man für JWT
public class EnvConfig {

    public static String getSmtpHost() {
        return System.getenv("SMTP_HOST");
    }

    public static int getSmtpPort() {
        return Integer.parseInt(System.getenv("SMTP_PORT"));
    }

    public static String getSmtpUsername() {
        return System.getenv("SMTP_USERNAME");
    }

    public static String getSmtpPassword() {
        return System.getenv("SMTP_PASSWORD");
    }

    public static String getJwtSecret() {
        return System.getenv("JWT_SECRET");
    }
}
