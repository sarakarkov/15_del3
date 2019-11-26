package Model.Field;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

// Oprettet test på en metode i klassen "StreetField"
// Erklærer testobjektet "Iskiosken" som en lokal variabel for StreetFieldTest
// Kalder metoden på testobjektet som det ene parameter, og det forventede resultat som det andet parameter
// Testen er bestået

public class StreetFieldTest {

    StreetField Iskiosken = new StreetField("Iskiosken", "$1", "Bli kølet ned", 1, new Color(135, 210, 255));

    @Test
    public void getRent() {

        assertEquals(Iskiosken.getRent(), 1);
    }
}