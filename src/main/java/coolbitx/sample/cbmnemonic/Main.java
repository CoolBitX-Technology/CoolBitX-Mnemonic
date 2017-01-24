/*
 * Copyright (C) 2017 jayz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package coolbitx.sample.cbmnemonic;

import api.bc.ExtendedKey;
import api.bc.common.ValidationException;
import coolbitx.sample.cbmnemonic.util.BIP39;
import coolbitx.sample.cbmnemonic.util.BIP44;

/**
 *
 * @author jayz
 */
public class Main {

    public static void main(String[] args) throws Exception {
        new Main().testCoolBitXMnemonic();
    }           

    private void testCoolBitXMnemonic() throws ValidationException {
        // Sample CoolBitX mnemonic
        String cbMnemonic = "591320 068789 099176 253583 105646 289515 528779 203443";
        
        // Generate seed with the same algorithm used in BIP039, empty passphrase:
        // "...we use the PBKDF2 function with a mnemonic sentence (in UTF-8 NFKD) used 
        // as the password and the string "mnemonic" + passphrase (again in UTF-8 NFKD)
        // used as the salt. The iteration count is set to 2048 and HMAC-SHA512 is used
        // as the pseudo-random function. The length of the derived key is 512 bits 
        // (= 64 bytes). ..."
        byte[] seed = BIP39.getSeed(cbMnemonic, "");

        // Create master node with master seed.
        ExtendedKey m = ExtendedKey.create(seed);
        
        // Derive account based on BIP44
        ExtendedKey ka = BIP44.getKey(m, 0, 0);
        
        // Print first 5 addresses of the first account.
        for (int i = 0; i < 5; i++) {
            String addr = ka.getChild(i).getAddress();
            System.out.println("acct 0 ,idx:" + i + " ,addr:" + addr);
        }
    }

}
