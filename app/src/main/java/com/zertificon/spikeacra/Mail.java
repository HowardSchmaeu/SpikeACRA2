package com.zertificon.spikeacra;

/**
 * Created by MSC on 09.06.2015.
 */
public class Mail {
    int id = -1;

    String name = null;

    public Mail(int i) {
        id = i;
    }

    public Mail() {
    }

    public char getName() {
        return name.charAt(9);
    }

}
