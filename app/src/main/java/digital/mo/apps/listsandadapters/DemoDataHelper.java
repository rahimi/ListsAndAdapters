package digital.mo.apps.listsandadapters;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mohammadalirahimi on 03.11.16.
 */
public class DemoDataHelper {

    public static ArrayList<String> contents =
            new ArrayList<>(Arrays.asList(("Lorem ipsum dolor sit amet, consetetur " +
                    "sadipscing elitr, sed diam nonumy eirmod tempor "+
                    "invidunt ut labore et dolore magna aliquyam erat," +
                    " sed diam voluptua.").split(" ")));

    /* ArrayAdapter mantelt den String[] mit AbstractList, damit loest das hinzufuegen und entfernen
     *  eine UsupportedOperationxception aus!*/
     /*public static String[] contents =
                    ("Lorem ipsum dolor sit amet, consetetur " +
                    "sadipscing elitr, sed diam nonumy eirmod tempor "+
                    "invidunt ut labore et dolore magna aliquyam erat," +
                    " sed diam voluptua.").split(" ");*/


}
