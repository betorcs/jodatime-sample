package org.devmaster.sample;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void compareHrsAndMintsOnly() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY, 8);
        c1.set(Calendar.MINUTE, 30);


        Calendar c2 = (Calendar) c1.clone();
        c2.set(Calendar.HOUR_OF_DAY, 9);
        c2.set(Calendar.MINUTE, 30);

        Calendar now = (Calendar) c1.clone();
        now.set(Calendar.HOUR_OF_DAY, 8);
        now.set(Calendar.MINUTE, 55);

        assertTrue(Util.compareHrsAndMintsOnly(c1.getTime(), now.getTime(), c2.getTime()));


        now.set(Calendar.HOUR_OF_DAY, 7);
        assertFalse(Util.compareHrsAndMintsOnly(c1.getTime(), now.getTime(), c2.getTime()));

        now.set(Calendar.HOUR_OF_DAY, 10);
        assertFalse(Util.compareHrsAndMintsOnly(c1.getTime(), now.getTime(), c2.getTime()));

        now = (Calendar) c2.clone();
        assertFalse(Util.compareHrsAndMintsOnly(c1.getTime(), now.getTime(), c2.getTime()));
    }

}