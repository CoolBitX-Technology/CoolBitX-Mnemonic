/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbitx.sample.cbmnemonic.util;

import static javax.xml.bind.DatatypeConverter.parseHexBinary;
import static javax.xml.bind.DatatypeConverter.printHexBinary;
import api.bc.ExtendedKey;
import api.bc.common.ByteUtils;
import api.bc.common.Hash;
import api.bc.common.Key;

/**
 *
 * @author Jay Zhuang <jayz@coolbitx.com>
 */
public class WIF {

    public static String getWif(Key k0) {
        String k0priv = printHexBinary(k0.getPrivate());
        String wifraw = "80" + k0priv + "01";
        String cksum = printHexBinary(Hash.sha256(Hash.sha256(parseHexBinary(wifraw))));
        cksum = cksum.substring(0, 8);
        String wif = wifraw + cksum;

        wif = ByteUtils.toBase58(org.bouncycastle.util.encoders.Hex.decode(wif));
        return wif;
    }
}
