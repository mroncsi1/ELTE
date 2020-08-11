import java.util.Arrays;

import static com.kosprov.jargon2.api.Jargon2.*;

public class Main {

    public static void main(String[] args) {
        byte[] salt = "this is a salt".getBytes();
        byte[] password = "this is a password".getBytes();

        Type type = Type.ARGON2d;
        int memoryCost = 65536;
        int timeCost = 3;
        int parallelism = 4;
        int hashLength = 23;

        // Configure the hasher
        Hasher hasher = jargon2Hasher()
                .type(type)
                .memoryCost(memoryCost)
                .timeCost(timeCost)
                .parallelism(parallelism)
                .hashLength(hashLength);

        // Configure the verifier with the same settings as the hasher
        Verifier verifier = jargon2Verifier()
                .type(type)
                .memoryCost(memoryCost)
                .timeCost(timeCost)
                .parallelism(parallelism);

        // Set the salt and password to calculate the raw hash
        byte[] rawHash = hasher.salt(salt).password(password).rawHash();

        System.out.printf("Hash: %s%n", Arrays.toString(rawHash));

        // Set the raw hash, salt and password and verify
        boolean matches = verifier.hash(rawHash).salt(salt).password(password).verifyRaw();

        System.out.printf("Matches: %s%n", matches);
    }
}
