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

import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author jayz
 */
public class Hex {

	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array).toLowerCase();
	}

	public static byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}
}
