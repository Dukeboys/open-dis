package edu.nps.moves.dis;

import java.util.ArrayList;
import java.util.List;

/** @version $Id:$ */
public class PduCollection {

    List<Pdu> pdus;

    public PduCollection() {
        pdus = new ArrayList<Pdu>();
    }

    public List<Pdu> getPdus() {
        return pdus;
    }

    public void setPdus(List<Pdu> pdus) {
        this.pdus = pdus;
    }
}
