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
package coolbitx.sample.cbmnemonic.util;

import api.bc.ExtendedKey;
import api.bc.common.ValidationException;

/**
 *
 * @author jayz
 */
public class BIP44 {

    // Based on BIP044
    private static final int HIGH = 0x80000000;
    private final static int PURPOSE = 44 + HIGH;
    private final static int COIN_TYPE = 0 + HIGH;

    public final static ExtendedKey getKey(ExtendedKey m, int account, int change) throws ValidationException {
        return m.getChild(PURPOSE).getChild(COIN_TYPE).getChild(account + HIGH).getChild(change);
    }
}
